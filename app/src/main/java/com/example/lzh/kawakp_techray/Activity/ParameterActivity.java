package com.example.lzh.kawakp_techray.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lzh.kawakp_techray.R;

/**
 * 参数设置界面
 * Created by zuheng.lv on 2016/4/26.
 */
public class ParameterActivity extends Activity implements View.OnClickListener, View.OnFocusChangeListener {

    private EditText para_et_opendelay, para_et_startdelay;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    /**这里写UI更新函数*/
                    break;
            }
        }
    };

    private Button para_btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parameter_layout);
        initView();
        initData();
    }


    /**
     * 控件初始化
     */
    public void initView() {
        para_btn_back = (Button) findViewById(R.id.para_btn_back);
        para_btn_back.setOnClickListener(this);
        //空压机开机延时
        para_et_opendelay = (EditText) findViewById(R.id.para_et_opendelay);
        //待机启动延时
        para_et_startdelay = (EditText) findViewById(R.id.para_et_startdelay);
    }

    /**
     * 数据初始化
     */
    public void initData() {


    }

    /**
     * 数据获取
     */
    public void getData() {


    }

    /**
     * 数据存储
     */
    public void saveData() {

    }

    /**
     * 数据跟新
     */
    public void setData() {
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

    /**
     * 点击监听函数
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.para_btn_back:
                Intent intent = new Intent(ParameterActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    /**
     * 焦点改变的监听事件
     *
     * @param v
     * @param hasFocus
     */
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        //离开输入框触发
        if (v.getId() == R.id.para_et_opendelay && !hasFocus) {
            //赋值
            String str = para_et_opendelay.getText().toString();
            float b = Float.parseFloat(str);
            float b1 = (float) (Math.round(b * 10)) / 10;
            float[] b2 = {b1};
            MyApplication.getInstance().mdbuswritereal(30, b2, 476, 1);

        } else if (v.getId() == R.id.para_et_startdelay && !hasFocus) {
            String str = para_et_startdelay.getText().toString();
            float b = Float.parseFloat(str);
            float b1 = (float) (Math.round(b * 10)) / 10;
            float[] b2 = {b1};
            MyApplication.getInstance().mdbuswritereal(30, b2, 478, 1);
        }


    }
}
