package com.example.lzh.kawakp_techray.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lzh.kawakp_techray.R;
import com.example.lzh.kawakp_techray.serialJNI.serialJNI;

/**
 * 运行监控页面
 * Created by zuheng.lv on 2016/4/26.
 */
public class MonitorActivity extends Activity implements View.OnClickListener {

    private TextView momitor_tv_pressure, momitor_tv_totalflow, momitor_tv_flow, momitor_tv_concentration, momitor_tv_runningtime;
    //循环标志
    private boolean flag = true;
    private serialJNI serial = new serialJNI();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    /**这里写UI更新函数*/
                    momitor_tv_pressure.setText( msg.getData().getString("i1").toString());
                    momitor_tv_totalflow.setText( msg.getData().getString("j1").toString());
                    momitor_tv_flow.setText( msg.getData().getString("k1").toString());
                    momitor_tv_concentration.setText( msg.getData().getString("l1").toString());
                    momitor_tv_runningtime.setText( msg.getData().getInt("ints"));
                    break;

            }
        }
    };

    private Button monitor_btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monitor_layout);
        initView();
        initData();
    }


    /**
     * 控件初始化
     */
    public void initView() {
        monitor_btn_back = (Button) findViewById(R.id.monitor_btn_back);
        monitor_btn_back.setOnClickListener(this);
        //氧气压力
        momitor_tv_pressure = (TextView) findViewById(R.id.momitor_tv_pressure);
        //流量统计
        momitor_tv_totalflow = (TextView) findViewById(R.id.momitor_tv_totalflow);
        //氧气流量
        momitor_tv_flow = (TextView) findViewById(R.id.momitor_tv_flow);
// 氧气浓度
        momitor_tv_concentration = (TextView) findViewById(R.id.momitor_tv_concentration);
        //A机运行时间
        momitor_tv_runningtime = (TextView) findViewById(R.id.momitor_tv_runningtime);
    }

    /**
     * 数据初始化
     */
    public void initData() {
        setData();

    }

    /**
     * 数据获取
     */
    public void getData() {

    }

    /**
     * 数据跟新
     */
    public void setData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
//                float   a  =   123.2334f;
//                float  b   =  (float)(Math.round(a*100))/100;(这里的100就是2位小数点,如果要其它位,如4位,这里两个100改成10000)

                /**这里写数据获取与数据处理函数*/

                while (flag) {
                    try {
                        //氧气压力值

                        float[] i = serial.mdbusreadreal(30, 212, 1);
                        float i1 = (float) (Math.round(i[0] * 10)) / 10;
                        //流量统计
                        float[] j = serial.mdbusreadreal(30, 264, 1);
                        float j1 = (float) (Math.round(j[0] * 10000)) / 10000;
                        //氧气流量
                        float[] k = serial.mdbusreadreal(30, 228, 1);
                        float k1 = (float) (Math.round(k[0] * 100)) / 100;
                        //氧气浓度
                        float[] l = serial.mdbusreadreal(30, 244, 1);
                        float l1 = (float) (Math.round(l[0] * 100)) / 100;
                        //A机运行时间
                        int[] ints = serial.mdbusreaddword(20, 458, 1);
                        Bundle bundle = new Bundle();
                        bundle.putString("i1", String.valueOf(i1));
                        bundle.putString("j1", String.valueOf(j1));
                        bundle.putString("k1", String.valueOf(k1));
                        bundle.putString("l1", String.valueOf(l1));
                        bundle.putInt("ints", ints[0]);
                        Message msg = new Message();
                        msg.what = 1;
                        msg.setData(bundle);
                        handler.sendMessage(msg);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


    /**
     * 点击监听函数
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /**返回按键*/
            case R.id.monitor_btn_back:
                Intent intent = new Intent(MonitorActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        flag=false;

    }
}
