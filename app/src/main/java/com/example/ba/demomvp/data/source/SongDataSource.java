package com.example.ba.demomvp.data.source;

import com.example.ba.demomvp.data.model.Song;

import java.util.List;

public interface SongDataSource {
    List<Song> loadData();
}
