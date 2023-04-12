package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        ArrayList<Word> words = new ArrayList<Word>(); //This is the dataStructure that stores the Miwok and English words
        words.add(new Word("әpә", "Father", R.drawable.family_father));
        words.add(new Word("әṭa", "Mother", R.drawable.family_mother));
        words.add(new Word("angsi", "Son", R.drawable.family_son));
        words.add(new Word("tune", "Daughter", R.drawable.family_daughter));
        words.add(new Word("taachi", "Elder Brother", R.drawable.family_older_brother));
        words.add(new Word("chalitti", "Younger Brother", R.drawable.family_younger_brother));
        words.add(new Word("teṭe", "Elder Sister", R.drawable.family_older_sister));
        words.add(new Word("kolliti", "Younger Sister", R.drawable.family_younger_sister));
        words.add(new Word("ama", "Grandfather", R.drawable.family_grandfather));
        words.add(new Word("paapa", "Grandmother", R.drawable.family_grandmother));

        RecyclerView view = findViewById(R.id.familyRecView); //Creating a recycler View

        MyAdapter itemsAdapter = new MyAdapter(); //Creating a recyclerView Adapter
        itemsAdapter.setWords(words); //Setting the arraylist to the adapter

        int color = ContextCompat.getColor(this, R.color.category_family); //converting the color from resource id to color value
        itemsAdapter.setBgColor(color); //setting the color for listItem in the recyclerView Adapter

        view.setAdapter(itemsAdapter); //Setting the adapter to recycler View
        view.setLayoutManager(new LinearLayoutManager(this));
    }
}