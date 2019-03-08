package com.morgane.quizit;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ArrayList<Questions> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void readFill(Themes theme) {
        // multiple_questions.csv -> 6 columns : THEME ; question ; answer ; wrong ; wrong ; wrong
        // true_false_questions.csv -> 3 columns : THEME ; question ; answer (0/1)
        // image_question.csv -> 7 columns : THEME ; question ; drawable ; answer ; wrong ; wrong ; wrong

        if (theme == Themes.ALL) {
            fillAll();
        } else {
            fill(theme);
        }
    }

    public void fill(Themes pTheme) {
        BufferedReader br = null;
        questions = new ArrayList<>();
        try {
            String currentLine;
            br = new BufferedReader(new InputStreamReader(getAssets().open("multiple_questions.csv")));

            while ((currentLine = br.readLine()) != null) {
                String[] row = currentLine.split(";");
                Themes theme = Themes.fromString(row[0]);

                if (pTheme.toString().equals(row[0])) {
                    Questions question = new MultipleQuestion(theme, row[1], row[2], row[3], row[4], row[5]);
                    questions.add(question);
                }
            }

            br.close();
            br = new BufferedReader(new InputStreamReader(getAssets().open("true_false_questions.csv")));

            while ((currentLine = br.readLine()) != null) {
                String[] row = currentLine.split(";");
                Themes theme = Themes.fromString(row[0]);

                if (pTheme.toString().equals(row[0])) {
                    Questions question = new TrueFalse(theme, row[1], (row[2].equals("1") ? "True" : "False"));
                    questions.add(question);
                }
            }

            br.close();
            br = new BufferedReader(new InputStreamReader(getAssets().open("image_question.csv")));

            while ((currentLine = br.readLine()) != null) {
                String[] row = currentLine.split(";");
                Themes theme = Themes.fromString(row[0]);

                if (pTheme.toString().equals(row[0])) {
                    Resources resources = getApplicationContext().getResources();
                    final int resourceId = resources.getIdentifier(row[2].split("\\.")[0], "drawable", getPackageName());
                    Drawable img = ContextCompat.getDrawable(this, resourceId);

                    Questions question = new ImageQuestion(theme, row[1], img, row[3], row[4], row[5], row[6]);
                    questions.add(question);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.shuffle(questions);
    }

    public void fillAll() {
        BufferedReader br = null;
        questions = new ArrayList<>();
        try {
            String currentLine;
            br = new BufferedReader(new InputStreamReader(getAssets().open("multiple_questions.csv")));

            while ((currentLine = br.readLine()) != null) {
                String[] row = currentLine.split(";");
                Questions question = new MultipleQuestion(Themes.fromString(row[0]), row[1], row[2], row[3], row[4], row[5]);
                questions.add(question);
            }

            br.close();
            br = new BufferedReader(new InputStreamReader(getAssets().open("true_false_questions.csv")));

            while ((currentLine = br.readLine()) != null) {
                String[] row = currentLine.split(";");
                Questions question = new TrueFalse(Themes.fromString(row[0]), row[1], (row[2].equals("1") ? "True" : "False"));
                questions.add(question);
            }

            br.close();
            br = new BufferedReader(new InputStreamReader(getAssets().open("image_question.csv")));

            while ((currentLine = br.readLine()) != null) {
                String[] row = currentLine.split(";");
                Resources resources = getApplicationContext().getResources();
                final int resourceId = resources.getIdentifier(row[2].split("\\.")[0], "drawable", getPackageName());
                Drawable img = ContextCompat.getDrawable(this, resourceId);

                Questions question = new ImageQuestion(Themes.fromString(row[0]), row[1], img, row[3], row[4], row[5], row[6]);
                questions.add(question);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.shuffle(questions);
    }

    public void play() {
        Intent intent;
        int type = questions.get(0).getType();
        int number = 0;

        if (type == 1) {
            intent = new Intent(MainActivity.this, MultipleQuestionActivity.class);
        } else if (type == 2) {
            intent = new Intent(MainActivity.this, TrueFalseActivity.class);
        } else {
            intent = new Intent(MainActivity.this, ImageQuestionActivity.class);
        }

        intent.putExtra("number", number);

        App app = (App) getApplicationContext();
        app.list = questions;

        startActivity(intent);
    }

    public void playAll(View view) {
        Log.d("THEME", "all");
        readFill(Themes.ALL);
        play();
    }

    public void playTech(View view) {
        Log.d("THEME", "tech");
        readFill(Themes.TECH);
        play();
    }

    public void playCulture(View view) {
        Log.d("THEME", "cult");
        readFill(Themes.CULTURE);
        play();
    }

    public void playAnimal(View view) {
        Log.d("THEME", "anim");
        readFill(Themes.ANIMALS);
        play();
    }

    public void playScience(View view) {
        Log.d("THEME", "scie");
        readFill(Themes.SCIENCE);
        play();
    }
}
