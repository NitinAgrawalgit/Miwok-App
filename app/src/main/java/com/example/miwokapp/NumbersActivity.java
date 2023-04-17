package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MyAdapter itemsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        RecyclerView recyclerView = findViewById(R.id.numbersRecView);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Lutti", "One", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("Otiiko", "Two", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("Tolookosu", "Three", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("Oyyisa", "Four", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("Massokka", "Five", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("Temmokka", "Six", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("Kenekaku", "Seven", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("Kawinta", "Eight", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("Wo’e", "Nine", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("Na’aacha", "Ten", R.drawable.number_ten, R.raw.number_ten));

        itemsAdapter = new MyAdapter();
        itemsAdapter.setWords(words);

        int color = ContextCompat.getColor(this, R.color.category_numbers);
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