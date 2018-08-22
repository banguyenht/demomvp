package com.example.ba.demomvp.home;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ba.demomvp.R;

public class SongsActivity extends AppCompatActivity {
    private SongsFragment mFragment;
    private HomeContract.Present mHomePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mHomePresenter = new HomePresenter(this);
        mFragment = SongsFragment.newInstance();
        mHomePresenter.onStart();
        mFragment.setPresenter(mHomePresenter);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.framelayout_container,mFragment);
        transaction.commit();

    }
}
