package com.morgane.quizit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MultipleQuestion test = new MultipleQuestion(Themes.TECH, "Quelle est la réponse", "La réponse", "Wrong", "Wrong", "Wrong");
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
