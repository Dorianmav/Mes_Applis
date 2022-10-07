package com.example.ma_liste;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class new_resume extends AppCompatActivity {


    TextView ancien_resume;
    EditText nouveau_resume;
    Button maj;

    Intent nIntent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_resume);

        Intent nc = getIntent();

        //collection_actuelle = ;
        ancien_resume = findViewById(R.id.resume_actuel);
        nouveau_resume = findViewById(R.id.nouveau_resume);
        maj = findViewById(R.id.maj);

        ancien_resume.setText(nc.getStringExtra("resume"));

        maj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nIntent.putExtra("new_res", nouveau_resume.getText().toString());
                setResult(Activity.RESULT_OK, nIntent);
                finish();
            }
        });


    }

/*
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        saveP=password;
        saveU=user;
    };*/
}
