package com.example.drawer.ui.withdraw;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WithdrawViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public WithdrawViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is withdraw fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}