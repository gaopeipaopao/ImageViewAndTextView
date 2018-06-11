package com.example.gaope.imageviewandtextview;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import uk.co.senab.photoview.PhotoView;

/**
 * ViewPager的适配器
 * Created by gaope on 2018/6/5.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private List<String> urlList;
    private Context context;
    private int startPosition;
    private int resId;
    private String url;

    public ViewPagerAdapter(Context context,List<String> urlList,int startPosition){
        this.urlList = urlList;
        this.context = context;
        this.startPosition = startPosition;
    }

    @Override
    public int getCount() {

        return urlList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_photoview,container,false);
        PhotoView photoView = (PhotoView) view.findViewById(R.id.photo_view);
        if (urlList.get(position).contains(Data.TAG_URL_IMAGE)){
            url = urlList.get(position).replace(Data.TAG_URL_IMAGE,"");
            Glide.with(context).load(url).into(photoView);
        }
        if (urlList.get(position).contains(Data.TAG_DRAWABLE_IMAGE)){
            resId = Integer.parseInt(urlList.get(position).replace(Data.TAG_DRAWABLE_IMAGE,""));
            Glide.with(context).load(resId).into(photoView);
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }
}
