package com.example.miwokapp;

import android.media.Image;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    ArrayList<Word> words = new ArrayList<Word>();
    private int mBgColor;

    private MediaPlayer mediaPlayer;

    public MyAdapter() {}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Word currentWord = words.get(position);

        holder.miwokTranslation.setText(currentWord.getMiwokTranslation());
        holder.defaultTranslation.setText(currentWord.getDefaultTranslation());
        if(currentWord.hasImage()){
            holder.imageView.setImageResource(words.get(position).getImageId());
            holder.imageView.setVisibility(View.VISIBLE);
        }else {
            holder.imageView.setVisibility(View.GONE);
        }

        holder.containerLayout.setBackgroundColor(mBgColor);

        holder.playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentWord.hasAudio()){
                    mediaPlayer = MediaPlayer.create(view.getContext(), currentWord.getAudioId());
                    mediaPlayer.start();
                }else {
                    Toast.makeText(view.getContext(), R.string.audio_unavailable, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void releaseMediaPlayer(){
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    public void setWords(ArrayList<Word> words){
        this.words = words;
    }

    public void setBgColor(int bgColor){
        mBgColor = bgColor;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView miwokTranslation;
        private TextView defaultTranslation;
        private ImageView imageView;
        private LinearLayout containerLayout;

        private ImageView playButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            miwokTranslation = itemView.findViewById(R.id.miwok_text_view);
            defaultTranslation = itemView.findViewById(R.id.default_text_view);
            imageView = itemView.findViewById(R.id.image_view);
            containerLayout = itemView.findViewById(R.id.linear_layout);
            playButton = itemView.findViewById(R.id.play_btn);
        }
    }
}
