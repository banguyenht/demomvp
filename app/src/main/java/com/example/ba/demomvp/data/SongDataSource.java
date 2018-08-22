package com.example.ba.demomvp.data;

import com.example.ba.demomvp.data.model.Song;

import java.util.List;

public interface SongDataSource {
    interface LoadDataCallback {
        void onLoadData(List<Song> songList);
    }

    void loadDataSong(LoadDataCallback callback);

    int countSong();

    Song getItemSong(int position);
}
