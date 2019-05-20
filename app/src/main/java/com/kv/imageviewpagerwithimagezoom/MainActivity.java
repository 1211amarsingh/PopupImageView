package com.kv.imageviewpagerwithimagezoom;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kv.popupimageview.PopupImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private ArrayList<String> arr_img = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        context = this;
        arr_img.add("https://loremflickr.com/640/360");
        arr_img.add("https://placekitten.com/640/360");
        arr_img.add("https://www.fillmurray.com/640/360");
        arr_img.add("http://via.placeholder.com/640x360");
        arr_img.add("https://dummyimage.com/640x360/fff/aaa");
    }

    public void imgclick(View view) {
        new PopupImageView(context, view, arr_img);
    }

    public void imgclick1(View view) {
        new PopupImageView(context, view, arr_img.get(0));
    }
}
