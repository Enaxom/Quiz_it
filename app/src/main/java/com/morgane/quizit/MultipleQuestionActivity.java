package com.morgane.quizit;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MultipleQuestionActivity extends AppCompatActivity {

    ProgressBar progress;
    MyCountDownTimer countTimer;
    ArrayList<Questions> questions;
    int number;
    Questions question;
    Button but_one, but_two, but_three, but_four;
    GradientDrawable one, two, three, four;
    Intent intent;

    @Override
    @SuppressWarnings("ConstantConditions")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_question);
        progress = findViewById(R.id.progressbar);

        number = getIntent().getExtras().getInt("number");

        App app = (App) getApplicationContext();
        questions = app.list;

        // Answer buttons
        but_one = findViewById(R.id.btn_one);
        but_two = findViewById(R.id.btn_two);
        but_three = findViewById(R.id.btn_three);
        but_four = findViewById(R.id.btn_four);

        // Buttons background
        one = (GradientDrawable) but_one.getBackground();
        two = (GradientDrawable) but_two.getBackground();
        three = (GradientDrawable) but_three.getBackground();
        four = (GradientDrawable) but_four.getBackground();

        question = questions.get(number);

        fill();
        themeColors();

        countTimer = new MyCountDownTimer(15000, 10);
        countTimer.start();

        but_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countTimer.cancel();
                boolean win = checkAnswer(but_one.getText().toString());

                if (win) {
                    one.setColor(Color.parseColor("#2f9926"));
                    win();
                } else {
                    one.setColor(Color.RED);
                    fail();
                }
            }
        });

        but_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countTimer.cancel();
                boolean win = checkAnswer(but_two.getText().toString());

                if (win) {
                    two.setColor(Color.parseColor("#2f9926"));
                    win();
                } else {
                    two.setColor(Color.RED);
                    fail();
                }
            }
        });

        but_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countTimer.cancel();
                boolean win = checkAnswer(but_three.getText().toString());

                if (win) {
                    three.setColor(Color.parseColor("#2f9926"));
                    win();
                } else {
                    three.setColor(Color.RED);
                    fail();
                }
            }
        });

        but_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countTimer.cancel();
                boolean win = checkAnswer(but_four.getText().toString());

                if (win) {
                    four.setColor(Color.parseColor("#2f9926"));
                    win();
                } else {
                    four.setColor(Color.RED);
                    fail();
                }
            }
        });
    }

    public void fail() {
        //TODO box Game Over : replay, return menu

        Toast.makeText(this, "Game Over !", Toast.LENGTH_SHORT).show();
        returnMenu();
    }

    public void win() {
        //TODO nice transition with the next question

        number ++;


        int type = questions.get(number).getType();

        if (type == 1) {
            intent = new Intent(MultipleQuestionActivity.this, MultipleQuestionActivity.class);
        } else if (type == 2) {
            intent = new Intent(MultipleQuestionActivity.this, TrueFalseActivity.class);
        } else {
            intent = new Intent(MultipleQuestionActivity.this, ImageQuestionActivity.class);
        }

        intent.putExtra("number", number);
        startActivity(intent);
    }

    public void fill() {
        TextView quest = findViewById(R.id.tv_question);
        TextView no = findViewById(R.id.tv_no);
        int num = number + 1;
        String sNum = num + "";

        String[] answers = question.getAnswers();

        quest.setText(question.getQuestion());
        no.setText(sNum);

        but_one.setText(answers[0]);
        but_two.setText(answers[1]);
        but_three.setText(answers[2]);
        but_four.setText(answers[3]);
    }

    public void themeColors() {
        Themes theme = question.getTheme();
        String cTech = "#08a3ce";
        String cCult = "#aa0505";
        String cAnim = "#d65f04";
        String cScie = "#1c890d";
        String bg = "#c6c6c6";

        one.setColor(Color.parseColor(bg));
        two.setColor(Color.parseColor(bg));
        three.setColor(Color.parseColor(bg));
        four.setColor(Color.parseColor(bg));

        if (theme == Themes.TECH) {

            one.setStroke(4, Color.parseColor(cTech));
            two.setStroke(4, Color.parseColor(cTech));
            three.setStroke(4, Color.parseColor(cTech));
            four.setStroke(4, Color.parseColor(cTech));

        } else if (theme == Themes.CULTURE) {

            one.setStroke(4, Color.parseColor(cCult));
            two.setStroke(4, Color.parseColor(cCult));
            three.setStroke(4, Color.parseColor(cCult));
            four.setStroke(4, Color.parseColor(cCult));

        } else if (theme == Themes.ANIMALS) {

            one.setStroke(4, Color.parseColor(cAnim));
            two.setStroke(4, Color.parseColor(cAnim));
            three.setStroke(4, Color.parseColor(cAnim));
            four.setStroke(4, Color.parseColor(cAnim));

        } else if (theme == Themes.SCIENCE) {

            one.setStroke(4, Color.parseColor(cScie));
            two.setStroke(4, Color.parseColor(cScie));
            three.setStroke(4, Color.parseColor(cScie));
            four.setStroke(4, Color.parseColor(cScie));

        }
    }

    public boolean checkAnswer(String answer) {
        return question.isValid(answer);
    }

    public void returnMenu() {
        intent = new Intent(MultipleQuestionActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            int progressTime = (int) ((millisUntilFinished/100)/1.5);
            progressTime = (int) ((15000/100)/1.5) - progressTime;

            if (progressTime >= 35 && progressTime < 60) {
                progress.setProgressTintList(ColorStateList.valueOf(Color.rgb(255, 224, 53)));
            } else if (progressTime >= 55 && progressTime < 80) {
                progress.setProgressTintList(ColorStateList.valueOf(Color.rgb(249,148,47)));
            } else if (progressTime >= 75) {
                progress.setProgressTintList(ColorStateList.valueOf(Color.rgb(246, 41, 41)));
            }

            progress.setProgress(progress.getMax() - progressTime);
        }

        @Override
        public void onFinish() {
            fail();
        }
    }

}
