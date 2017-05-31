package com.example.ace02;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.collasping_tb);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，设置到Toolbar上则不会显示
        CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collasping_ctl);
        mCollapsingToolbarLayout.setTitle("ACE_DEMO");
        //通过CollapsingToolbarLayout修改字体颜色
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.RED);//设置收缩后Toolbar上字体的颜色

        initDate();
    }

    private void initDate() {
        mRecyclerView = (RecyclerView) this.findViewById(R.id.collasping_rv);
        mRecyclerView.setVisibility(View.VISIBLE);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        ArrayList<HashMap<String, Object>> dataList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("leftimg", R.mipmap.ic_bottom_toys);
            map.put("middletext", (i + 1));
            map.put("rightimg", R.mipmap.ic_bottom_music);
            dataList.add(map);
        }
        mRecyclerView.addItemDecoration(new RecyclerViewDivider(HomeActivity.this, LinearLayoutManager.HORIZONTAL, 2, R.color.colorPrimary));
        mRecyclerView.setAdapter(new MyRecyclerViewAdapter(this, dataList));
    }

}
