package com.kv.popupimageview;

import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.kv.popupimageview.helper.CustomPagerAdapter;
import com.kv.popupimageview.helper.SetImageBitmap;
import com.kv.popupimageview.listener.OnDismiss_Listener;

import java.util.ArrayList;


import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class PopupImageView extends PopupWindow {

    private View mContentView;

    /**
     * dialog with single image
     *
     * @param ctx
     * @param baseView
     * @param image_url
     */
    public PopupImageView(Context ctx, View baseView, String image_url) {
        super(((LayoutInflater) ctx.getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.popup_photo_full, null), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        init(baseView);

        new SetImageBitmap(ctx, mContentView, image_url);
    }

    /**
     * dialog with multiple image
     *
     * @param ctx
     * @param baseView
     * @param arr_img
     */
    public PopupImageView(Context ctx, View baseView, ArrayList<String> arr_img) {
        super(((LayoutInflater) ctx.getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.popup_photo_pager, null), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        init(baseView);

        ViewPager viewPager = mContentView.findViewById(R.id.view_pager);
        viewPager.setAdapter(new CustomPagerAdapter(ctx, arr_img, null));
    }

    /**
     * dialog with multiple image and selected item position
     *
     * @param ctx
     * @param baseView
     * @param arr_img
     * @param selected_position
     */
    public PopupImageView(Context ctx, View baseView, ArrayList<String> arr_img, int selected_position) {
        super(((LayoutInflater) ctx.getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.popup_photo_pager, null), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        init(baseView);

        ViewPager viewPager = mContentView.findViewById(R.id.view_pager);
        viewPager.setAdapter(new CustomPagerAdapter(ctx, arr_img, null));
        viewPager.setCurrentItem(selected_position);
    }

    /**
     * for multiple image with base url and selected item position
     *
     * @param ctx
     * @param baseView
     * @param baseUrl
     * @param arr_img
     * @param selected_position
     */
    public PopupImageView(Context ctx, View baseView, ArrayList<String> arr_img, int selected_position, String baseUrl) {
        super(((LayoutInflater) ctx.getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.popup_photo_pager, null), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        init(baseView);

        ViewPager viewPager = mContentView.findViewById(R.id.view_pager);
        if (baseUrl.equalsIgnoreCase("")) {
            baseUrl = null;
        }
        viewPager.setAdapter(new CustomPagerAdapter(ctx, arr_img, baseUrl));
        viewPager.setCurrentItem(selected_position);
    }

    private void init(View baseView) {
        this.mContentView = getContentView();

        if (Build.VERSION.SDK_INT >= 21) {
            setElevation(5.0f);
        }

        setFocusable(true);
        setOutsideTouchable(true);

        showAtLocation(baseView, Gravity.CENTER, 0, 0);

        SetImageBitmap.setInterface(new OnDismiss_Listener() {
            @Override
            public void onDismiss() {
                dismiss();
            }
        });
    }
}
