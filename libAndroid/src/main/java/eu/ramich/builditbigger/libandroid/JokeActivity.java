package eu.ramich.builditbigger.libandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;


public class JokeActivity extends AppCompatActivity {

    private static final String TAG = JokeActivity.class.getName();
    public static final String JOKE = "joke";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView tvJoke = findViewById(R.id.tv_joke);
        String joke = getIntent().getStringExtra(JOKE);
        if (joke != null) {
            tvJoke.setText(joke);
        } else {
            Log.d(TAG, "An error occurred");
        }
    }
}
