package com.example.ma_liste.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ma_liste.R;
import com.example.ma_liste.Scan;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Scans extends Fragment {


    private EditText entree;
    private EditText lien;
    private EditText chapitre;

    private ArrayList<Scan> list;
    private Scan s;

    public Scans() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scans, container, false);

        //On instancie la liste
        ArrayList<String> listeDesScans = new ArrayList<String>();

        //< avoir les éléments >
        entree = view.findViewById(R.id.entree);
        lien = view.findViewById(R.id.lien_to_scans);
        chapitre = view.findViewById(R.id.chapitre);
        RecyclerView liste = view.findViewById(R.id.list_scans);
        Button ajout = view.findViewById(R.id.ajout);
        //</ avoir les éléments >

        //On instancie la liste
        list = new ArrayList<Scan>();

        //On instancie l'adapter et on l'ajoute à la liste view
        ArrayAdapter<String> custom = new ArrayAdapter<String>(getContext().getApplicationContext(), android.R.layout.simple_expandable_list_item_1, listeDesScans);
        //liste.setAdapter(custom);

        ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = entree.getText().toString();
                URL l = null;
                try {
                    l = new URL(lien.getText().toString());
                } catch (MalformedURLException malformedURLException) {
                    malformedURLException.printStackTrace();
                }
                String c = chapitre.getText().toString();

                //On vérifie que la saisie de titre n'est pas vide
                if(!e.isEmpty()) {
                    s = new Scan(e,l,c);
                }
                if (l == null){
                    s = new Scan(e,null,c);
                }
                if (c.isEmpty()){
                    s = new Scan(e,l,"pas encore commencé");
                }

                list.add(s);

                Toast.makeText(getContext().getApplicationContext(), "Le scan a bien été ajouté à la liste", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }
}