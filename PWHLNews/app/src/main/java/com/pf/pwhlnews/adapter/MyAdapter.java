package com.pf.pwhlnews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pf.pwhlnews.R;
import com.pf.pwhlnews.bean.DescBean;

import java.util.List;

/**
 * Created by cuitpf on 2017/6/7.
 */

public class MyAdapter extends BaseAdapter {

    private List data;
    private Context context;//用于接收传递过来的Context对象

    public MyAdapter(Context context, List<DescBean> data) {
        super();
        this.context = context;
        this.data = data;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }


    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        //这里是为了优化listview的性能
        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.item_listview_introduce, null);//这一句就是把 xml装到listview里
        addResourse(i, view);
        return view;
    }

    private View addResourse(int i, View view) {
        ImageView iv = (ImageView) view.findViewById(R.id.iv_introduce_img);
        TextView title = (TextView) view.findViewById(R.id.tv_introduce_name);
        TextView desc = (TextView) view.findViewById(R.id.tv_desc);
        DescBean descBean = (DescBean) data.get(i);
        iv.setImageResource(descBean.getPicUrl());
        title.setText(descBean.getTitle());
        desc.setText(descBean.getDescription());
        return view;
    }

}
