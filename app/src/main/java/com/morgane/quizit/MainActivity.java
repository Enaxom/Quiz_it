package com.morgane.quizit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MultipleQuestion test = new MultipleQuestion(Themes.TECH, "Quelle est la réponse", "La réponse", "Wrong", "Wrong", "Wrong");
    }
}
