package com.example.ma_liste;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class test extends AppCompatActivity {

    Bitmap im;
    ImageView image;
    Button button;

    Intent nc ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        image = findViewById(R.id.i);
        nc = getIntent();
        Uri lien = nc.getData();
        Bitmap  mBitmap = null;
        try {
            mBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), lien);
        } catch (IOException e) {
            e.printStackTrace();
        }
        image.setImageBitmap(mBitmap);

    }

}