package com.example.lzh.kawakp_techray.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.example.lzh.kawakp_techray.R;
import com.example.lzh.kawakp_techray.serialJNI.serialJNI;

/**
 * A机状态界面
 * Created by zuheng.lv on 2016/4/26.
 */
public class AMachineStatusActivity extends Activity implements View.OnClickListener {


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    /**这里写UI更新函数*/
                    switch (msg.what){
                        case 1:
//                            stataus_btn_valve1.setSelected(y2);
//                            stataus_btn_valve2.setSelected(y3);
//                            stataus_btn_valve3.setSelected(y4);
//                            stataus_btn_valve4.setSelected(y5);
//                            stataus_btn_valve5.setSelected(y6);
//                            stataus_btn_valve6.setSelected(y7);
//                            stataus_btn_valve7.setSelected(y10);
//                            stataus_btn_valve8.setSelected(y11);
//                            stataus_btn_valve9.setSelected(y12);
//                            stataus_btn_valve10.setSelected(y13);
//                            stataus_btn_valve11.setSelected(y0);
//                            stataus_btn_valve12.setSelected(y1);
                            break;
                    }

                    break;
            }
        }
    };
        private Button status_btn_back;
        private Button stataus_btn_valve1,stataus_btn_valve2,stataus_btn_valve3,stataus_btn_valve4,stataus_btn_valve5,stataus_btn_valve6;
        private Button stataus_btn_valve7,stataus_btn_valve8,stataus_btn_valve9,stataus_btn_valve10,stataus_btn_valve11,stataus_btn_valve12;
        boolean flag =true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.amachinestatus_layout);
        initView();
        initData();
    }

    /**控件初始化*/
    public void initView(){
        stataus_btn_valve1 = (Button) findViewById(R.id.stataus_btn_valve1);
        stataus_btn_valve2 = (Button) findViewById(R.id.stataus_btn_valve2);
        stataus_btn_valve3 = (Button) findViewById(R.id.stataus_btn_valve3);
        stataus_btn_valve4 = (Button) findViewById(R.id.stataus_btn_valve4);
        stataus_btn_valve5 = (Button) findViewById(R.id.stataus_btn_valve5);
        stataus_btn_valve6 = (Button) findViewById(R.id.stataus_btn_valve6);
        stataus_btn_valve7 = (Button) findViewById(R.id.stataus_btn_valve7);
        stataus_btn_valve8 = (Button) findViewById(R.id.stataus_btn_valve8);
        stataus_btn_valve9 = (Button) findViewById(R.id.stataus_btn_valve9);
        stataus_btn_valve10 = (Button) findViewById(R.id.stataus_btn_valve10);
        stataus_btn_valve11 = (Button) findViewById(R.id.stataus_btn_valve11);
        stataus_btn_valve12 = (Button) findViewById(R.id.stataus_btn_valve12);
        status_btn_back = (Button) findViewById(R.id.status_btn_back);
        status_btn_back.setOnClickListener(this);

    }
    /**数据初始化*/
    public void initData(){


    }

    /**数据获取*/
    public void getData(){


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
                    //A进气阀
                    byte[] y2 = MyApplication.getInstance().mdbusreadbyte(1, 2, 1);
                    //B进气阀
                    byte[] y3 = MyApplication.getInstance().mdbusreadbyte(1, 3, 1);
                    //A排气阀
                    byte[] y4 = MyApplication.getInstance().mdbusreadbyte(1, 4, 1);
                    //B排气阀
                    byte[] y5 = MyApplication.getInstance().mdbusreadbyte(1, 5, 1);
                    //A产氧阀
                    byte[] y6 = MyApplication.getInstance().mdbusreadbyte(1, 6, 1);
                    //B产氧阀
                    byte[] y7 = MyApplication.getInstance().mdbusreadbyte(1, 7, 1);
                    //A均压阀
                    byte[] y10 = MyApplication.getInstance().mdbusreadbyte(1, 10, 1);
                    //B均压阀
                    byte[] y11 = MyApplication.getInstance().mdbusreadbyte(1, 11, 1);
                    //A清洗阀
                    byte[] y12 = MyApplication.getInstance().mdbusreadbyte(1, 10, 1);
                    //B清洗阀
                    byte[] y13 = MyApplication.getInstance().mdbusreadbyte(1, 11, 1);
                    //空压机
                    byte[] y0 = MyApplication.getInstance().mdbusreadbyte(1, 0, 1);
                    //冷干机
                    byte[] y1 = MyApplication.getInstance().mdbusreadbyte(1, 2, 1);

                    Bundle bundle = new Bundle();
                    bundle.putByteArray("y0", y0);
                    bundle.putByteArray("y1", y1);
                    bundle.putByteArray("y2", y2);
                    bundle.putByteArray("y3", y3);
                    bundle.putByteArray("y4", y4);
                    bundle.putByteArray("y5", y5);
                    bundle.putByteArray("y6", y6);
                    bundle.putByteArray("y7", y7);
                    bundle.putByteArray("y10", y10);
                    bundle.putByteArray("y11", y11);
                    bundle.putByteArray("y12", y12);
                    bundle.putByteArray("y13", y13);
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
            case R.id.status_btn_back:
                Intent intent = new Intent(AMachineStatusActivity.this,MainActivity.class);
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
