package com.graffiti.mahesh.gridsentrylocation.home;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.graffiti.mahesh.gridsentrylocation.R;
import com.graffiti.mahesh.gridsentrylocation.permission.PermissionsActivity;
import com.graffiti.mahesh.gridsentrylocation.permission.PermissionsChecker;

public class HomeActivity extends AppCompatActivity {

    FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment homeFragment = new HomeFragment();
    Fragment sensorFragment = new SensorFragment();
    PermissionsChecker checker;
    private static final String[] PERMISSIONS_READ_STORAGE = new String[]{Manifest.permission.ACCESS_COARSE_LOCATION};
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Fragment homeFragment = new HomeFragment();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, homeFragment).commit();
                    fragmentTransaction.addToBackStack(null);
                    return true;
                case R.id.navigation_dashboard:
                    Fragment sensorFragment = new SensorFragment();
                    FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                    fragmentTransaction1.replace(R.id.fragment_container, sensorFragment).commit();
                    fragmentTransaction1.addToBackStack(null);
                    return true;
                case R.id.navigation_notifications:

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        checker = new PermissionsChecker(this);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            if (checker.lacksPermissions(PERMISSIONS_READ_STORAGE)) {
                startPermissionsActivity(PERMISSIONS_READ_STORAGE);
            }
            else
            {
                Fragment homeFragment = new HomeFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, homeFragment).commit();
            }
        }

        Fragment homeFragment = new HomeFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_container, homeFragment).commit();
    }
    private void startPermissionsActivity(String[] permission) {
        PermissionsActivity.startActivityForResult(this, 0, permission);
    }
}
