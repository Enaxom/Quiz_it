package com.morgane.quizit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // Find a way to make the lists

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void readFill(String filename) {
        // multiple_questions.csv -> 6 columns : THEME ; question ; answer ; wrong ; wrong ; wrong
        // true_false_questions.csv -> 3 columns : THEME ; question ; answer (0/1)
        // image_question.csv -> 7 columns : THEME ; question ; drawable ; answer ; wrong ; wrong ; wrong


    }

    public void playAll(View view) {
        Intent k = new Intent(MainActivity.this, MultipleQuestionActivity.class);
        startActivity(k);
    }

    public void playTech(View view) {
        Intent k = new Intent(MainActivity.this, TrueFalseActivity.class);
        startActivity(k);
    }

    public void playCulture(View view) {
        Intent k = new Intent(MainActivity.this, ImageQuestionActivity.class);
        startActivity(k);
    }

    public void playAnimal(View view) {
        return;
    }

    public void playScience(View view) {
        return;
    }

}
