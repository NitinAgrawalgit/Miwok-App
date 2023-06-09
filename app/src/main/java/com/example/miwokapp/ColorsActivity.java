package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MyAdapter itemsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("weṭeṭṭi", "Red", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("chokokki", "Green", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("ṭakaakki", "Brown", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("ṭopoppi", "Gray", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("kululli", "Black", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("kelelli", "White", R.drawable.color_white, R.raw.color_white));
        words.add(new Word("ṭopiisә", "Dusty Yellow", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("chiwiiṭә", "Mustard Yellow", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        RecyclerView recyclerView = findViewById(R.id.colorsRecView);

        //MyAdapter is a custom recyclerView Adapter that I defined in MyAdapter.java
        itemsAdapter = new MyAdapter();
        itemsAdapter.setWords(words);

        int color = ContextCompat.getColor(this, R.color.category_colors);
        itemsAdapter.setBgColor(color);

        recyclerView.setAdapter(itemsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStop() {
        super.onStop();

        itemsAdapter.releaseMediaPlayer();
    }
}