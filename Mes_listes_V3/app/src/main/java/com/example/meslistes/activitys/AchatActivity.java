package com.example.meslistes.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.meslistes.adapters.RecyclerVAchatAdapter;
import com.example.meslistes.Class.Produit;
import com.example.meslistes.R;

import java.util.ArrayList;

public class AchatActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Produit> produitArrayList;
    RecyclerVAchatAdapter recyclerVAchatAdapter;
    EditText nom, qte;
    ImageButton ajout;


    @SuppressLint({"MissingInflatedId", "NotifyDataSetChanged"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achat);

        ajout = findViewById(R.id.ajout);
        nom = findViewById(R.id.nom);
        qte = findViewById(R.id.qte);
        recyclerView = findViewById(R.id.recvAchat);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        produitArrayList = new ArrayList<>();
        recyclerVAchatAdapter = new RecyclerVAchatAdapter(this, produitArrayList);
        recyclerView.setAdapter(recyclerVAchatAdapter);


        ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = nom.getText().toString();
                String q = qte.getText().toString();
                if (q.isEmpty()){
                    produitArrayList.add(new Produit(n));
                }
                produitArrayList.add(new Produit(n, qte.getText().toString()));
                Toast.makeText(AchatActivity.this, nom.getText().toString() + " a bien été ajouté", Toast.LENGTH_SHORT).show();
                nom.setText("");
                qte.setText("1");
            }
        });
        recyclerVAchatAdapter.notifyDataSetChanged();






    }
















}