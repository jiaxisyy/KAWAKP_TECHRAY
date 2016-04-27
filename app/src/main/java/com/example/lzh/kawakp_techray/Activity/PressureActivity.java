package com.example.lzh.kawakp_techray.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lzh.kawakp_techray.R;

/**
 * 压力设置页面
 * Created by zuheng.lv on 2016/4/26.
 */
public class PressureActivity extends Activity implements View.OnClickListener {


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


    private Button pressure_btn_back;
    private EditText pressure_et_max1,pressure_et_max2,pressure_et_min1,pressure_et_min2;
    private AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pressure_layout);
        initView();
        initData();
    }

    /**控件初始化*/
    public void initView(){
        pressure_et_max1 = (EditText)findViewById(R.id.pressure_et_max1);
        pressure_et_max2 = (EditText)findViewById(R.id.pressure_et_max2);
        pressure_et_min1 = (EditText)findViewById(R.id.pressure_et_min1);
        pressure_et_min2 = (EditText)findViewById(R.id.pressure_et_min2);
        pressure_et_max1.setOnClickListener(this);
        pressure_et_max2.setOnClickListener(this);
        pressure_et_min1.setOnClickListener(this);
        pressure_et_min2.setOnClickListener(this);

        pressure_btn_back = (Button) findViewById(R.id.pressure_btn_back);
        pressure_btn_back.setOnClickListener(this);
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
            case R.id.pressure_btn_back:
                Intent intent = new Intent(PressureActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.pressure_et_max1:
                showDialog(pressure_et_max1,20,330);
                break;
            case R.id.pressure_et_max2:
                showDialog(pressure_et_max2,20,338);
                break;
            case R.id.pressure_et_min1:
                showDialog(pressure_et_min1,20,334);
                break;
            case R.id.pressure_et_min2:
                showDialog(pressure_et_min2,20,342);
                break;
        }
    }
    public void showDialog(final EditText t, final int type, final int stadr){
        View view = getLayoutInflater().from(PressureActivity.this).inflate(R.layout.ed_dialog,null);
        builder = new AlertDialog.Builder(PressureActivity.this,R.style.DialogStyle);
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
                int i = Integer.parseInt(s);
                int[] i1 = {i};
                MyApplication.getInstance().mdbuswritedword(type, i1, stadr, 1);

            }
        });


    }

}
