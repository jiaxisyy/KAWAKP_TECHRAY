package com.example.lzh.kawakp_techray.serialJNI;


public class serialJNI {
    static {
        System.loadLibrary("serialJNI");
    }

    public native boolean init();

    public native int mainloop();

    /**
     * 读取位元件,eg:X,Y,M,SM,
     */
    public native byte[] mdbusreadbyte(int type, int stadr, int len);

    /**
     * 写入位元件,eg:X,Y,M,SM,
     */
    public native int mdbuswritebyte(int type, byte buf[], int stadr, int len);

    /**
     * 读单字元件,eg:D,R
     */
    public native short[] mdbusreadword(int type, int stadr, int len);

    /**
     * 写入字元件,eg:D,R
     */
    public native int mdbuswriteword(int type, short buf[], int stadr, int len);

    /**
     * 读双字元件,eg:D,R
     */
    public native int[] mdbusreaddword(int type, int stadr, int len);

    /**
     * 写双字元件,eg:D,R
     */
    public native int mdbuswritedword(int type, int buf[], int stadr, int len);

    /**
     * 读浮点数元件,eg:D,R
     */
    public native float[] mdbusreadreal(int type, int stadr, int len);


    /**
     * 写入浮点数元件,eg:D,R
     */
    public native int mdbuswritereal(int type, float buf[], int stadr, int len);

    public native void destory();
}