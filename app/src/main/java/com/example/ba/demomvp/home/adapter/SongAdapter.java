package com.example.ba.demomvp.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ba.demomvp.R;
import com.example.ba.demomvp.data.model.Song;
import com.example.ba.demomvp.home.ItemClickListener;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    private List<Song> mListSong;
    private Context mContext;
    private ItemClickListener mItemClickListener;

    public SongAdapter(List<Song> mListSong, Context mContext) {
        this.mListSong = mListSong;
        this.mContext = mContext;
    }

    public void setItemClickListener(ItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        return new SongViewHolder(inflater.inflate(R.layout.item_song, viewGroup,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder songViewHolder,
                                 final int i) {
        Song song = mListSong.get(i);
        songViewHolder.mTextviewSong.setText(song.getName());
    }


    @Override
    public int getItemCount() {
        return mListSong == null ? 0 : mListSong.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {
        private TextView mTextviewSong;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextviewSong = itemView.findViewById(R.id.textview_songname);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mItemClickListener.onClickItem(mTextviewSong.getText().toString());
        }
    }
}
