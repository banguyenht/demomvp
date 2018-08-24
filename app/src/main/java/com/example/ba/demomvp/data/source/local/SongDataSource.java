package com.example.ba.demomvp.data.source.local;

import com.example.ba.demomvp.data.model.Song;

import java.util.List;

public interface SongDataSource {
    interface LoadDataCallback {
        void onLoadData(List<Song> songList);
    }

    List<Song> loadData();
}
