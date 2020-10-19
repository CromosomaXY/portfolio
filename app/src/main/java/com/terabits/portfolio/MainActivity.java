package com.terabits.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.terabits.portfolio.cv.CVFragment;
import com.terabits.portfolio.home.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        setCVFragment();

        //setHomeFragment();
    }
    void setCVFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new CVFragment()).commit();
    }


    void setHomeFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
    }
}