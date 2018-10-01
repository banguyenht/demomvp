package com.example.ba.demomvp.home;

import com.example.ba.demomvp.BasePresenter;
import com.example.ba.demomvp.BaseView;
import com.example.ba.demomvp.data.model.Song;

import java.util.List;

public interface HomeContract {

    interface View extends BaseView<Present> {

    }

    interface Present extends BasePresenter<View> {
        void loadDataSongs();

        List<Song> getList();
    }
}
