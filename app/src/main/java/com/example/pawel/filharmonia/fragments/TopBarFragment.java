package com.example.pawel.filharmonia.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.pawel.filharmonia.R;
import com.example.pawel.filharmonia.listeners.TopBarListener;

public class TopBarFragment extends BaseFragment implements View.OnClickListener, TopBarListener {

    private ImageButton backButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_bar,container,false);

        backButton = (ImageButton) view.findViewById(R.id.back_button);
        backButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        navigationListener.onBack();
    }

    @Override
    public void showBackButton(boolean show) {
        backButton.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
