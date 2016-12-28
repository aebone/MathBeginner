package edu.depaul.csc472.mathbeginner.util;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.widget.TextView;

import edu.depaul.csc472.mathbeginner.R;

/**
 * Created by meline on 11/15/15.
 */

public class CountDown {
    private Handler handler;
    private TextView TextTimeLeft;
    private boolean IsPaused;
    private CountDownListener listener;
    private int TimeLeft;

    private Runnable countDownTask = new Runnable () {
        @Override
        public void run() {
            if (!IsPaused) {
                TimeLeft--;
                displayTime ();
                handler.postDelayed (this, 100);
                if (TimeLeft == 0) {
                    pauseCountDown ();
                    if (listener != null)
                        listener.onCountDownFinished ();
                }
            }
        }
    };

    private void displayTime () {
        Context context = TextTimeLeft.getContext ();
        String timerPrefix = context.getResources ().getString (R.string.time_left_text);                      TextTimeLeft.setText(timerPrefix + (Double.toString(TimeLeft / 10.0)));
        if (TimeLeft < 100) {
            TextTimeLeft.setTextColor(Color.RED);
        }
    }

    public void pauseCountDown () {
        IsPaused = true;
    }

    public void startCountDown () {
        IsPaused = false;
        handler.post (countDownTask);
    }

    public void setCountDownListener (CountDownListener listener) {
        this.listener = listener;
    }

    public CountDown (TextView tv, int seconds) {
        TextTimeLeft = tv;
        TimeLeft = seconds * 10;
        handler = new Handler ();
    }
}
