package com.example.gaope.imageviewandtextview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import uk.co.senab.photoview.PhotoView;

/**
 * 自定义View中用context.startActivity()打开Activity
 */

public class PhotoViewActivity extends AppCompatActivity {

    private static final String TAG = "PhotoViewActivity";

    private int startPositions;
    private List<String> urls;
    private Context context;
    private MyViewPager myViewPager;
    private PhotoView photoView;
    private ViewPagerAdapter viewPagerAdapter;

    public static void startPhotoViewActivity(Context context, int startPosition, List<String> urlLists){
        Intent intent = new Intent(context,PhotoViewActivity.class);
        intent.putExtra("startPosition", startPosition);
        intent.putExtra("urlList", new ArrayList<String>(urlLists));
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);

        urls = getIntent().getStringArrayListExtra("urlList");
        Log.d(TAG,"size:"+urls.size());
        startPositions = getIntent().getIntExtra("startPosition",0);

        photoView = (PhotoView) findViewById(R.id.photo_view);
        myViewPager = (MyViewPager) findViewById(R.id.view_pager);
        viewPagerAdapter = new ViewPagerAdapter(getBaseContext(),urls,startPositions);
        myViewPager.setAdapter(viewPagerAdapter);
    }

}
