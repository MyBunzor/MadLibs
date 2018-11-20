package com.example.wvand.wvandijk_pset2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);;

        // Get story from second activity
        Intent intent = getIntent();
        String retrievedStory = intent.getStringExtra("fullstory");

        // Get access to textview in layout so we can change it
        TextView story = findViewById(R.id.textStory);
        story.setText(retrievedStory);
    }

    // Method attached to reset button, leading back to MainActivity
    public void reSet(View view) {

        Intent reset = new Intent(ThirdActivity.this, MainActivity.class);
        startActivity(reset);
    }

}
