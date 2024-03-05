package com.example.drawer.ui.watchlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.drawer.databinding.FragmentWatchlistBinding;


public class WatchlistFragment extends Fragment {

    private FragmentWatchlistBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        WatchlistViewModel watchlistViewModel =
                new ViewModelProvider(this).get(WatchlistViewModel.class);

        binding = FragmentWatchlistBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textWatchlist;
        watchlistViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}