package com.example.lzh.kawakp_techray.Activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lzh.kawakp_techray.R;

/**
 * 参数设置界面
 * Created by zuheng.lv on 2016/4/26.
 */
public class ParameterActivity extends Activity implements View.OnClickListener{

    private TextView para_et_opendelay, para_et_startdelay;
    private AlertDialog.Builder builder;

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
        para_et_opendelay = (TextView) findViewById(R.id.para_et_opendelay);
        //待机启动延时
        para_et_startdelay = (TextView) findViewById(R.id.para_et_startdelay);
        para_et_opendelay.setOnClickListener(this);
        para_et_startdelay.setOnClickListener(this);
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
            case R.id.para_et_opendelay:
                showDialog(para_et_opendelay,30,476);
                break;
            case R.id.para_et_startdelay:
                showDialog(para_et_startdelay,30,478);
                break;
        }
    }




    public void showDialog(final TextView t, final int type, final int stadr){
        View view = getLayoutInflater().from(ParameterActivity.this).inflate(R.layout.ed_dialog,null);
        builder = new AlertDialog.Builder(ParameterActivity.this,R.style.DialogStyle);
        builder.setView(view);
        builder.create();
        builder.show();

       final EditText editText = (EditText) view.findViewById(R.id.editText);
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { //设置取消按钮
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { //设置确定按钮
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String s = editText.getText().toString();
                t.setText(s);
                float b = Float.parseFloat(s);
                float b1 = (float) (Math.round(b * 10)) / 10;
                float[] b2 = {b1};
                MyApplication.getInstance().mdbuswritereal(type, b2, stadr, 1);

            }
        });


    }
}
