package com.example.pawel.filharmonia;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pawel.filharmonia.fragments.HomeFragment;
import com.example.pawel.filharmonia.listeners.NavigationListener;
import com.example.pawel.filharmonia.listeners.TopBarListener;

public class MainActivity extends AppCompatActivity implements NavigationListener, FragmentManager.OnBackStackChangedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onBackStackChanged();
        navigateTo(new HomeFragment(),false);
    }

    private void navigateTo(Fragment fragment,boolean backStack){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.addOnBackStackChangedListener(this);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content,fragment);

        if(backStack){
            fragmentTransaction.addToBackStack(fragment.toString());
        }

        fragmentTransaction.commit();
    }

    @Override
    public void onBack() {
        super.onBackPressed();
    }

    @Override
    public void onNavigate(Fragment fragment) {
        navigateTo(fragment,true);
    }

    @Override
    public void onBackStackChanged() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        TopBarListener topBarListener = (TopBarListener) fragmentManager.findFragmentById(R.id.top_bar);

        if(fragmentManager.getBackStackEntryCount() > 0){
            topBarListener.showBackButton(true);
        }else{
            topBarListener.showBackButton(false);
        }

    }
}
