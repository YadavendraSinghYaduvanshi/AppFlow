package com.yadu.appflow;

import android.graphics.LightingColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

import com.yadu.appflow.progressbar.CircularProgressBar;

public class OneQADActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_qad);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        btn4 = (Button) findViewById(R.id.btn_4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

        btn2.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // 0x6D6D6D sets how much to darken - tweak as desired
                        setColorFilter(v, 0x6D6D6D);
                        break;
                    // remove the filter when moving off the button
                    // the same way a selector implementation would
                    case MotionEvent.ACTION_MOVE:
                        Rect r = new Rect();
                        v.getLocalVisibleRect(r);
                        if (!r.contains((int) event.getX(), (int) event.getY())) {
                            setColorFilter(v, null);
                        }
                        break;
                    case MotionEvent.ACTION_OUTSIDE:
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP:
                        setColorFilter(v, null);
                        break;
                }
                return false;
            }

            private void setColorFilter(View v, Integer filter) {
                if (filter == null) v.getBackground().clearColorFilter();
                else {
                    // To lighten instead of darken, try this:
                    // LightingColorFilter lighten = new LightingColorFilter(0xFFFFFF, filter);
                    LightingColorFilter darken = new LightingColorFilter(filter, 0x000000);
                    v.getBackground().setColorFilter(darken);
                }
                // required on Android 2.3.7 for filter change to take effect (but not on 4.0.4)
                v.getBackground().invalidateSelf();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final CircularProgressBar c2 = (CircularProgressBar) findViewById(R.id.circularprogressbar1);
        c2.setTitle("June");
        c2.setSubTitle("");

        new CountDownTimer(20000, 1000) {

            public void onTick(long millisUntilFinished) {
                //mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
                c2.setTitle( millisUntilFinished / 1000 + "");
                c2.setProgress(((int)millisUntilFinished / 1000)*5);
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                c2.setTitle( "Time Up");
                //mTextField.setText("done!");
            }

        }.start();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.btn_1:

                //btn1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                int durationMillis = 2000;
                TransitionDrawable transition = (TransitionDrawable) btn1.getBackground();
                transition.startTransition(durationMillis);

                break;

            case R.id.btn_2:

                //btn2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                break;

            case R.id.btn_3:

                //btn3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                break;

            case R.id.btn_4:

                //btn4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                break;

        }
    }
}
