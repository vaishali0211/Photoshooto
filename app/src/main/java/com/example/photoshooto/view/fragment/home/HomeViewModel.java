package com.example.photoshooto.view.fragment.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class HomeViewModel extends AndroidViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<ArrayList<String>> arrayList = new MutableLiveData<ArrayList<String>>();


    public HomeViewModel(@NonNull Application application) {
        super(application);

//        mText = new MutableLiveData<>();
//        mText.setValue("This is home fragment");
        ArrayList<String> picList = new ArrayList<>();
        picList.add("https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg");
        picList.add("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg");
        picList.add("https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg");
        picList.add("https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg");
        picList.add("https://s3.amazonaws.com/uifaces/faces/twitter/stephenmoon/128.jpg");
        picList.add("https://s3.amazonaws.com/uifaces/faces/twitter/bigmancho/128.jpg");
        arrayList.setValue(picList);
    }

    public MutableLiveData<ArrayList<String>> getArrayList() {
        return arrayList;
    }

    public LiveData<String> getText() {
        return mText;
    }
}