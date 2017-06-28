package com.pf.pwhlnews.dao;

import android.content.ContentValues;

import com.pf.pwhlnews.bean.DescBean;
import com.pf.pwhlnews.db.SQLHelper;

import java.util.List;
import java.util.Map;

/**
 * Created by cuitpf on 2017/6/12.
 */

public interface DescDaoInface {


    public DescBean viewCache(String selection,
                              String[] selectionArgs);

    public List<DescBean> listCache(String selection,
                                               String[] selectionArgs);

}
