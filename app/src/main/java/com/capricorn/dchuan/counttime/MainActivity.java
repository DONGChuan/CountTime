package com.capricorn.dchuan.counttime;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener{

    private EditText inputTime;
    private Button setTime, startTime, stopTime;
    private TextView showTime;

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
                int i = Integer.parseInt(inputTime.getText().toString());
                break;

        }

    }
}
