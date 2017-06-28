package com.pf.pwhlnews.util;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;

import com.pf.pwhlnews.bean.DescBean;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static com.pf.pwhlnews.util.GsonUtil.GsonToBean;


/**
 * Created by cuitpf on 2017/6/12.
 */

public class Utils {

    /**
     * 创建目录
     *
     * @param path
     */
    public static void createDirs(File path) {
        if (path != null && !path.exists()) {
            path.mkdirs();
        }
    }

    /**
     * 文件是否存在
     *
     * @param file
     * @return
     */
    public static boolean isFileExist(File file) {
        if (file != null && file.exists()) {
            return true;
        }
        return false;
    }

    /**
     * @param cursor
     * @param cols_len
     * @return
     */
    public static DescBean cursorToDesc(Cursor cursor, int cols_len) {
        Map<String, Object> map = new HashMap<String, Object>();
        for (int i = 0; i < cols_len; i++) {
            String cols_name = cursor.getColumnName(i);
            String cols_values = cursor.getString(cursor
                    .getColumnIndex(cols_name));
            if (cols_values == null) {
                cols_values = "";
            }
            map.put(cols_name, cols_values);
        }
        map.remove("_id");

        return GsonToBean(GsonUtil.GsonString(map), DescBean.class);
    }


    public static <T> void addListener(View view, Context context, Class<T> cls) {
        final Context cont = context;
        final Class<T> clazz = cls;

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(cont,clazz);
                cont.startActivity(intent);
            }
        });

    }

}
