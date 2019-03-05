package com.morgane.quizit;

import android.animation.ObjectAnimator;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ProgressBar;

public class MultipleQuestionActivity extends AppCompatActivity {

    ProgressBar progress;
    MyCountDownTimer countTimer;
    //Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_question);

        progress = findViewById(R.id.progressbar);
        //button = findViewById(R.id.btn_one);
        //GradientDrawable drawable = (GradientDrawable) button.getBackground();
        //drawable.setStroke(3, Color.RED);

        countTimer = new MyCountDownTimer(15000, 10);
        countTimer.start();
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
            finish();
        }
    }

}
