package com.example.photoshooto.view.fragment.cameras_sale;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CamerasSaleViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CamerasSaleViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is cameras sale fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}