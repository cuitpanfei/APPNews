
package com.pf.pwhlnews.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.pf.pwhlnews.util.Constant.DISCRIPTIONS;
import static com.pf.pwhlnews.util.Constant.EASSAYS;
import static com.pf.pwhlnews.util.Constant.PICURLS;
import static com.pf.pwhlnews.util.Constant.TITLES;

public class SQLHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "database.db";// 数据库名称
    public static final int VERSION = 1;

    public static final String TABLE_ARTICLE = "Article";// 数据表

    public static final String ID = "id";//
    public static final String TITLE = "title";
    public static final String DISCRIPTION = "description";
    public static final String EASSAY = "eassay";
    public static final String URL = "url";
    public static final String PICURL = "picUrl";
    private final Context context;

    public SQLHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO 创建数据库后，对数据库的操作
        String sql = "create table if not exists " + TABLE_ARTICLE +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ID + " INTEGER , " +
                TITLE + " TEXT , " +
                DISCRIPTION + " TEXT , " +
                PICURL + " TEXT , " +
                EASSAY + " TEXT)";
        db.execSQL(sql);
        init(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO 更改数据库版本的操作
        onCreate(db);
    }

    private void init(SQLiteDatabase db) {
        for (int i = 0; i < 10; i++) {
            db.execSQL("insert into " + TABLE_ARTICLE +
                    "("+ID+","+TITLE+","+PICURL+","+DISCRIPTION+","+EASSAY+") " +
                    "values(\'" + i + "\', \'" + TITLES[i] + "\', \'" + PICURLS[i] +
                    "\', \'"+ DISCRIPTIONS[i] + "\', \'"+ EASSAYS[i]+"\')");
        }
    }

}
