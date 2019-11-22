package com.kv.popupimageviews1;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.kv.popupimageview.PopupImageView;

import java.util.ArrayList;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private ArrayList<String> arr_img = new ArrayList<>();
    ImageView imageView1, imageView2, imageView3, imageView4;
    AdView mAdView;
    FrameLayout adContainerView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        context = this;
        arr_img.add("https://loremflickr.com/640/360");
        arr_img.add("https://placekitten.com/640/360");
        arr_img.add("https://www.fillmurray.com/640/360");
        arr_img.add("https://picsum.photos/id/237/200/300");
        arr_img.add("https://picsum.photos/200/300/?blur");
        arr_img.add("https://picsum.photos/200/300?grayscale");

        imageView1 = findViewById(R.id.img_1);
        imageView2 = findViewById(R.id.img_2);
        imageView3 = findViewById(R.id.img_3);
        imageView4 = findViewById(R.id.img_4);

        Glide.with(context).load(arr_img.get(0)).into(imageView1);
        Glide.with(context).load(arr_img.get(1)).into(imageView2);
        Glide.with(context).load(arr_img.get(2)).into(imageView3);
        Glide.with(context).load("https://picsum.photos/id/12/2500/1667").into(imageView4);

        adContainerView = findViewById(R.id.ad_view_container);
        adContainerView.post(new Runnable() {
            @Override
            public void run() {
                loadBanner();
            }
        });
    }

    public void imgclick1(View view) {
        new PopupImageView(context, view, "https://loremflickr.com/640/360");
        viewAdsInterstitial();
    }

    public void imgclick2(View view) {
        new PopupImageView(context, view, arr_img);
        viewAdsInterstitial();
    }

    public void imgclick3(View view) {
        new PopupImageView(context, view, arr_img, 2);
        viewAdsInterstitial();
    }


    public void imgclick4(View view) {
        String base_url = "https://picsum.photos/";
        ArrayList<String> arrayListImage = new ArrayList<>();
        arrayListImage.add("200/300?random=1");
        arrayListImage.add("200/300?random=2");
        arrayListImage.add("200/300?random=3");
        arrayListImage.add("200/300?random=4");
        arrayListImage.add("200/300?random=5");
        arrayListImage.add("200/300?random=6");
        arrayListImage.add("200/300?random=7");

        new PopupImageView(context, view, arrayListImage, 1, base_url);
        viewAdsInterstitial();
    }

    private void loadBanner() {
        MobileAds.initialize(this, this.getResources().getString(R.string.app_id));

        mAdView = new AdView(this);

        mAdView.setAdUnitId(this.getResources().getString(R.string.banner_1));
        adContainerView.removeAllViews();
        adContainerView.addView(mAdView);

        AdSize adSize = getAdSize();
        mAdView.setAdSize(adSize);
        mAdView.loadAd(new AdRequest.Builder().build());

        viewAdsInterstitial();
    }

    private AdSize getAdSize() {
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float density = outMetrics.density;

        int widthPixels = outMetrics.widthPixels;

        int adWidth = (int) (widthPixels / density);
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth);
    }


    private void viewAdsInterstitial() {

        if (mInterstitialAd == null) {
            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId(this.getResources().getString(R.string.interstitial_1));
        }
        if (!mInterstitialAd.isLoaded())
            mInterstitialAd.loadAd(new AdRequest.Builder().build());


        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }
}
