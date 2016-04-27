package com.example.lzh.kawakp_techray.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lzh.kawakp_techray.R;

/**
 * 流量页面
 * Created by zuheng.lv on 2016/4/26.
 */
public class FlowActivity extends Activity implements View.OnClickListener, View.OnTouchListener {


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    /**这里写UI更新函数*/
                    flow_tv_totalflow.setText(msg.getData().getIntArray("d264").toString());
                    break;
            }
        }
    };

    private Button flow_btn_back,flow_btn_confirm,flow_btn_clean;
    private TextView flow_tv_totalflow;
    private EditText flow_et_totalflow_correct;
    private boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flow_layout);
        initView();
        initData();
    }

    /**控件初始化*/
    public void initView(){
        flow_tv_totalflow= (TextView)findViewById(R.id.flow_tv_totalflow);
        flow_et_totalflow_correct = (EditText)findViewById(R.id.flow_et_totalflow_correct);
        flow_btn_confirm =(Button)findViewById(R.id.flow_btn_confirm);
        flow_btn_clean = (Button)findViewById(R.id.flow_btn_clean);
        flow_btn_back = (Button) findViewById(R.id.flow_btn_back);
        flow_btn_back.setOnClickListener(this);
        flow_btn_clean.setOnClickListener(this);
        flow_btn_confirm.setOnClickListener(this);
        flow_btn_confirm.setOnTouchListener(this);
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
                    int[] d264 = MyApplication.getInstance().mdbusreaddword(20, 264, 1);

                    Bundle bundle = new Bundle();
                    bundle.putIntArray("d264", d264);
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
        switch (v.getId()) {
            case R.id.flow_btn_back:
                Intent intent = new Intent(FlowActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.flow_btn_confirm:
                if (flow_et_totalflow_correct.getText() != null && !flow_et_totalflow_correct.getText().equals("")) {
                    int[] d272 = {Integer.parseInt(flow_et_totalflow_correct.getText().toString())};
                    MyApplication.getInstance().mdbuswritedword(20, d272, 0, 1);
                }
                break;
            case R.id.flow_btn_clean:
                byte[] m117 = {1};
                MyApplication.getInstance().mdbuswritebyte(2, m117, 0, 1);
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()){
            case R.id.flow_btn_confirm:
                if(event.getAction()== MotionEvent.ACTION_UP){
                    byte[] m190 = {0};
                    MyApplication.getInstance().mdbuswritebyte(2,m190,0,1);
                }
                break;
            case R.id.flow_btn_clean:
                byte[] m117 = {0};
                MyApplication.getInstance().mdbuswritebyte(2,m117,0,1);
                break;
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        flag=false;
    }


}
