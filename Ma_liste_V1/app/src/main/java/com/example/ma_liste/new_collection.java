package com.example.ma_liste;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class new_collection extends AppCompatActivity {


    TextView ancienne_collection;
    EditText nouvelle_collection;
    Button maj;

    Intent nIntent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_collection);

        Intent nc = getIntent();

        //collection_actuelle = ;
        ancienne_collection = findViewById(R.id.co_actuelle);
        nouvelle_collection = findViewById(R.id.nouvelle_collection);
        maj = findViewById(R.id.maj);

        ancienne_collection.setText(nc.getStringExtra("collection"));

        maj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nIntent.putExtra("new_co", nouvelle_collection.getText().toString());
                setResult(Activity.RESULT_OK, nIntent);
                finish();
            }
        });


    }

}
