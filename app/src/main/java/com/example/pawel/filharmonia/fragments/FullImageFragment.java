package com.example.pawel.filharmonia.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.pawel.filharmonia.R;

public class FullImageFragment extends BaseFragment{
    private ImageView photo;

    public static FullImageFragment  newInstance (Bundle bundle) {
        FullImageFragment fragment = new FullImageFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_full_size,container,false);
        photo  = (ImageView) view.findViewById(R.id.img_full_view);
        showImage();
        return view;
    }

    private void showImage(){
        Bundle bundle = this.getArguments();
        String url = bundle.getString("Image");
        int url_test = bundle.getInt("Image_test");

        if (url==null){
            Glide.with(getContext()).load(url_test).into(photo);
        } else {
            Glide.with(getContext()).load(url).into(photo);
        }
    }
}
