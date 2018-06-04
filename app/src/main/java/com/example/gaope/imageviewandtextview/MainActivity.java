package com.example.gaope.imageviewandtextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ScrollView;

/**
 * 图文混排
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ScrollView scrollView;
    private String[] data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //解析要展示的图片与文字数据
        parseData();

        scrollView = (ScrollView) findViewById(R.id.scrollView);
        //在ScrollView中加入自定义的ImageAndTextView()，在ImageAndTextView()中进行图文混排
        scrollView.addView(new ImageAndTextView(this,data));
    }

    private void parseData() {
        //split()方法根据匹配给定的正则表达式来拆分字符串，返回字符串数组
        data = Data.getData().split(Data.TAG_SPACE);
        Log.d(TAG,":" + data.length);
    }
}
