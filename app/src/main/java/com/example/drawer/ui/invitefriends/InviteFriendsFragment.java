package com.example.drawer.ui.invitefriends;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.drawer.databinding.FragmentInvitefriendsBinding;


public class InviteFriendsFragment extends Fragment {

    private FragmentInvitefriendsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        InviteFriendsViewModel inviteFriendsViewModel =
                new ViewModelProvider(this).get(InviteFriendsViewModel.class);

        binding = FragmentInvitefriendsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textInvite;
        inviteFriendsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}