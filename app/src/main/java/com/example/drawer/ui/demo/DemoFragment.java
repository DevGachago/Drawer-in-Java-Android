package com.example.drawer.ui.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.drawer.databinding.FragmentDemoBinding;


public class DemoFragment extends Fragment {

    private FragmentDemoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DemoViewModel demoViewModel =
                new ViewModelProvider(this).get(DemoViewModel.class);

        binding = FragmentDemoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDemo;
        demoViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}