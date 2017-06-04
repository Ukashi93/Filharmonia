package com.example.pawel.filharmonia.listeners;


import android.support.v4.app.Fragment;

public interface NavigationListener {
    public void onBack();
    public void onNavigate(Fragment fragment);
}
