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
 *模拟量设置界面
 * Created by zuheng.lv on 2016/4/26.
 */
public class AnalogActivity extends Activity implements View.OnClickListener {


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:

                    /**这里写UI更新函数*/
                    analog_et_oxy_original.setText(msg.getData().getShortArray("d10").toString());
                    analog_et_flow_original.setText(msg.getData().getShortArray("d12").toString());
                    analog_et_concentration_original.setText(msg.getData().getShortArray("d14").toString());
                    analog_et_temp_original.setText(msg.getData().getShortArray("d16").toString());
                    analog_et_oxy_current.setText(msg.getData().getShortArray("d212").toString());
                    analog_et_flow_current.setText(msg.getData().getShortArray("d228").toString());
                    analog_et_concentration_current.setText(msg.getData().getShortArray("d244").toString());
                    analog_et_temp_current.setText(msg.getData().getShortArray("d260").toString());
                    break;
            }
        }
    };

    private Button analog_btn_back;
    private EditText analog_et_oxy_original,analog_et_flow_original,analog_et_concentration_original,analog_et_temp_original,analog_et_oxy_current,analog_et_flow_current,analog_et_concentration_current,analog_et_temp_current;
   private EditText analog_et_oxy_max,analog_et_flow_max,analog_et_concentration_max,analog_et_temp_max;
    private EditText analog_et_oxy_min,analog_et_flow_min,analog_et_concentration_min,analog_et_temp_min;
    private EditText analog_et_oxy_correction,analog_et_flow_correction,analog_et_concentration_correction,analog_et_temp_correction;
    private boolean flag=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.analog_layout);
        initView();
        initData();
    }

    /**控件初始化*/
    public void initView(){
        analog_et_oxy_original=(EditText)findViewById(R.id.analog_et_oxy_original);
        analog_et_flow_original=(EditText)findViewById(R.id.analog_et_flow_original);
        analog_et_concentration_original=(EditText)findViewById(R.id.analog_et_concentration_original);
        analog_et_temp_original=(EditText)findViewById(R.id.analog_et_temp_original);
        analog_et_oxy_current=(EditText)findViewById(R.id.analog_et_oxy_current);
        analog_et_flow_current=(EditText)findViewById(R.id.analog_et_flow_current);
        analog_et_concentration_current=(EditText)findViewById(R.id.analog_et_concentration_current);
        analog_et_temp_current=(EditText)findViewById(R.id.analog_et_temp_current);

        analog_et_oxy_max=(EditText)findViewById(R.id.analog_et_oxy_max);
        analog_et_flow_max=(EditText)findViewById(R.id.analog_et_flow_max);
        analog_et_concentration_max=(EditText)findViewById(R.id.analog_et_concentration_max);
        analog_et_temp_max=(EditText)findViewById(R.id.analog_et_temp_max);

        analog_et_oxy_min=(EditText)findViewById(R.id.analog_et_oxy_min);
        analog_et_flow_min=(EditText)findViewById(R.id.analog_et_flow_min);
        analog_et_concentration_min=(EditText)findViewById(R.id.analog_et_concentration_min);
        analog_et_temp_min=(EditText)findViewById(R.id.analog_et_temp_min);

        analog_et_oxy_correction=(EditText)findViewById(R.id.analog_et_oxy_correction);
        analog_et_flow_correction=(EditText)findViewById(R.id.analog_et_flow_correction);
        analog_et_concentration_correction=(EditText)findViewById(R.id.analog_et_concentration_correction);
        analog_et_temp_correction=(EditText)findViewById(R.id.analog_et_temp_correction);

        analog_btn_back = (Button) findViewById(R.id.analog_btn_back);
        analog_btn_back.setOnClickListener(this);
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
                while (flag) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //氧气压力原始值
                    short[] d10 = MyApplication.getInstance().mdbusreadword(10, 10, 1);
                    //氧气流量原始值
                    short[] d12 = MyApplication.getInstance().mdbusreadword(10, 12, 1);
                    //氧气浓度  原始值
                    short[] d14 = MyApplication.getInstance().mdbusreadword(10, 14, 1);
                    //氧气温度原始值
                    short[] d16 = MyApplication.getInstance().mdbusreadword(10, 16, 1);
                    //氧气压力最大值
                    //氧气压力最小值
                    //氧气压力修正值
                    //氧气压力当前值
                    short[] d212 = MyApplication.getInstance().mdbusreadword(10, 212, 1);
                    //氧气流量最大值
                    //氧气流量最小值
                    //氧气流量修正值
                    //氧气流量当前值
                    short[] d228 = MyApplication.getInstance().mdbusreadword(10, 228, 1);
                    //氧气浓度最大值
                    //氧气浓度最小值
                    //氧气浓度修正值
                    //氧气浓度当前值
                    short[] d244 = MyApplication.getInstance().mdbusreadword(10, 244, 1);
                    //氧气温度当前值
                    short[] d260 = MyApplication.getInstance().mdbusreadword(10, 260, 1);
                    Bundle bundle = new Bundle();
                    bundle.putShortArray("d10", d10);
                    bundle.putShortArray("d12", d12);
                    bundle.putShortArray("d14", d14);
                    bundle.putShortArray("d16", d16);
                    bundle.putShortArray("d212", d212);
                    bundle.putShortArray("d228", d228);
                    bundle.putShortArray("d244", d244);
                    bundle.putShortArray("d260", d260);
                    Message msg = new Message();
                    msg.setData(bundle);
                    msg.what = 1;
                    handler.sendMessage(msg);
                }
            }
        }).start();
    }


    /**点击监听函数*/
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.analog_btn_back:
                Intent intent = new Intent(AnalogActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        flag = false;
    }
}
