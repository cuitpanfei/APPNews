package com.pf.pwhlnews.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pf.pwhlnews.MainActivity;
import com.pf.pwhlnews.R;
import com.pf.pwhlnews.bean.DescBean;

public class ShowArticleActivity extends AppCompatActivity {
    Intent intent = null;
    DescBean descBean = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = this.getIntent();
        descBean = (DescBean) intent.getSerializableExtra("article");
        setContentView(R.layout.activity_show_article);
        init();

    }

    private void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.arti_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(ShowArticleActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        addData2Layout(descBean);
    }

    private void addData2Layout(DescBean descBean) {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.content_show_article);
        ((TextView) linearLayout.findViewById(R.id.article_title)).setText(descBean.getTitle());
        ((TextView) linearLayout.findViewById(R.id.article_data)).setText(descBean.getCtime());
        ((ImageView) linearLayout.findViewById(R.id.article_pic)).setImageResource(descBean.getPicUrl());
        ((TextView) linearLayout.findViewById(R.id.article_eassay)).setText(descBean.getEassay());
    }

}
