package com.example.drawer.ui.flexclub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.drawer.databinding.FragmentFlexBinding;

public class FlexFragment extends Fragment {

    private FragmentFlexBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FlexViewModel flexViewModel =
                new ViewModelProvider(this).get(FlexViewModel.class);

        binding = FragmentFlexBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textFlex;
        flexViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}