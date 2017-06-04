package com.example.pawel.filharmonia.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.example.pawel.filharmonia.MainActivity;
import com.example.pawel.filharmonia.listeners.NavigationListener;


public class BaseFragment extends Fragment {
    protected NavigationListener navigationListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof MainActivity){
            navigationListener = (NavigationListener) context;
        }
    }
}
