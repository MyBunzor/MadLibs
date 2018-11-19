package com.example.wvand.wvandijk_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.InputStream;
import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    InputStream textsimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate a textfile
        textsimple = getResources().openRawResource(R.raw.madlib0_simple);
    }

    /* This method is connected to the button in the activity and will send
        us to the chooseactivity when clicked.
     */
    public void getStarted(View view) {

        // Instantiate a story
        Story simpletext = new Story(textsimple);

        // Redirect user to second activity with simple story
        Intent activityTwo = new Intent(MainActivity.this, SecondActivity.class);
        activityTwo.putExtra("story", (Serializable) simpletext);
        startActivity(activityTwo);
    }
}
