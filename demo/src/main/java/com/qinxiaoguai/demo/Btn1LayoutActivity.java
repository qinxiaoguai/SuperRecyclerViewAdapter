package com.qinxiaoguai.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import com.qinxiaoguai.library.SuperRecyclerAdapter;
import com.qinxiaoguai.library.SuperRecyclerHolder;
import java.util.ArrayList;
import java.util.List;

/**
 * 线性布局-纵向
 *
 * Created by 秦小怪 on 2017/8/22.
 */
public class Btn1LayoutActivity extends AppCompatActivity {

    private RecyclerView mRv;

    private SuperRecyclerAdapter<String> mAdapter;
    private List<String> mList = new ArrayList<>();

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn1);
        initView();
        initData();
    }

    private void initView() {

        mRv = (RecyclerView) findViewById(R.id.rv);

        mAdapter = new SuperRecyclerAdapter<String>(this, mList) {
            @Override
            public void convert(SuperRecyclerHolder holder, final String s, int layoutType,
                final int position) {
                //只有一种布局，不使用layoutType来区分type了
                holder//
                    .setText(R.id.tv_content, s)
                    .setOnItemClickListenner(new View.OnClickListener() {
                        @Override public void onClick(View v) {
                            Toast.makeText(Btn1LayoutActivity.this, "item点击:" + s,
                                Toast.LENGTH_SHORT).show();
                        }
                    });
            }

            @Override public int getLayoutAsViewType(String s, int position) {
                return R.layout.recycler_item_btn1;
            }
        };

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRv.setLayoutManager(layoutManager);
        mRv.setAdapter(mAdapter);
    }

    private void initData() {
        for (int i = 0; i < 100; i++) {
            mList.add("秦小怪-" + i);
        }

        mAdapter.notifyDataSetChanged();
    }
}
