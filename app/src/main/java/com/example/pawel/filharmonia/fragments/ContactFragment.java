package com.example.pawel.filharmonia.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pawel.filharmonia.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ContactFragment extends BaseFragment implements View.OnClickListener{
    private MapView mapView;
    private TextView txt_call_1;
    private TextView txt_call_2;
    private TextView txt_call_3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact,container,false);

        ImageButton bt_zoom = (ImageButton) view.findViewById(R.id.bt_zoom_map);
        bt_zoom.setOnClickListener(this);

        txt_call_1 = (TextView) view.findViewById(R.id.txt_call_1);
        txt_call_1.setOnClickListener(this);

        txt_call_2 = (TextView) view.findViewById(R.id.txt_call_2);
        txt_call_2.setOnClickListener(this);

        txt_call_3 = (TextView) view.findViewById(R.id.txt_call_3);
        txt_call_3.setOnClickListener(this);

        mapView = (MapView) view.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        showMap();

        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_zoom_map:
                navigationListener.onNavigate(new MapFragment());
                break;
            case R.id.txt_call_1:
                callToNumber(txt_call_1.getText().toString());
                break;
            case R.id.txt_call_2:
                callToNumber(txt_call_2.getText().toString());
                break;
            case R.id.txt_call_3:
                callToNumber(txt_call_3.getText().toString());
                break;
        }
    }

    public void showMap(){
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(51.771871, 19.448339), 18.0f));
                MarkerOptions marker = new MarkerOptions().position(new LatLng(51.771871, 19.448339));
                googleMap.addMarker(marker);

            }
        });
    }

    public void callToNumber(String number){
        Intent call = new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:" + number));
        startActivity(call);
    }
}
