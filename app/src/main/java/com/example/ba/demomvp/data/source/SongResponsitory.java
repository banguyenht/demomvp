package com.example.ba.demomvp.data.source;

import android.content.Context;

import com.example.ba.demomvp.data.SongDataSource;
import com.example.ba.demomvp.data.model.Song;
import com.example.ba.demomvp.data.source.local.SongLocalDataSource;

import java.util.List;


public class SongResponsitory implements SongDataSource {
    private SongDataSource mSongDataSource;

    public SongResponsitory(Context context) {
        mSongDataSource = new SongLocalDataSource(context);
    }


    @Override
    public void loadData() {
        mSongDataSource.loadData();
    }

    @Override
    public List<Song> getListSong() {
        return mSongDataSource.getListSong();
    }

    @Override
    public void loadDataSong(LoadDataCallback callback) {
        callback.onLoadData(getListSong());
    }

    @Override
    public int countSong() {
        return mSongDataSource.countSong();
    }

    @Override
    public Song getItemSong(int position) {
        return mSongDataSource.getItemSong(position);
    }
}


