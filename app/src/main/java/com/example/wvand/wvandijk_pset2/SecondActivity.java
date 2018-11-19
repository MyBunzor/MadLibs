package com.example.wvand.wvandijk_pset2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    Button buttonOK ;
    EditText editText;
    TextView wordsleft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Retrieve the instantiated simple story
        Intent intent = getIntent();
        Story retrievedStory = (Story) intent.getSerializableExtra("story");

        // Let user know how many words left to fill
        wordsleft = findViewById(R.id.textWordsleft);
        int count = retrievedStory.getPlaceholderCount();
        wordsleft.setText("There are " + count + " words left!");

        // Let user know what kind of wordtype needs to be filled in
        editText = findViewById(R.id.editText);
        String wordtype = retrievedStory.getNextPlaceholder();
        editText.setHint(wordtype);

        // Set clicklistener on button in layout
        Button buttonOK;
        buttonOK = findViewById(R.id.buttonOK);
        buttonOK.setOnClickListener(new saveWords());
    }

    // Method that saves word which is typed in when button is clicked
    private class saveWords implements Button.OnClickListener {

        // Retrieve the instantiated simple story
        Intent intent = getIntent();
        Story retrievedStory = (Story) intent.getSerializableExtra("story");

        // Get SharedPreferences to store words in we update story with
        SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();

        @Override
        public void onClick(View v) {

            // Get access to editText and button to use later
            editText = findViewById(R.id.editText);
            buttonOK = findViewById(R.id.buttonOK);

            // Put word that user gave in string
            String typedin = editText.getText().toString();

            // Save typedin in SharedPreferences
            editor.putString("word", typedin);
            editor.apply();

            // Retrieve typed in word from SharedPreferences
            SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
            String savedWord = prefs.getString("word", "");

            // Fill in retrieved story with saved word
            retrievedStory.fillInPlaceholder(savedWord);

            // Let user know what kind of wordtype needs to be filled in
            editText = findViewById(R.id.editText);
            String wordtype = retrievedStory.getNextPlaceholder();
            editText.setHint(wordtype);

            // Update textview to let user know how many words left to fill
            int count = retrievedStory.getPlaceholderRemainingCount();

            if (count == 1) {
                wordsleft.setText("There is " + count + " word left!");
            }
            else {
                wordsleft.setText("There are " + count + " words left!");
            }

            // Clear text in EditText after user submitted a word
            editText.getText().clear();

            // If all words in story have been filled, go to third activity.
            if (retrievedStory.isFilledIn() == true) {

                // Create intent for activity three, pass along updated story
                Intent activityThree = new Intent(SecondActivity.this, ThirdActivity.class);
                activityThree.putExtra("fullstory", retrievedStory.toString());
                startActivity(activityThree);
            }
        }

    }







}
