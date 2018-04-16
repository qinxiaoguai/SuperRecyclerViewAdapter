package com.qinxiaoguai.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * created 秦小怪
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn4;
    private Button mBtn5;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mBtn1 = (Button) findViewById(R.id.btn_1);
        mBtn2 = (Button) findViewById(R.id.btn_2);
        mBtn3 = (Button) findViewById(R.id.btn_3);
        mBtn4 = (Button) findViewById(R.id.btn_4);
        mBtn5 = (Button) findViewById(R.id.btn_5);

        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
        mBtn4.setOnClickListener(this);
        mBtn5.setOnClickListener(this);
    }

    @Override public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                startActivity(new Intent(MainActivity.this, Btn1LayoutActivity.class));
                break;
            case R.id.btn_2:
                startActivity(new Intent(MainActivity.this, Btn2LayoutActivity.class));
                break;
            case R.id.btn_3:
                break;
            case R.id.btn_4:
                startActivity(new Intent(MainActivity.this, Btn4LayoutActivity.class));
                break;
            case R.id.btn_5:
                break;
        }
    }
}
