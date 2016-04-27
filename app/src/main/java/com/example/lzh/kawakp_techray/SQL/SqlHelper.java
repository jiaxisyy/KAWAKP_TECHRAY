package com.example.lzh.kawakp_techray.SQL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zuheng.lv on 2016/4/25.
 */
public class SqlHelper extends SQLiteOpenHelper{


    public SqlHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE timesetting("+
                "id int auto_increment  primary key , "+
                "view varchar(30) NOT NULL ,"+
                "pressure double,"+
                "flow double,"+
                "oxy double,"+
                "dew double)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
