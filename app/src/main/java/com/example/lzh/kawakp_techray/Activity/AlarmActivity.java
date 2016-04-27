package com.example.lzh.kawakp_techray.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;

import com.example.lzh.kawakp_techray.R;

/**
 * 报警设置界面
 * Created by zuheng.lv on 2016/4/26.
 */
public class AlarmActivity extends Activity implements View.OnFocusChangeListener{
    private EditText alarm_et_oxy_max,alarm_et_oxy_min,alarm_et_oxy_flow;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    /**这里写UI更新函数*/
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_layout);
        initView();
        initData();
    }

    /**控件初始化*/
    public void initView(){


    }
    /**数据初始化*/
    public void initData(){
        //氧气压力上限
        alarm_et_oxy_max= (EditText) findViewById(R.id.alarm_et_oxy_max);
        // 氧气压力下限
        alarm_et_oxy_min= (EditText) findViewById(R.id.alarm_et_oxy_min);
        //氧气流量上限
        alarm_et_oxy_flow= (EditText) findViewById(R.id.alarm_et_oxy_flow);

    }

    /**数据获取*/
    public void getData(){


    }
    /**数据存储*/
    public void saveData(){

    }
    /**数据跟新*/
    public void setData(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                /**这里写数据获取与数据处理函数*/


                Message msg = new Message();
                msg.what = 1;
                handler.sendMessage(msg);
            }
        }).start();
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {

        if(v.getId()==R.id.alarm_et_oxy_max&&!hasFocus){
            String str = alarm_et_oxy_max.getText().toString();
            int i = Integer.parseInt(str);
            int[] j={i};
            MyApplication.getInstance().mdbuswritedword(20,j,280,1);

        }else if(v.getId()==R.id.alarm_et_oxy_min&&!hasFocus){
            String str = alarm_et_oxy_min.getText().toString();
            int i = Integer.parseInt(str);
            int[] j={i};
            MyApplication.getInstance().mdbuswritedword(20,j,284,1);

        }else if(v.getId()==R.id.alarm_et_oxy_flow&&!hasFocus){
            String str = alarm_et_oxy_flow.getText().toString();
            int i = Integer.parseInt(str);
            int[] j={i};
            MyApplication.getInstance().mdbuswritedword(20,j,300,1);

        }else if(v.getId()==R.id.alarm_et_oxy_flow&&!hasFocus){
            String str = alarm_et_oxy_flow.getText().toString();
            int i = Integer.parseInt(str);
            int[] j={i};
            MyApplication.getInstance().mdbuswritedword(20,j,300,1);

        }


    }

    /**点击监听函数*/
    class onClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {


        }
    }
}
