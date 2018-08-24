package com.example.ba.demomvp.home;

import android.content.Context;

import com.example.ba.demomvp.data.model.Song;
import com.example.ba.demomvp.data.source.SongResponsitory;
import com.example.ba.demomvp.data.source.local.SongLocalDataSource;

import java.util.ArrayList;
import java.util.List;

public class HomePresenter implements HomeContract.Present {
    private Context mContext;
    private SongResponsitory mResponsity;
    private List<Song> mList;
    private HomeContract.View mView;

    public HomePresenter(Context context) {
        this.mContext = context;
        mResponsity =
                SongResponsitory.getInstance(SongLocalDataSource.getInstance(context));
    }

    @Override
    public void loadDataSongs() {
        mList = mResponsity.loadData();
    }

    @Override
    public List<Song> getList() {
        return mList;
    }

    @Override
    public void setView(HomeContract.View view) {
        this.mView = view;
    }

    @Override
    public void onStart() {
        mList = new ArrayList<>();
    }
}
