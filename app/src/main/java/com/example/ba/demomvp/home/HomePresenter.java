package com.example.ba.demomvp.home;

import android.content.Context;

import com.example.ba.demomvp.data.SongDataSource;
import com.example.ba.demomvp.data.model.Song;
import com.example.ba.demomvp.data.source.local.SongResponsity;


import java.util.List;

public class HomePresenter implements HomeContract.Present {
    private Context mContext;
    private SongResponsity mResponsity;
    private HomeContract.View mView;

    public void setView(HomeContract.View view) {
        this.mView = view;
    }

    public Context getContext() {
        return mContext;
    }

    public HomePresenter(Context context) {
        this.mContext = context;
        mResponsity = new SongResponsity();
        mResponsity.setContext(getContext());
    }

    @Override
    public void loadDataSongs() {
        sendData();
    }

    @Override
    public int countSongs() {
        return mResponsity.countSong();
    }

    @Override
    public Song getItemSong(int positon) {
        return mResponsity.getItemSong(positon);
    }

    private void sendData() {
        mResponsity.loadDataSong(new SongDataSource.LoadDataCallback() {
            @Override
            public void onLoadData(List<Song> songList) {
                mView.onUpdateUi(songList);
            }
        });
    }


    @Override
    public void setT(HomeContract.View view) {
        this.mView=view;
    }

    @Override
    public void onStart() {
        mResponsity.loadData();
    }
}
