package com.pf.pwhlnews.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.pf.pwhlnews.bean.DescBean;
import com.pf.pwhlnews.db.SQLHelper;

import java.util.ArrayList;
import java.util.List;

import static com.pf.pwhlnews.util.Utils.cursorToDesc;

/**
 * Created by cuitpf on 2017/6/12.
 */

public class DescDao implements DescDaoInface {
    private SQLHelper helper = null;


    public DescDao(Context context) {
        helper = new SQLHelper(context);
    }

    @Override
    public DescBean viewCache(String selection, String[] selectionArgs) {
        SQLiteDatabase database = null;
        Cursor cursor = null;
        DescBean data = null;
        try {
            database = helper.getReadableDatabase();
            database.beginTransaction();
            cursor = database.query(true, SQLHelper.TABLE_ARTICLE, null, selection,
                    selectionArgs, null, null, null, null);
            int cols_len = cursor.getColumnCount();
            while (cursor.moveToNext()) {
                data = cursorToDesc(cursor, cols_len);
            }
            database.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (database != null) {
                database.endTransaction();
                cursor.close();
                database.close();
            }
        }
        return data;
    }

    /**
     *
     * @param selection 条件字句，相当于where。
     * @param selectionArgs 条件字句，参数数据
     * @return
     */
    @Override
    public List<DescBean> listCache(String selection, String[] selectionArgs) {
        List<DescBean> list = new ArrayList<DescBean>();
        SQLiteDatabase database = null;
        Cursor cursor = null;
        try {
            database = helper.getReadableDatabase();
            database.beginTransaction();
            cursor = database.query(false, SQLHelper.TABLE_ARTICLE, null, selection, selectionArgs,
                    null, null, null, null);
            int cols_len = cursor.getColumnCount();
            while (cursor.moveToNext()) {
                list.add(cursorToDesc(cursor, cols_len));
            }

            database.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (database != null) {
                database.endTransaction();
                cursor.close();
                database.close();
            }
        }
        return list;
    }

}
