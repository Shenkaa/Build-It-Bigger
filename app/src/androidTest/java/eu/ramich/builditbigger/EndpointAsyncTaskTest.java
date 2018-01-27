package eu.ramich.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertNotNull;


@RunWith(AndroidJUnit4.class)
public class EndpointAsyncTaskTest {


    @Test
    public void testNonEmpty() {
        String result = null;
        EndpointAsyncTask endpointAsyncTask = new EndpointAsyncTask(null);
        endpointAsyncTask.execute();

        try {
            result = endpointAsyncTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }
}
