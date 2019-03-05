package com.morgane.quizit;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

public class MultipleQuestionActivity extends AppCompatActivity {

    ProgressBar progress;
    MyCountDownTimer countTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_question);

        progress = findViewById(R.id.progressbar);
        countTimer = new MyCountDownTimer(10000, 100);
        countTimer.start();
    }

    public class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            int progressTime = (int) (millisUntilFinished/100);
            progress.setProgress(progress.getMax() - progressTime);
        }

        @Override
        public void onFinish() {
            finish();
        }
    }

}
