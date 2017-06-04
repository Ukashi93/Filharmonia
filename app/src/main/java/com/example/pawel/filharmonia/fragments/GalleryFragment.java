package com.example.pawel.filharmonia.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.pawel.filharmonia.R;
import com.example.pawel.filharmonia.adapters.GalleryAdapter;
import com.example.pawel.filharmonia.model.Gallery;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery,container,false);

        GridView gridview = (GridView) view.findViewById(R.id.grid_view);
        gridview.setAdapter(new GalleryAdapter(getTestData()));
        gridview.setOnItemClickListener(this) ;

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Bundle bundle= new Bundle();
        Gallery galleryClass = (Gallery) parent.getItemAtPosition(position) ;
        bundle.putInt("Image_test",galleryClass.getImage_link());

        navigationListener.onNavigate(FullImageFragment.newInstance(bundle));

    }

    private List<Gallery> getTestData(){
        List<Gallery> list = new ArrayList<>();
        Gallery gallery = new Gallery();
        gallery.setImageTitle("Zdjęcie 1");
        gallery.setImage_link(R.drawable.pic1);
        Gallery gallery1 = new Gallery();
        gallery1.setImageTitle("Zdjecie 2");
        gallery1.setImage_link(R.drawable.pic2);
        Gallery gallery2 = new Gallery();
        gallery2.setImageTitle("Zdjecie 3");
        gallery2.setImage_link(R.drawable.pic3);
        Gallery gallery3 = new Gallery();
        gallery3.setImageTitle("Zdjecie 4");
        gallery3.setImage_link(R.drawable.pic4);
        Gallery gallery4 = new Gallery();
        gallery4.setImageTitle("Zdjecie 5");
        gallery4.setImage_link(R.drawable.pic4);
        Gallery gallery5 = new Gallery();
        gallery5.setImageTitle("Zdjecie 6");
        gallery5.setImage_link(R.drawable.pic4);
        list.add(gallery);
        list.add(gallery1);
        list.add(gallery2);
        list.add(gallery3);
        list.add(gallery4);
        list.add(gallery5);

        return list;
    }
}
