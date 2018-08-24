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

import java.util.ArrayList;
import java.util.List;

public class SongsFragment extends Fragment implements HomeContract.View,
        ItemClickListener {

    private HomeContract.Present mPresent;
    private RecyclerView mRecyclerView;
    private List<Song> mList;
    private SongAdapter mAdapter;
    private static SongsFragment mSongsFragment;

    public static SongsFragment newInstance() {
        if(mSongsFragment==null){
            mSongsFragment= new SongsFragment();
        }
        return mSongsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {
        initComponents();
        View view = inflater.inflate(R.layout.songs_fragment, container,
                false);
        initView(view);
        return view;
    }

    @Override
    public void setPresenter(HomeContract.Present presenter) {
        this.mPresent = presenter;
    }

    private void initComponents() {
        mPresent.onStart();
        mPresent = new HomePresenter(getContext());
        mPresent.setView(this);
        mList = new ArrayList<>();
        mPresent.loadDataSongs();
        mList = mPresent.getList();
        mAdapter = new SongAdapter(mList,getContext());
        mAdapter.setItemClickListener(this);
    }

    private void initView(View view) {
        mRecyclerView = view.findViewById(R.id.recyclerview_songs);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClickItem(String values) {
        Toast.makeText(getContext(), values , Toast.LENGTH_SHORT).show();
    }
}
