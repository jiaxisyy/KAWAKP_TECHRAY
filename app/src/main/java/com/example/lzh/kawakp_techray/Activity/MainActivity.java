package com.example.lzh.kawakp_techray.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.lzh.kawakp_techray.R;


/**
 *主界面
 * Created by zuheng.lv on 2016/4/26.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button main_btn_monitor,main_btn_parameter,main_btn_status,main_btn_alarm,main_btn_pruessure,main_btn_run,main_btn_time,main_btn_valve,main_btn_flow;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        initView();
    }


    /**控件初始化*/
    public void initView(){
        main_btn_monitor = (Button)findViewById(R.id.main_btn_monitor);
        main_btn_parameter = (Button)findViewById(R.id.main_btn_parameter);
        main_btn_status = (Button)findViewById(R.id.main_btn_status);
        main_btn_alarm = (Button)findViewById(R.id.main_btn_alarm);
        main_btn_pruessure = (Button)findViewById(R.id.main_btn_pruessure);
        main_btn_run = (Button)findViewById(R.id.main_btn_run);
        main_btn_time = (Button)findViewById(R.id.main_btn_time);
        main_btn_valve = (Button)findViewById(R.id.main_btn_valve);
        main_btn_flow = (Button)findViewById(R.id.main_btn_flow);

        main_btn_monitor.setOnClickListener(this);
        main_btn_parameter.setOnClickListener(this);
        main_btn_status.setOnClickListener(this);
        main_btn_alarm.setOnClickListener(this);
        main_btn_pruessure.setOnClickListener(this);
        main_btn_run.setOnClickListener(this);
        main_btn_time.setOnClickListener(this);
        main_btn_valve.setOnClickListener(this);
        main_btn_flow.setOnClickListener(this);
    }

    /**按键监听函数*/
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_btn_monitor:
                intent = new Intent(MainActivity.this,MonitorActivity.class);
                startActivity(intent);
                break;
            case R.id.main_btn_parameter:
                intent = new Intent(MainActivity.this,ParameterActivity.class);
                startActivity(intent);
                break;
            case R.id.main_btn_status:
                intent = new Intent(MainActivity.this,AMachineStatusActivity.class);
                startActivity(intent);
                break;
            case R.id.main_btn_alarm:
                intent = new Intent(MainActivity.this,AlarmActivity.class);
                startActivity(intent);
                break;
            case R.id.main_btn_pruessure:
                intent = new Intent(MainActivity.this,PressureActivity.class);
                startActivity(intent);
                break;
            case R.id.main_btn_run:
                intent = new Intent(MainActivity.this,RunActivity.class);
                startActivity(intent);
                break;
            case R.id.main_btn_time:
                intent = new Intent(MainActivity.this,ATimingActivity.class);
                startActivity(intent);
                break;
            case R.id.main_btn_valve:
                intent = new Intent(MainActivity.this,AValveActivity.class);
                startActivity(intent);
                break;
            case R.id.main_btn_flow:
                intent = new Intent(MainActivity.this,FlowActivity.class);
                startActivity(intent);
                break;
        }
    }



}
