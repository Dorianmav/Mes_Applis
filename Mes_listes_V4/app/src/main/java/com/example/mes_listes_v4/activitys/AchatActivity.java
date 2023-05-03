package com.example.mes_listes_v4.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mes_listes_v4.Adapters.RecyclerVAchatAdapter;
import com.example.mes_listes_v4.Library.ListeDeCourses;
import com.example.mes_listes_v4.R;

public class AchatActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ListeDeCourses listeDeCourses;
    //ArrayList<ItemCourse> produitArrayList;
    RecyclerVAchatAdapter recyclerVAchatAdapter;
    EditText nom, magasin ,qte;
    ImageButton ajout;


    @SuppressLint({"MissingInflatedId", "NotifyDataSetChanged"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achat);

        ajout = findViewById(R.id.ajout);
        nom = findViewById(R.id.nom);
        magasin = findViewById(R.id.magasin);
        qte = findViewById(R.id.qte);
        recyclerView = findViewById(R.id.recvAchat);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //produitArrayList = new ArrayList<>();
        listeDeCourses = new ListeDeCourses("aujourd'hui");

        recyclerVAchatAdapter = new RecyclerVAchatAdapter(this, listeDeCourses.getItems());
        recyclerView.setAdapter(recyclerVAchatAdapter);


        ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = nom.getText().toString();
                String m = magasin.getText().toString();
                int q = Integer.parseInt(qte.getText().toString());
                listeDeCourses.ajouterItem(n,q,m);
                Toast.makeText(AchatActivity.this, nom.getText().toString() + " a bien été ajouté", Toast.LENGTH_SHORT).show();
                nom.setText("");
                magasin.setText("");
                qte.setText("1");
            }
        });
        recyclerVAchatAdapter.notifyDataSetChanged();






    }


}