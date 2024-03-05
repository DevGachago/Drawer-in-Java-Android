package com.example.drawer.ui.flexclub;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FlexViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public FlexViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is flex club fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}