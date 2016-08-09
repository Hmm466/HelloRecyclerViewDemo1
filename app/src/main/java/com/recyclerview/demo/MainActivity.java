package com.recyclerview.demo;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final int[] imageRes = new int []{
        R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6,R.drawable.p7,R.drawable.p8
    };

    private MyAdapter myAdapter;

    private SwipeRefreshLayout mSwipeRefreshLayout;

    private RecyclerView recyclerView;

    private StaggeredGridLayoutManager mStaggerdGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        mStaggerdGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        //设置layoutManager
        recyclerView.setLayoutManager(mStaggerdGridLayoutManager);

        myAdapter = new MyAdapter(new ArrayList<Photo>());

        recyclerView.setAdapter(myAdapter);
        //设置item之间的间隔
        SpacesItemDecoration decoration=new SpacesItemDecoration(2);

        recyclerView.addItemDecoration(decoration);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh_layout);

        mSwipeRefreshLayout.setColorSchemeColors(Color.RED, Color.BLUE);
        
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //  new MoreArticleTask().execute(mAdapter.getTopArticleId());
                Toast.makeText(getApplicationContext(),"刷新",Toast.LENGTH_SHORT).show();
                for(int i = 0 ; i < myAdapter.getItemCount() ;i ++) {
                    myAdapter.removeData(i);
                }
                refreshing();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
                refreshing();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }


    private void refreshing(){
        for(int i = 0 ; i < imageRes.length; i++){
            Photo photo = new Photo(imageRes[(int)(Math.random()*imageRes.length)],"这是第"+(int)(Math.random()*imageRes.length)+":"+i+"张图片");
            myAdapter.addData(i,photo);
        }
    }

    private void loadMore(){

    }
}
