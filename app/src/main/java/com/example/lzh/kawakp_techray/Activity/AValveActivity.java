package com.example.lzh.kawakp_techray.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.lzh.kawakp_techray.R;

/**
 * A机阀门检验页面
 * Created by zuheng.lv on 2016/4/26.
 */
public class AValveActivity extends Activity implements View.OnClickListener, View.OnTouchListener {

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    /**这里写UI更新函数*/
                    avalve_btn_valve1.setSelected(msg.getData().getBoolean("y2"));
                    avalve_btn_valve2.setSelected(msg.getData().getBoolean("y3"));
                    avalve_btn_valve3.setSelected(msg.getData().getBoolean("y4"));
                    avalve_btn_valve4.setSelected(msg.getData().getBoolean("y5"));
                    avalve_btn_valve5.setSelected(msg.getData().getBoolean("y6"));
                    avalve_btn_valve6.setSelected(msg.getData().getBoolean("y7"));
                    avalve_btn_valve7.setSelected(msg.getData().getBoolean("y10"));
                    avalve_btn_valve8.setSelected(msg.getData().getBoolean("y11"));
                    avalve_btn_valve9.setSelected(msg.getData().getBoolean("y12"));
                    avalve_btn_valve10.setSelected(msg.getData().getBoolean("y13"));
                    avalve_btn_valve11.setSelected(msg.getData().getBoolean("y0"));
                    avalve_btn_valve12.setSelected(msg.getData().getBoolean("y1"));
                    avalve_btn1.setPressed(msg.getData().getBoolean("y2"));
                    avalve_btn2.setPressed(msg.getData().getBoolean("y3"));
                    avalve_btn3.setPressed(msg.getData().getBoolean("y4"));
                    avalve_btn4.setPressed(msg.getData().getBoolean("y5"));
                    avalve_btn5.setPressed(msg.getData().getBoolean("y6"));
                    avalve_btn6.setPressed(msg.getData().getBoolean("y7"));
                    avalve_btn7.setPressed(msg.getData().getBoolean("y10"));
                    avalve_btn8.setPressed(msg.getData().getBoolean("y11"));
                    avalve_btn9.setPressed(msg.getData().getBoolean("y12"));
                    avalve_btn10.setPressed(msg.getData().getBoolean("y13"));
                    avalve_btn11.setPressed(msg.getData().getBoolean("y0"));
                    avalve_btn12.setPressed(msg.getData().getBoolean("y1"));
                    break;
            }
        }
    };

    private Button valve_btn_back;
    private Button avalve_btn_valve1,avalve_btn_valve2,avalve_btn_valve3,avalve_btn_valve4,avalve_btn_valve5,avalve_btn_valve6,avalve_btn_valve7,avalve_btn_valve8,avalve_btn_valve9,avalve_btn_valve10,avalve_btn_valve11,avalve_btn_valve12;
    private Button avalve_btn1,avalve_btn2,avalve_btn3,avalve_btn4,avalve_btn5,avalve_btn6,avalve_btn7,avalve_btn8,avalve_btn9,avalve_btn10,avalve_btn11,avalve_btn12;
    private Boolean flag = true;
    private Boolean btn_flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avalve_layout);
        initView();
        initData();
        setData();
    }

    /**控件初始化*/
    public void initView(){

        avalve_btn_valve1= (Button)findViewById(R.id.avalve_btn_valve1);
        avalve_btn_valve2= (Button)findViewById(R.id.avalve_btn_valve2);
        avalve_btn_valve3= (Button)findViewById(R.id.avalve_btn_valve3);
        avalve_btn_valve4= (Button)findViewById(R.id.avalve_btn_valve4);
        avalve_btn_valve5= (Button)findViewById(R.id.avalve_btn_valve5);
        avalve_btn_valve6= (Button)findViewById(R.id.avalve_btn_valve6);
        avalve_btn_valve7= (Button)findViewById(R.id.avalve_btn_valve7);
        avalve_btn_valve8= (Button)findViewById(R.id.avalve_btn_valve8);
        avalve_btn_valve9= (Button)findViewById(R.id.avalve_btn_valve9);
        avalve_btn_valve10= (Button)findViewById(R.id.avalve_btn_valve10);
        avalve_btn_valve11= (Button)findViewById(R.id.avalve_btn_valve11);
        avalve_btn_valve12= (Button)findViewById(R.id.avalve_btn_valve12);
        avalve_btn1 = (Button) findViewById(R.id.avalve_btn1);
        avalve_btn2 = (Button) findViewById(R.id.avalve_btn2);
        avalve_btn3 = (Button) findViewById(R.id.avalve_btn3);
        avalve_btn4 = (Button) findViewById(R.id.avalve_btn4);
        avalve_btn5 = (Button) findViewById(R.id.avalve_btn5);
        avalve_btn6 = (Button) findViewById(R.id.avalve_btn6);
        avalve_btn7 = (Button) findViewById(R.id.avalve_btn7);
        avalve_btn8 = (Button) findViewById(R.id.avalve_btn8);
        avalve_btn9 = (Button) findViewById(R.id.avalve_btn9);
        avalve_btn10 = (Button) findViewById(R.id.avalve_btn10);
        avalve_btn11 = (Button) findViewById(R.id.avalve_btn11);
        avalve_btn12 = (Button) findViewById(R.id.avalve_btn12);
        valve_btn_back = (Button)findViewById(R.id.valve_btn_back);
        avalve_btn1.setOnClickListener(this);
        avalve_btn2.setOnClickListener(this);
        avalve_btn3.setOnClickListener(this);
        avalve_btn4.setOnClickListener(this);
        avalve_btn5.setOnClickListener(this);
        avalve_btn6.setOnClickListener(this);
        avalve_btn7.setOnClickListener(this);
        avalve_btn8.setOnClickListener(this);
        avalve_btn9.setOnClickListener(this);
        avalve_btn10.setOnClickListener(this);
        avalve_btn11.setOnClickListener(this);
        avalve_btn12.setOnClickListener(this);
        avalve_btn1.setOnTouchListener(this);
        avalve_btn2.setOnTouchListener(this);
        avalve_btn3.setOnTouchListener(this);
        avalve_btn4.setOnTouchListener(this);
        avalve_btn5.setOnTouchListener(this);
        avalve_btn6.setOnTouchListener(this);
        avalve_btn7.setOnTouchListener(this);
        avalve_btn8.setOnTouchListener(this);
        avalve_btn9.setOnTouchListener(this);
        avalve_btn10.setOnTouchListener(this);
        avalve_btn11.setOnTouchListener(this);
        avalve_btn12.setOnTouchListener(this);
        valve_btn_back.setOnClickListener(this);
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
                    if(y0[0]==0){
                        bundle.putBoolean("y0", false);
                    }else if(y0[0]==1){
                        bundle.putBoolean("y0", true);
                    }
                    if(y1[0]==0){
                        bundle.putBoolean("y1", false);
                    }else if(y1[0]==1){
                        bundle.putBoolean("y1", true);
                    }
                    if(y2[0]==0){
                        bundle.putBoolean("y2", false);
                    }else if(y2[0]==1){
                        bundle.putBoolean("y2", true);
                    }
                    if(y3[0]==0){
                        bundle.putBoolean("y3", false);
                    }else if(y3[0]==1){
                        bundle.putBoolean("y3", true);
                    }
                    if(y4[0]==0){
                        bundle.putBoolean("y4", false);
                    }else if(y4[0]==1){
                        bundle.putBoolean("y4", true);
                    }
                    if(y5[0]==0){
                        bundle.putBoolean("y5", false);
                    }else if(y5[0]==0){
                        bundle.putBoolean("y5", true);
                    }
                    if(y6[0]==0){
                        bundle.putBoolean("y6", false);
                    }else if(y6[0]==1){
                        bundle.putBoolean("y6", true);
                    }
                    if(y7[0]==0){
                        bundle.putBoolean("y7", false);
                    }else if(y7[0]==1){
                        bundle.putBoolean("y7", true);
                    }
                    if(y10[0]==0){
                        bundle.putBoolean("y10", false);
                    }else if(y10[0]==1){
                        bundle.putBoolean("y10", true);
                    }
                    if(y11[0]==0){
                        bundle.putBoolean("y11", false);
                    }else if(y11[0]==1){
                        bundle.putBoolean("y11", true);
                    }
                    if(y12[0]==0){
                        bundle.putBoolean("y12", false);
                    }else if(y12[0]==1){
                        bundle.putBoolean("y12", true);
                    }
                    if(y13[0]==0){
                        bundle.putBoolean("y13", false);
                    }else if(y13[0]==1){
                        bundle.putBoolean("y13", true);
                    }
                    Message msg = new Message();
                    msg.setData(bundle);
                    msg.what = 1;
                    handler.sendMessage(msg);
                }
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
            case R.id.valve_btn_back:
                Intent intent = new Intent(AValveActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.avalve_btn1:
                if(avalve_btn1.isPressed()){
                    //avalve_btn1.setPressed(false);
                    while (btn_flag) {
                        byte[] b = {0};
                        MyApplication.getInstance().mdbuswritebyte(1, b, 2, 1);
                    }
                }else{
                    while (btn_flag) {
                        byte[] b = {1};
                        MyApplication.getInstance().mdbuswritebyte(1, b, 2, 1);
                    }
                }
                break;
            case R.id.avalve_btn2:
                if(avalve_btn2.isPressed()){
                    while (btn_flag) {
                        byte[] b = {0};
                        MyApplication.getInstance().mdbuswritebyte(1, b, 3, 1);
                    }
                }else{
                    while (btn_flag) {
                        byte[] b = {1};
                        MyApplication.getInstance().mdbuswritebyte(1, b, 3, 1);
                    }
                }
                break;
            case R.id.avalve_btn3:
                if(avalve_btn3.isPressed()){
                    while (btn_flag) {
                        byte[] b = {0};
                        MyApplication.getInstance().mdbuswritebyte(1, b, 4, 1);
                    }
                }else{
                    while (btn_flag) {
                        byte[] b = {1};
                        MyApplication.getInstance().mdbuswritebyte(1, b, 4, 1);
                    }
                }
                break;
            case R.id.avalve_btn4:
                if(avalve_btn4.isPressed()){
                    while (btn_flag) {
                        byte[] b = {0};
                        MyApplication.getInstance().mdbuswritebyte(1, b, 5, 1);
                    }
                }else{
                    while (btn_flag) {
                        byte[] b = {1};
                        MyApplication.getInstance().mdbuswritebyte(1, b, 5, 1);
                    }
                }
                break;
            case R.id.avalve_btn5:
                if(avalve_btn5.isPressed()){
                    while (btn_flag) {
                        byte[] b = {0};
                        MyApplication.getInstance().mdbuswritebyte(1, b, 6, 1);
                    }
                }else{
                    while (btn_flag) {
                        byte[] b = {1};
                        MyApplication.getInstance().mdbuswritebyte(1, b, 6, 1);
                    }
                }
                break;
            case R.id.avalve_btn6:
                if(avalve_btn6.isPressed()){
                    while (btn_flag) {
                        byte[] b = {0};
                        MyApplication.getInstance().mdbuswritebyte(1, b, 7, 1);
                    }
                }else{
                    while (btn_flag) {
                        byte[] b = {1};
                        MyApplication.getInstance().mdbuswritebyte(1, b, 7, 1);
                    }
                }
                break;
            case R.id.avalve_btn7:
                if(avalve_btn7.isPressed()){
                    while (btn_flag) {
                        byte[] b = {0};
                        MyApplication.getInstance().mdbuswritebyte(1, b, 10, 1);
                    }
                }else{
                    while (btn_flag) {
                        byte[] b = {1};
                        MyApplication.getInstance().mdbuswritebyte(1, b, 10, 1);
                    }
                }
                break;
            case R.id.avalve_btn8:
                if(avalve_btn8.isPressed()){
                    while (btn_flag) {
                        byte[] b = {0};
                        MyApplication.getInstance().mdbuswritebyte(1, b, 11, 1);
                    }
                }else{
                    while (btn_flag) {
                    byte[] b = {1};
                    MyApplication.getInstance().mdbuswritebyte(1,b,11,1);
                    }
                }
                break;
            case R.id.avalve_btn9:
                if(avalve_btn9.isPressed()){
                    while (btn_flag) {
                        byte[] b = {0};
                        MyApplication.getInstance().mdbuswritebyte(1, b, 12, 1);
                    }
                }else{
                    while (btn_flag) {
                        byte[] b = {1};
                        MyApplication.getInstance().mdbuswritebyte(1, b, 12, 1);
                    }
                }
                break;
            case R.id.avalve_btn10:
                if(avalve_btn10.isPressed()){
                    while (btn_flag) {
                        byte[] b = {0};
                        MyApplication.getInstance().mdbuswritebyte(1, b, 13, 1);
                    }
                }else{
                    while (btn_flag) {
                        byte[] b = {1};
                        MyApplication.getInstance().mdbuswritebyte(1, b, 13, 1);
                    }
                }
                break;
            case R.id.avalve_btn11:
                if(avalve_btn11.isPressed()){
                    while (btn_flag) {
                        byte[] b = {0};
                        MyApplication.getInstance().mdbuswritebyte(1, b, 0, 1);
                    }
                }else{
                    while (btn_flag) {
                        byte[] b = {1};
                        MyApplication.getInstance().mdbuswritebyte(1, b, 0, 1);
                    }
                }
                break;
            case R.id.avalve_btn12:
                if(avalve_btn12.isPressed()){
                    while (btn_flag) {
                        byte[] b = {0};
                        MyApplication.getInstance().mdbuswritebyte(1, b, 1, 1);
                    }
                }else{
                    while (btn_flag) {
                        byte[] b = {1};
                        MyApplication.getInstance().mdbuswritebyte(1, b, 1, 1);
                    }
                }
                break;
        }
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()){
            case R.id. avalve_btn1:
                if(event.getAction()== MotionEvent.ACTION_UP) {
                    if(avalve_btn12.isPressed()){
                       btn_flag=false;
                        byte[] b = {0};
                        MyApplication.getInstance().mdbuswritebyte(1,b,1,1);
                    }else{
                        btn_flag=false;
                        byte[] b = {1};
                        MyApplication.getInstance().mdbuswritebyte(1,b,1,1);
                    }
                }
                break;
            case R.id.avalve_btn2:
                if(event.getAction()== MotionEvent.ACTION_UP) {
                    if (avalve_btn2.isPressed()) {
                        btn_flag=false;
                        byte[] b = {0};
                        MyApplication.getInstance().mdbuswritebyte(1, b, 3, 1);
                    } else {
                        btn_flag=false;
                        byte[] b = {1};
                        MyApplication.getInstance().mdbuswritebyte(1, b, 3, 1);
                    }
                }
                break;
            case R.id.avalve_btn3:
                if(event.getAction()== MotionEvent.ACTION_UP){
                    if(avalve_btn3.isPressed()){
                        btn_flag=false;
                        byte[] b = {0};
                        MyApplication.getInstance().mdbuswritebyte(1,b,4,1);
                    }else{
                        btn_flag=false;
                        byte[] b = {1};
                        MyApplication.getInstance().mdbuswritebyte(1,b,4,1);
                    }
                }
                break;
            case R.id.avalve_btn4:
                if(event.getAction()== MotionEvent.ACTION_UP){
                    if(avalve_btn4.isPressed()){
                        btn_flag=false;
                        byte[] b = {0};
                        MyApplication.getInstance().mdbuswritebyte(1,b,5,1);
                    }else{
                        btn_flag=false;
                        byte[] b = {1};
                        MyApplication.getInstance().mdbuswritebyte(1,b,5,1);
                    }
                }
                break;
            case R.id.avalve_btn5:
                if(event.getAction()== MotionEvent.ACTION_UP){
                    if(avalve_btn5.isPressed()){
                        btn_flag=false;
                        byte[] b = {0};
                        MyApplication.getInstance().mdbuswritebyte(1,b,6,1);
                    }else{
                        btn_flag=false;
                        byte[] b = {1};
                        MyApplication.getInstance().mdbuswritebyte(1,b,6,1);
                    }
                }
                break;
            case R.id.avalve_btn6:
                if(event.getAction()== MotionEvent.ACTION_UP){
                    if(avalve_btn6.isPressed()){
                        btn_flag=false;
                        byte[] b = {0};
                        MyApplication.getInstance().mdbuswritebyte(1,b,7,1);
                    }else{
                        btn_flag=false;
                        byte[] b = {1};
                        MyApplication.getInstance().mdbuswritebyte(1,b,7,1);
                    }
                }
                break;
            case R.id.avalve_btn7:
                if(event.getAction()== MotionEvent.ACTION_UP){
                    if(avalve_btn7.isPressed()){
                        btn_flag=false;
                        byte[] b = {0};
                        MyApplication.getInstance().mdbuswritebyte(1,b,10,1);
                    }else{
                        btn_flag=false;
                        byte[] b = {1};
                        MyApplication.getInstance().mdbuswritebyte(1,b,10,1);
                    }
                }
                break;
            case R.id.avalve_btn8:
                if(event.getAction()== MotionEvent.ACTION_UP){
                    if(avalve_btn8.isPressed()){
                        btn_flag=false;
                        byte[] b = {0};
                        MyApplication.getInstance().mdbuswritebyte(1,b,11,1);
                    }else{
                        btn_flag=false;
                        byte[] b = {1};
                        MyApplication.getInstance().mdbuswritebyte(1,b,11,1);
                    }
                }
                break;
            case R.id.avalve_btn9:
                if(event.getAction()== MotionEvent.ACTION_UP){
                    if(avalve_btn9.isPressed()){
                        btn_flag=false;
                        byte[] b = {0};
                        MyApplication.getInstance().mdbuswritebyte(1,b,12,1);
                    }else{
                        btn_flag=false;
                        byte[] b = {1};
                        MyApplication.getInstance().mdbuswritebyte(1,b,12,1);
                    }
                }
                break;
            case R.id.avalve_btn10:
                if(event.getAction()== MotionEvent.ACTION_UP){
                    if(avalve_btn10.isPressed()){
                        btn_flag=false;
                        byte[] b = {0};
                        MyApplication.getInstance().mdbuswritebyte(1,b,13,1);
                    }else{
                        btn_flag=false;
                        byte[] b = {1};
                        MyApplication.getInstance().mdbuswritebyte(1,b,13,1);
                    }
                }
                break;
            case R.id.avalve_btn11:
                if(event.getAction()== MotionEvent.ACTION_UP){
                    if(avalve_btn11.isPressed()){
                        btn_flag=false;
                        byte[] b = {0};
                        MyApplication.getInstance().mdbuswritebyte(1,b,0,1);
                    }else{
                        btn_flag=false;
                        byte[] b = {1};
                        MyApplication.getInstance().mdbuswritebyte(1,b,0,1);
                    }
                }
                break;
            case R.id.avalve_btn12:
                if(event.getAction()== MotionEvent.ACTION_UP){
                    if(avalve_btn12.isPressed()){
                        btn_flag=false;
                        byte[] b = {0};
                        MyApplication.getInstance().mdbuswritebyte(1,b,1,1);
                    }else{
                        btn_flag=false;
                        byte[] b = {1};
                        MyApplication.getInstance().mdbuswritebyte(1,b,1,1);
                    }
                }
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
