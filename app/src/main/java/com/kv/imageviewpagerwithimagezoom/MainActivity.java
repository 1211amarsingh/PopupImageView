package com.kv.imageviewpagerwithimagezoom;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kv.popupimageview.PopupImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private ArrayList<String> arr_img = new ArrayList<>();
    ImageView imageView1, imageView2, imageView3, imageView4;

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
    }

    public void imgclick1(View view) {
        new PopupImageView(context, view, "https://loremflickr.com/640/360");
    }

    public void imgclick2(View view) {
        new PopupImageView(context, view, arr_img);

    }

    public void imgclick3(View view) {
        new PopupImageView(context, view, arr_img,2);
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
    }
}
