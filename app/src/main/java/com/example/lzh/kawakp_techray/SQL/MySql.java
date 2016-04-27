package com.example.lzh.kawakp_techray.SQL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by zuheng.lv on 2016/4/25.
 */
public class MySql extends SqlHelper{

    public MySql(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void saveData(){

    }

}
