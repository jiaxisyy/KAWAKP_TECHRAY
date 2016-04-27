package com.example.lzh.kawakp_techray.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.example.lzh.kawakp_techray.R;

/**
 * 流量页面
 * Created by zuheng.lv on 2016/4/26.
 */
public class FlowActivity extends Activity implements View.OnClickListener {


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

    private Button flow_btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flow_layout);
        initView();
        initData();
    }

    /**控件初始化*/
    public void initView(){
        flow_btn_back = (Button) findViewById(R.id.flow_btn_back);
        flow_btn_back.setOnClickListener(this);

    }
    /**数据初始化*/
    public void initData(){


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


    /**点击监听函数*/
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.flow_btn_back:
                Intent intent = new Intent(FlowActivity.this,MainActivity.class);
                startActivity(intent);
                break;
        }
    }


}
