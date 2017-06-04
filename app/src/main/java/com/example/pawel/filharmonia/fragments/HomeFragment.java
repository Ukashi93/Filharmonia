package com.example.pawel.filharmonia.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pawel.filharmonia.R;

public class HomeFragment extends BaseFragment implements View.OnClickListener {
    Button buttonNewses,
        buttonRepertoires,
        buttonContests,
        buttonGallery,
        buttonContact;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        buttonNewses = (Button) view.findViewById(R.id.buttonNewses);
        buttonRepertoires = (Button) view.findViewById(R.id.buttonRepertoires);
        buttonContests = (Button) view.findViewById(R.id.buttonContest);
        buttonGallery = (Button) view.findViewById(R.id.buttonGallery);
        buttonContact = (Button) view.findViewById(R.id.buttonContact);

        buttonNewses.setOnClickListener(this);
        buttonGallery.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonNewses:
                navigationListener.onNavigate(new NewsesFragment());
                break;
            case R.id.buttonGallery:
                navigationListener.onNavigate(new GalleryFragment());
                break;
        }
    }
}
