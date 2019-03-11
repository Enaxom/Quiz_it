package com.morgane.quizit;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class BackDialog extends Dialog implements android.view.View.OnClickListener {

    private Activity activity;

    @SuppressWarnings("WeakerAccess")
    protected BackDialog(Activity activity) {
        super(activity);
        this.activity = activity;
        this.setCancelable(false);
        if (this.getWindow() != null) {
            this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_back);
        Button menu = findViewById(R.id.btn_menu);
        Button resume = findViewById(R.id.btn_resume);
        menu.setOnClickListener(this);
        resume.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_menu:
                Intent intent = new Intent(activity, MainActivity.class);
                activity.startActivity(intent);
                break;
            case R.id.btn_resume:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}
