package com.example.ba.demomvp.data.source;

import com.example.ba.demomvp.data.model.Song;
import com.example.ba.demomvp.data.source.local.SongLocalDataSource;

import java.util.List;

public class SongResponsitory  implements SongDataSource{
    private SongLocalDataSource mSongLocalDataSource;
    private static SongResponsitory mInstance;

    public static SongResponsitory getInstance(SongLocalDataSource songLocalDataSource) {
        if (mInstance == null) {
            mInstance = new SongResponsitory(songLocalDataSource);
        }
        return mInstance;
    }

    public SongResponsitory(SongLocalDataSource songLocalDataSource) {
        this.mSongLocalDataSource = songLocalDataSource;
    }

    @Override
    public List<Song> loadData() {
        return mSongLocalDataSource.loadData();
    }
}
