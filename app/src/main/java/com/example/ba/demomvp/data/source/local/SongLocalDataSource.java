package com.example.ba.demomvp.data.source.local;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.example.ba.demomvp.data.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongLocalDataSource implements SongDataSource {
    private static final String COLUMN_SONG_NAME = "title";
    private static final String COLUMN_SONG_ARTIST = "artist";
    private static final String COLUMN_SONG_PATH = "_data";
    private Context mContext;
    private List<Song> mListSong;

    private static SongLocalDataSource mInstance;

    public static SongLocalDataSource getInstance(Context context) {
        if (mInstance == null){
            mInstance = new SongLocalDataSource(context);
        }
        return mInstance;
    }

    public SongLocalDataSource(Context context) {
        mListSong = new ArrayList<>();
        this.mContext = context;
    }

    @Override
    public List<Song> loadData() {
        Cursor cursor = mContext.getContentResolver().query(MediaStore
                        .Audio.Media.EXTERNAL_CONTENT_URI,
                null, null, null, null);
        if (cursor == null) {
            return null;
        } else {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                int indexDisplayName = cursor.getColumnIndex(COLUMN_SONG_NAME);
                String displayName = cursor.getString(indexDisplayName);
                int indexArtist = cursor.getColumnIndex(COLUMN_SONG_ARTIST);
                String artist = cursor.getString(indexArtist);
                int indexPath = cursor.getColumnIndex(COLUMN_SONG_PATH);
                String path = cursor.getString(indexPath);
                Song song = new Song();
                song.setName(displayName);
                song.setArtist(artist);
                song.setPath(path);
                mListSong.add(song);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return mListSong;
    }
}
