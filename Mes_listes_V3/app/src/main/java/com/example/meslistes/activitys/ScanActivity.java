package com.example.meslistes.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meslistes.Autre.ScanCompare;
import com.example.meslistes.Class.Manga;
import com.example.meslistes.Class.Scan;
import com.example.meslistes.R;
import com.example.meslistes.adapters.RecyclerVScanAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;

public class ScanActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Scan> scansArrayList;
    View formulaire;
    EditText scan_titre, site_internet,site_chapitre,chapitre;
    Switch statut;
    ImageButton newScan;
    Button ajoutScan;
    SearchView searchView;
    RecyclerVScanAdapter recyclerVScanAdapter;
    FloatingActionButton fab;

    boolean cacher = true;
    Scan scan;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);


        formulaire = findViewById(R.id.ajoutScanform);
        formulaire.setVisibility(View.GONE);
        recyclerView = findViewById(R.id.recvScan);
        scan_titre = findViewById(R.id.scan_titre);
        site_internet = findViewById(R.id.site);
        site_chapitre = findViewById(R.id.site_chapitre);
        chapitre = findViewById(R.id.chapitre);
        statut = findViewById(R.id.statut);
        newScan = findViewById(R.id.ajout);
        ajoutScan = findViewById(R.id.ajoutscan);
        searchView = findViewById(R.id.scan_seach);
        fab = findViewById(R.id.fab);

        scansArrayList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerVScanAdapter = new RecyclerVScanAdapter(getApplicationContext(),scansArrayList);
        recyclerView.setAdapter(recyclerVScanAdapter);


        /*Cliquer sur le petit plus pour faire apparaitre le formulaire pour ajouter un nv scan*/
        newScan.setOnClickListener(v -> {
            onSlideFormulaire(formulaire);
        });

        ajoutScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t = scan_titre.getText().toString();
                String c = chapitre.getText().toString();
                String site = site_internet.getText().toString();
                String site_chap = site_chapitre.getText().toString();
                String s;

                boolean checked = statut.isChecked();
                if (checked){
                    s = "Fini";
                }else{s = "En cours";}

                if (!t.isEmpty()){
                    scan = new Scan(t,c,site,site_chap);
                }else {scan = new Scan("",c,site,site_chap);}

                if (!site.isEmpty()){
                    scan = new Scan(t,c,site,site_chap);
                }else {scan = new Scan(t,c,"",site_chap);}

                if (!site_chap.isEmpty()){
                    scan = new Scan(t,c,site,"");
                }else {scan = new Scan(t,c,site,site_chap);}

                scansArrayList.add(scan);
                slideUp(formulaire);
                scan_titre.setText("");
                site_internet.setText("");
                site_chapitre.setText("");
                chapitre.setText("1");
                Toast.makeText(ScanActivity.this, "Le scan a bien été ajouté à la liste", Toast.LENGTH_SHORT).show();

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scansArrayList.sort(new ScanCompare());
            }
        });


        /*Gerer la barre de recherche*/
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });




    }

    private void searchList(String text) {
        ArrayList<Scan> scansSearchList = new ArrayList<>();
        for (Scan scan : scansArrayList){
            if (scan.getTitre().toLowerCase().contains(text.toLowerCase())){
                scansSearchList.add(scan);
            }
        }
        if (scansSearchList.isEmpty()){
            Toast.makeText(this, "Pas trouvé", Toast.LENGTH_SHORT).show();
        } else {
            recyclerVScanAdapter.setSearchList(scansSearchList);
        }

    }

    /*fonction pour gerer l'apparition du formulaire*/

    public void onSlideFormulaire(View view) {
        if (cacher) {
            slideDown(formulaire);
        } else {
            slideUp(formulaire);
        }
        cacher = !cacher;
    }


    // decendre le formulaire
    public void slideDown(View view){
        view.setVisibility(View.VISIBLE);
        view.setAlpha(0.0f);
        // Start the animation
        view.animate()
                .translationY(20)
                .alpha(1.0f)
                .setListener(null);

    }


    // remonter le formulaire
    private void slideUp(View view) {
        view.animate()
                .translationY(0)
                .alpha(0.0f)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        view.setVisibility(View.GONE);
                    }
                });
    }
}