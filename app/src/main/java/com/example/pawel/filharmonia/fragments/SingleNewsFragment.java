package com.example.pawel.filharmonia.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pawel.filharmonia.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class SingleNewsFragment extends BaseFragment implements View.OnClickListener{
    private ImageView photo;
    private TextView txt_title;
    private WebView webViewNewsContent;

    public static SingleNewsFragment  newInstance (Bundle bundle) {
        SingleNewsFragment fragment = new SingleNewsFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_single_news,container,false);
        getActivity().setTitle(getString(R.string.news));
        ImageButton zoom_button = (ImageButton) view.findViewById(R.id.bt_zoom_news);
        zoom_button.setOnClickListener(this);

        txt_title = (TextView) view.findViewById(R.id.txt_view_title_news_details);
        webViewNewsContent = (WebView) view.findViewById(R.id.webViewNewsContent);
        photo = (ImageView) view.findViewById(R.id.img_view_news);

        setData();

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_zoom_news:
                showImageFullView();
                break;
        }
    }

    public void showImageFullView(){
        Bundle bundle= new Bundle();
        bundle.putString("Image",getArguments().getString("Image"));
        navigationListener.onNavigate(FullImageFragment.newInstance(bundle));
    }
    public void setData(){
        Bundle bundle = this.getArguments();
        Glide.with(getContext()).load(getArguments().getString("Image")).into(photo);
        txt_title.setText(bundle.getString("Title"));
        webViewNewsContent.loadData(bundle.getString("Full_Content"), "text/html; charset=utf-8", "utf-8");
    }

}
