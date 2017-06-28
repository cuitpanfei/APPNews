package com.pf.pwhlnews;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.pf.pwhlnews.activities.ShowArticleActivity;
import com.pf.pwhlnews.activities.UserInfoActivity;
import com.pf.pwhlnews.adapter.MyAdapter;
import com.pf.pwhlnews.bean.DescBean;
import com.pf.pwhlnews.dao.DescDao;
import com.pf.pwhlnews.views.RoundImageView;

import java.util.List;

import static com.pf.pwhlnews.util.Utils.addListener;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    List<DescBean> data = null;
    int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDrawer(initBar());

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        RoundImageView userImage = (RoundImageView) navigationView.getHeaderView(0).findViewById(R.id.imageView);
        addListener(userImage,this,UserInfoActivity.class);
        navigationView.setNavigationItemSelectedListener(this);


        ListView lv = (ListView) findViewById(R.id.listView);

        data = queryAllData();
        cont = data.size();
        if (cont != 0) {
            MyAdapter adapter = new MyAdapter(this, data);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> arg0, View view, int position,
                                        long arg3) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("article", data.get(position));
                    Intent intent = new Intent(MainActivity.this, ShowArticleActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        } else
            Log.v("No Data", "记录为空！！！！");

    }


    private void initDrawer(Toolbar toolbar) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    private Toolbar initBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        return toolbar;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private List<DescBean> queryAllData() {
        DescDao descDao = new DescDao(this);
        return descDao.listCache(null, null);
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();

    }
}
