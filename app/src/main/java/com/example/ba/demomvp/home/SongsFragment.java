package com.example.ba.demomvp.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ba.demomvp.R;
import com.example.ba.demomvp.data.model.Song;
import com.example.ba.demomvp.home.adapter.SongAdapter;

import java.util.List;

public class SongsFragment extends Fragment implements HomeContract.View,
        SongAdapter.ISongAdapter {
    private HomeContract.Present mPresent;
    private RecyclerView mRecyclerView;
    private SongAdapter mAdapter;

    public static SongsFragment newInstance() {
        return new SongsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {
//        mPresent = new HomePresenter(getContext());
//        mPresent.setT(this);
        initComponents();
        View view = inflater.inflate(R.layout.songs_fragment, container, false);
//        mRecyclerView = view.findViewById(R.id.recyclerview_songs);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mAdapter = new SongAdapter(this);
//        mRecyclerView.setAdapter(mAdapter);
//        mPresent.onStart();
//        mPresent.loadDataSongs();
        initView(view);
        return view;
    }

    @Override
    public void onUpdateUi(List<Song> songList) {
        mAdapter.setListSong(songList);
        Toast.makeText(getContext(), "size: "+songList.size(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void setPresenter(HomeContract.Present presenter) {
        this.mPresent = presenter;
    }

    @Override
    public int getCount() {
        return mPresent.countSongs();
    }

    @Override
    public Song getItem(int positon) {
        return mPresent.getItemSong(positon);
    }
    private void initComponents(){
        mPresent = new HomePresenter(getContext());
        mPresent.setT(this);
        mPresent.onStart();
        mAdapter = new SongAdapter(this);
        mPresent.loadDataSongs();
    }
    private void initView(View view){
        mRecyclerView = view.findViewById(R.id.recyclerview_songs);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
    }
}

