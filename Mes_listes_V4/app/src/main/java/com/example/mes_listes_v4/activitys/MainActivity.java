package com.example.mes_listes_v4.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mes_listes_v4.R;


public class MainActivity extends AppCompatActivity {

    CardView achatsCard, animesCard, jeuxCard, mangasCard, precoCard, scansCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        achatsCard = findViewById(R.id.achatCard);
        animesCard = findViewById(R.id.animeCard);
        jeuxCard = findViewById(R.id.jeuxCard);
        mangasCard = findViewById(R.id.mangaCard);
        precoCard = findViewById(R.id.precommandeCard);
        scansCard = findViewById(R.id.scanCard);

        achatsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AchatActivity.class);
                startActivity(intent);
            }
        });

        animesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnimeActivity.class);
                startActivity(intent);
            }
        });

        jeuxCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                //Intent intent = new Intent(MainActivity.this, test.class);
                startActivity(intent);
            }
        });

        mangasCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MangaActivity.class);
                startActivity(intent);
            }
        });

        precoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PrecoActivity.class);
                startActivity(intent);
            }
        });

        scansCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScanActivity.class);
                startActivity(intent);
            }
        });







    }
}