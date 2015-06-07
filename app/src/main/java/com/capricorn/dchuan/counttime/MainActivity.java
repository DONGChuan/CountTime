package com.capricorn.dchuan.counttime;

import android.app.Activity;
import android.os.Message;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity implements View.OnClickListener {

    private EditText inputTime;
    private Button setTime, startTime, stopTime;
    private TextView showTime;

    private int currentTime;
    private Timer timer = null;
    private TimerTask timeTask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView() {
        inputTime = (EditText) findViewById(R.id.et_get_time);
        setTime = (Button) findViewById(R.id.b_set_time);
        startTime = (Button) findViewById(R.id.b_start_time);
        stopTime = (Button) findViewById(R.id.b_stop_time);
        showTime = (TextView) findViewById(R.id.tv_time);
    }

    private void initListener() {
        setTime.setOnClickListener(this);
        startTime.setOnClickListener(this);
        stopTime.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.b_set_time:
                showTime.setText(inputTime.getText().toString());
                currentTime = Integer.parseInt(inputTime.getText().toString());
                break;
            case R.id.b_start_time:
                startTime();
                break;
            case R.id.b_stop_time:
                stopTime();
                break;

        }
    }

    private android.os.Handler mHandler = new android.os.Handler(){
        public void handleMessage(Message msg) {
            showTime.setText(String.valueOf(msg.arg1));
            startTime();
        };
    };

    public void startTime() {
        timer = new Timer();
        timeTask = new TimerTask() {
            @Override
            public void run() {
                currentTime--;
                Message message = mHandler.obtainMessage();
                message.arg1 = currentTime;
                mHandler.sendMessage(message);
            }
        };
        timer.schedule(timeTask, 1);
    }

    public void stopTime() {
        timer.cancel();
    }
}
