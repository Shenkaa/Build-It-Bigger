package eu.ramich.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import eu.ramich.builditbigger.libandroid.JokeActivity;


public class MainActivity extends AppCompatActivity
        implements EndpointAsyncTask.TaskCompletedListener {

    private EndpointAsyncTask endpointAsyncTask;
    private ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = findViewById(R.id.pb_loading);
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (endpointAsyncTask != null) {
            endpointAsyncTask.cancel(true);
            endpointAsyncTask = null;
        }
    }

    public void tellJoke(View view) {
        mProgressBar.setVisibility(View.VISIBLE);

        if (endpointAsyncTask == null) {
            endpointAsyncTask = new EndpointAsyncTask(this);
            endpointAsyncTask.execute();
        }
    }

    private void jokeReceived() {
        mProgressBar.setVisibility(View.GONE);

        MainActivityFragment fragment = (MainActivityFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment);

        if (fragment != null) {
            fragment.setJokeRequested();
        }
    }

    @Override
    public void onTaskCompleted(String joke) {
        jokeReceived();

        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE, joke);
        startActivity(intent);
    }
}
