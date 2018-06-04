package com.example.gaope.imageviewandtextview;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

/**
 * 自定义View实现图文混排
 * Created by gaope on 2018/6/4.
 */

public class ImageAndTextView extends LinearLayout {

    private static final String TAG = "ImageAndTextView";

    private String[] data;
    private Context context;

    /**
     * 图片的最大高度
     */
    private int maxHeight = 900;

    /**
     * 图片的最小高度
     */
    private int minHeight = 500;

    /**
     *
     * @param context
     * @param data
     */

    public ImageAndTextView(Context context,String[] data){
        super(context);
        //设置LinearLayout为垂直布局
        this.setOrientation(VERTICAL);
        this.data = data;
        this.context = context;
        init();
    }

    private void init() {
        for (int i = 0;i < data.length;i++){
            if (data[i].contains(Data.TAG_TEXT)){
                TextView tv = new TextView(context);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                //replace() 方法通过用 newChar 字符替换字符串中出现的所有 oldChar 字符，并返回替换后的新字符串
                tv.setText(data[i].replace(Data.TAG_TEXT,""));
                Log.d(TAG,"dd:"+data[i]);
                tv.setTextColor(Color.BLACK);
                tv.setGravity(Gravity.CENTER_VERTICAL);
                tv.setPadding(20,20,20,20);
                tv.setTextSize(17);
                //设置文本是否包含顶部和底部额外空白
                tv.setIncludeFontPadding(false);
                //先增加android:lineSpacingMultiplier设置的倍数，再加上android:lineSpacingExtra设置的额外的间距
                tv.setLineSpacing(10, (float) 1.2);
                addView(tv,lp);
            }else if (data[i].contains(Data.TAG_URL_IMAGE)){

                final ImageView im = new ImageView(context);
                String url = data[i].replace(Data.TAG_URL_IMAGE,"");
                Log.d(TAG,"url:"+url);
                im.setPadding(20,20,20,20);
                //利用 scaleType 的 center_crop 效果，让图片能始终按比例填充容器，不留空白区域
                im.setScaleType(ImageView.ScaleType.CENTER_CROP);
                //Glide:with()获得实例，placeholder()占位图，diskCacheStrategy()没有缓存
                Glide.with(context).load(url)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .placeholder(Color.WHITE)
                        .into(new GlideDrawableImageViewTarget(im){
                            @Override
                            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> animation) {
                                //在Glide的onResourceReady()方法中，可以获取到Glide加载出来的图片对象
                                super.onResourceReady(resource, animation);
                                Log.d(TAG,"1:"+resource.getMinimumWidth());
                                Log.d(TAG,"1:"+resource.getMinimumHeight());
                                int height = resource.getIntrinsicHeight();
                                if (height < minHeight){
                                    height = minHeight;
                                }
                                if (height > maxHeight){
                                    height = maxHeight;
                                }
                                Log.d(TAG,"hei:"+height);
                                im.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,minHeight));

                            }
                        });
                im.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                addView(im);
            }else if (data[i].contains(Data.TAG_DRAWABLE_IMAGE)){
                final ImageView im = new ImageView(context);
                im.setScaleType(ImageView.ScaleType.CENTER_CROP);
                im.setPadding(20,20,20,20);
                int resId = Integer.parseInt(data[i].replace(Data.TAG_DRAWABLE_IMAGE,""));
                Glide.with(context).load(resId)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .placeholder(Color.WHITE)
                        .into(new GlideDrawableImageViewTarget(im){
                            @Override
                            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> animation) {
                                //在Glide的onResourceReady()方法中，可以获取到Glide加载出来的图片对象
                                super.onResourceReady(resource, animation);
                                Log.d(TAG,"2:"+resource.getMinimumWidth());
                                Log.d(TAG,"2:"+resource.getMinimumHeight());
                                int height = resource.getIntrinsicHeight();
                                if (height < minHeight){
                                    height = minHeight;
                                }
                                if (height > maxHeight){
                                    height = maxHeight;
                                }
                                Log.d(TAG,"hei:"+height);
                                im.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,minHeight));

                            }
                        });
                im.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                addView(im);

            }
        }
    }

}
