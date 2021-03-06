package com.kv.popupimageview.helper;

import android.content.Context;

import androidx.annotation.NonNull;
//import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.viewpager.widget.PagerAdapter;

import com.kv.popupimageview.R;

import java.util.ArrayList;

public class CustomPagerAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<String> arr_img;
    private LayoutInflater mLayoutInflater;
    private String baseUrl;

    public CustomPagerAdapter(Context context, ArrayList<String> arr_img, String baseUrl) {
        mContext = context;
        this.arr_img = arr_img;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.baseUrl = baseUrl;
    }

    @Override
    public int getCount() {
        if (arr_img != null) {
            return arr_img.size();
        } else {
            return 0;
        }
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.popup_photo_full, container, false);
        String img_url = baseUrl != null ? baseUrl + arr_img.get(position) : arr_img.get(position);
        new SetImageBitmap(mContext, itemView, img_url);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}