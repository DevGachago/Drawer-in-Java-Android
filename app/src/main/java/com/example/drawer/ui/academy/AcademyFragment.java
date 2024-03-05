package com.example.drawer.ui.academy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.drawer.databinding.FragmentWithdrawBinding;


public class AcademyFragment extends Fragment {

    private FragmentWithdrawBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AcademyViewModel academyViewModel =
                new ViewModelProvider(this).get(AcademyViewModel.class);

        binding = FragmentWithdrawBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textWithdraw;
        academyViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}