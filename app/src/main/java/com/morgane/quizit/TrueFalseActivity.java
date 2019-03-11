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

import java.util.ArrayList;

public class TrueFalseActivity extends AppCompatActivity {

    ProgressBar progress;
    MyCountDownTimer countTimer;
    ArrayList<Questions> questions;
    int number;
    Button but_true, but_false;
    GradientDrawable bt_true, bt_false;
    Questions question;
    Intent intent;

    @Override
    @SuppressWarnings("ConstantConditions")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_false);
        progress = findViewById(R.id.progressbar);

        Intent intent = getIntent();
        number = intent.getExtras().getInt("number");

        App app = (App) getApplicationContext();
        questions = app.list;

        // Buttons
        but_true = findViewById(R.id.btn_true);
        but_false = findViewById(R.id.btn_false);

        // Buttons background
        bt_true = (GradientDrawable) but_true.getBackground();
        bt_false = (GradientDrawable) but_false.getBackground();

        question = questions.get(number);

        fill();
        themeColors();

        countTimer = new MyCountDownTimer(15000, 10);
        countTimer.start();

        but_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countTimer.cancel();
                boolean win = checkAnswer(but_true.getText().toString());

                if (win) {
                    bt_true.setColor(Color.parseColor("#2f9926"));
                    win();
                } else {
                    bt_true.setColor(Color.RED);
                    fail();
                }
            }
        });

        but_false.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countTimer.cancel();
                boolean win = checkAnswer(but_false.getText().toString());

                if (win) {
                    bt_false.setColor(Color.parseColor("#2f9926"));
                    win();
                } else {
                    bt_false.setColor(Color.RED);
                    fail();
                }
            }
        });
    }

    public void fail() {
        GameOverDialog dialog = new GameOverDialog(TrueFalseActivity.this);
        dialog.show();
    }

    public void win() {
        //TODO nice transition with the next question

        number ++;

        if (questions.size() != number) {
            int type = questions.get(number).getType();

            if (type == 1) {
                intent = new Intent(TrueFalseActivity.this, MultipleQuestionActivity.class);
            } else if (type == 2) {
                intent = new Intent(TrueFalseActivity.this, TrueFalseActivity.class);
            } else {
                intent = new Intent(TrueFalseActivity.this, ImageQuestionActivity.class);
            }

            intent.putExtra("number", number);
            startActivity(intent);
        } else {
            WinDialog dialog = new WinDialog(TrueFalseActivity.this);
            dialog.show();
        }
    }

    public void fill() {
        TextView quest = findViewById(R.id.tv_question);
        TextView no = findViewById(R.id.tv_no);
        int num = number + 1;
        String sNum = num + "";

        quest.setText(question.getQuestion());
        no.setText(sNum);
    }

    public void themeColors() {
        Themes theme = question.getTheme();
        String cTech = "#08a3ce";
        String cCult = "#aa0505";
        String cAnim = "#d65f04";
        String cScie = "#1c890d";
        String bg = "#c6c6c6";

        bt_true.setColor(Color.parseColor(bg));
        bt_false.setColor(Color.parseColor(bg));

        if (theme == Themes.TECH) {

            bt_true.setStroke(4, Color.parseColor(cTech));
            bt_false.setStroke(4, Color.parseColor(cTech));

        } else if (theme == Themes.CULTURE) {

            bt_true.setStroke(4, Color.parseColor(cCult));
            bt_false.setStroke(4, Color.parseColor(cCult));

        } else if (theme == Themes.ANIMALS) {

            bt_true.setStroke(4, Color.parseColor(cAnim));
            bt_false.setStroke(4, Color.parseColor(cAnim));

        } else if (theme == Themes.SCIENCE) {

            bt_true.setStroke(4, Color.parseColor(cScie));
            bt_false.setStroke(4, Color.parseColor(cScie));

        }
    }

    public boolean checkAnswer(String answer) {
        return question.isValid(answer);
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

    @Override
    public void onBackPressed() {
        BackDialog dialog = new BackDialog(TrueFalseActivity.this);
        dialog.show();
    }

}
