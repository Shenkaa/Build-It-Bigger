package eu.ramich.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import eu.ramich.builditbigger.backend.myApi.MyApi;


public class EndpointAsyncTask extends AsyncTask<Void, Void, String> {

    private TaskCompletedListener taskCompletedCallback;
    private static MyApi myApiService = null;


    EndpointAsyncTask(TaskCompletedListener callback) {
        taskCompletedCallback = callback;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // change YOUR_IP to:
                    // a) 10.0.2.2 is localhost's IP address in Android emulator
                    // b) IP address of your device (PC, notebook, etc.) for real devices
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://YOUR_IP:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    })
                    .setApplicationName(EndpointAsyncTask.class.getName());
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.tellJoke().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (taskCompletedCallback != null) {
            taskCompletedCallback.onTaskCompleted(result);
        }
    }


    public interface TaskCompletedListener {
        void onTaskCompleted(String joke);
    }
}
