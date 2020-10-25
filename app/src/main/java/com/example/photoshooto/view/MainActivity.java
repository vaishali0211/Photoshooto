package com.example.photoshooto.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.photoshooto.R;
import com.example.photoshooto.utils.Util;
import com.example.photoshooto.view.adapter.MyAdapter;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager2 myViewPager2;
    ImageView photo_of_the_day;
    WormDotsIndicator wormDotsIndicator;
    com.example.photoshooto.view.adapter.MyAdapter MyAdapter;
    private ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myViewPager2 = findViewById(R.id.view_pager);
        photo_of_the_day = findViewById(R.id.photo_of_the_day);
        wormDotsIndicator =  findViewById(R.id.worm_dots_indicator);

        Glide.with(this).load("https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg").into(photo_of_the_day);
        arrayList.add("https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg");
        arrayList.add("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg");
        arrayList.add("https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg");
        arrayList.add("https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg");
        arrayList.add("https://s3.amazonaws.com/uifaces/faces/twitter/stephenmoon/128.jpg");
        arrayList.add("https://s3.amazonaws.com/uifaces/faces/twitter/bigmancho/128.jpg");

        MyAdapter = new MyAdapter(this, arrayList);


        myViewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        myViewPager2.setAdapter(MyAdapter);
        wormDotsIndicator.setViewPager2(myViewPager2);
        myViewPager2.setClipToPadding(false);
        myViewPager2.setClipChildren(false);
        myViewPager2.setOffscreenPageLimit(3);
        myViewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1- Math.abs(position);
                page.setScaleY(0.85f+r*0.15f);
            }
        });
        myViewPager2.setPageTransformer(compositePageTransformer);
    }


}