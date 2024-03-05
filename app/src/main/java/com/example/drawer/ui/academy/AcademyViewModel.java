package com.example.drawer.ui.academy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AcademyViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AcademyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Academy fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}