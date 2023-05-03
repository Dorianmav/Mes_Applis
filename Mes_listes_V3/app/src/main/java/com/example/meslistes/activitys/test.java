package com.example.meslistes.activitys;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.meslistes.R;

public class test extends AppCompatActivity {
    TextView t;
    NumberPicker n;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        t = findViewById(R.id.pid_input);
        n = findViewById(R.id.pid_inputPicker);

        n.setMinValue(0);
        n.setMaxValue(10);
        n.setVisibility(View.GONE);
        t.setVisibility(View.VISIBLE);

        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n.setVisibility(View.VISIBLE);
            }
        });
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.setText(String.valueOf(n.getValue()));
                n.setVisibility(View.GONE);
            }
        });
    }

}
