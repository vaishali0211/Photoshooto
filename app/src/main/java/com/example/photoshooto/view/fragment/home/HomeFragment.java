package com.example.photoshooto.view.fragment.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.photoshooto.R;
import com.example.photoshooto.utils.Util;
import com.example.photoshooto.view.adapter.MyAdapter;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    ViewPager2 myViewPager2;
    ImageView photo_of_the_day;
    WormDotsIndicator wormDotsIndicator;
    MyAdapter myAdapter = new MyAdapter(getContext(),new ArrayList<String>());
    private ArrayList<String> arrayList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        myViewPager2 = root.findViewById(R.id.view_pager);
        photo_of_the_day = root.findViewById(R.id.photo_of_the_day);
        wormDotsIndicator = root.findViewById(R.id.worm_dots_indicator);
        Util.loadImage(photo_of_the_day,"https://s3.amazonaws.com/uifaces/faces/twitter/stephenmoon/128.jpg");
        observeViewModel();
        arrayList.add("https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg");
        arrayList.add("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg");
        arrayList.add("https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg");
        arrayList.add("https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg");
        arrayList.add("https://s3.amazonaws.com/uifaces/faces/twitter/stephenmoon/128.jpg");
        arrayList.add("https://s3.amazonaws.com/uifaces/faces/twitter/bigmancho/128.jpg");

        myAdapter.updatePicModelArrayList(arrayList);

        myViewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        myViewPager2.setAdapter(myAdapter);
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

        return root;
    }

    private void observeViewModel() {
        homeViewModel.getArrayList().observe(getViewLifecycleOwner(), new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> pic_list) {
                if (pic_list != null) {

                    myAdapter.updatePicModelArrayList(arrayList);
                    myAdapter.notifyDataSetChanged();
//                    setViewPager(myAdapter);

                }
            }
        });
    }

//    private void setViewPager(MyAdapter myAdapter) {
//        myViewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
//
//        myViewPager2.setAdapter(myAdapter);
//        wormDotsIndicator.setViewPager2(myViewPager2);
//        myViewPager2.setClipToPadding(false);
//        myViewPager2.setClipChildren(false);
//        myViewPager2.setOffscreenPageLimit(3);
//        myViewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
//
//        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
//        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
//        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
//            @Override
//            public void transformPage(@NonNull View page, float position) {
//                float r = 1- Math.abs(position);
//                page.setScaleY(0.85f+r*0.15f);
//            }
//        });
//        myViewPager2.setPageTransformer(compositePageTransformer);
//    }

}