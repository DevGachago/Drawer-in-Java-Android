package com.example.drawer.ui.invitefriends;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InviteFriendsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public InviteFriendsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is invitefriends fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}