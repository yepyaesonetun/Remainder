package com.awitd.remainder.Model;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.awitd.remainder.MainActivity;
import com.awitd.remainder.R;

import java.util.concurrent.TimeUnit;

/**
 * Created by ACER on 16/04/2016.
 */
public class ProgressActivity extends AppCompatActivity{
    private static long TIMER_LENGTH = 30;


TextView tvTime,tvlabel;
    Long timeR;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        //This code is the animation transaction for that activity...
        overridePendingTransition(R.anim.show_from_bottom, R.anim.hide_to_bottom);


        //This line for the action bar title hiding...
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);


        MainActivity ma = new MainActivity();
        final TimerView mTimerView;
        tvTime = (TextView)findViewById(R.id.textViewTitleLabel);
        tvlabel = (TextView) findViewById(R.id.textViewlabel);
        tvlabel.setText(ma.title_label+"\n");
        tvTime.setText(ma.hour + "h " + ma.min + "m "
                + ma.sec + "s");
        tvTime.setTextSize((float) 50.0);

        timeR = Long.valueOf(((((Long.parseLong(ma.hour)*60)*60)+((Long.parseLong(ma.min)*60)))*1000)+(Long.parseLong(ma.sec)*1000));
        Log.e("timeR:", timeR + "");

        final CounterClass timer = new CounterClass(timeR,1000);
        timer.start();

        TIMER_LENGTH=timeR/1000;
        mTimerView = (TimerView) findViewById(R.id.timer);
        mTimerView.start(TIMER_LENGTH);
        final Button timerStartButton = (Button) findViewById(R.id.btn_timer_delete);
        timerStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               timer.cancel();
                AlertDialog.Builder builder = new AlertDialog.Builder(ProgressActivity.this, R.style.AppCompatAlertDialogStyle);
                builder.setTitle("Tips");
                builder.setIcon(android.R.drawable.ic_menu_mylocation
                );
                builder.setMessage("Sure to Stop?");
                builder.setPositiveButton("OK", null);
                builder.setNegativeButton("Cancel", null);
                builder.show();
//                mTimerView.stop();
            }
        });


    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        overridePendingTransition(R.anim.trans_right_in,R.anim.hide_to_bottom);
    }

    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            tvTime.setText("Completed.");
        }


        @Override
        public void onTick(long millisUntilFinished) {

            long millis = millisUntilFinished;
            String hms = String.format("%04d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            System.out.println(hms);

            tvTime.setText(hms);
        }
    }
}
