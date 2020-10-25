package com.example.photoshooto.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.photoshooto.R;


public class Util {

    public static void loadImage(ImageView imageView, String url) {
        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .error(R.mipmap.ic_launcher);

        Glide.with(imageView.getContext())
                .setDefaultRequestOptions(options)
                .load(url)
                .into(imageView);
    }

//    public static CircularProgressDrawable setProgressDrawable(Context context) {
//        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(context);
//        circularProgressDrawable.setStrokeWidth(10f);
//        circularProgressDrawable.setCenterRadius(50f);
//        circularProgressDrawable.setColorSchemeColors(R.color.black);
//        return circularProgressDrawable;
//    }
//


}
