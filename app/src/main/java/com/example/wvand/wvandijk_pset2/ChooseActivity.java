package com.example.wvand.wvandijk_pset2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;

public class ChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        // Get intent that was created in MainActivity
        Intent intent = getIntent();
        intent.getSerializableExtra("story");
    }

    // Method that's called when simple button is clicked
    public void goSimple(View view) {

        // Instantiate a textfile
        InputStream text = getResources().openRawResource(R.raw.madlib0_simple);

        // Instantiate a simple story, so it can be passed to intent
        Story simpletext = new Story(text);

        // Create new intent to direct user to second activity
        Intent secondActivity = new Intent(ChooseActivity.this, SecondActivity.class);
        secondActivity.putExtra("story", simpletext);
        startActivity(secondActivity);
    }

    // Method that's called when tarzan button is clicked
    public void goTarzan(View view) {

        // Instantiate a textfile
        InputStream text = getResources().openRawResource(R.raw.madlib1_tarzan);

        // Instantiate a simple story, so it can be passed to intent
        Story simpletext = new Story(text);

        // Create new intent to direct user to second activity
        Intent secondActivity = new Intent(ChooseActivity.this, SecondActivity.class);
        secondActivity.putExtra("story", simpletext);
        startActivity(secondActivity);
    }

    // Method that's called when university button is clicked
    public void goUniversity(View view) {

        // Instantiate a textfile
        InputStream text = getResources().openRawResource(R.raw.madlib2_university);

        // Instantiate a simple story, so it can be passed to intent
        Story simpletext = new Story(text);

        // Create new intent to direct user to second activity
        Intent secondActivity = new Intent(ChooseActivity.this, SecondActivity.class);
        secondActivity.putExtra("story", simpletext);
        startActivity(secondActivity);
    }

    // Method that's called when clothes button is clicked
    public void goClothes(View view) {

        // Instantiate a textfile
        InputStream text = getResources().openRawResource(R.raw.madlib3_clothes);

        // Instantiate a simple story, so it can be passed to intent
        Story simpletext = new Story(text);

        // Create new intent to direct user to second activity
        Intent secondActivity = new Intent(ChooseActivity.this, SecondActivity.class);
        secondActivity.putExtra("story", simpletext);
        startActivity(secondActivity);
    }

    // Method that's called when dance button is clicked
    public void goDance(View view) {

        // Instantiate a textfile
        InputStream text = getResources().openRawResource(R.raw.madlib4_dance);

        // Instantiate a simple story, so it can be passed to intent
        Story simpletext = new Story(text);

        // Create new intent to direct user to second activity
        Intent secondActivity = new Intent(ChooseActivity.this, SecondActivity.class);
        secondActivity.putExtra("story", simpletext);
        startActivity(secondActivity);
    }

}
