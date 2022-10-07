package com.example.ma_liste.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ma_liste.R;

import java.util.ArrayList;

public class Animes extends Fragment {

    private EditText entree;
    private Button ajout;
    private ListView liste;
    private ArrayList<String> listeDesAnimes;

    public Animes() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_animes, container, false);

        //On instancie la liste
        listeDesAnimes = new ArrayList<String>();

        //< avoir les éléments >
        entree = view.findViewById(R.id.entree);
        liste = view.findViewById(R.id.list_animes);
        ajout = view.findViewById(R.id.ajout);
        //</ avoir les éléments >

        //On instancie l'adapter
        ArrayAdapter<String> adapterLaListe = new ArrayAdapter<String>(getContext().getApplicationContext(), android.R.layout.simple_expandable_list_item_1, listeDesAnimes);

        //On l'ajoute à la listview
        liste.setAdapter(adapterLaListe);

        ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String saisie = entree.getText().toString();
                //On vérifie que la saisie n'est pas vide
                if(!saisie.isEmpty()) {
                    //On appel la méthode add de l'adapter
                    adapterLaListe.add(entree.getText().toString());

                    Toast.makeText(getContext().getApplicationContext(), "L'animé a bien été ajouté à la liste", Toast.LENGTH_SHORT).show();

                }
                Toast.makeText(getContext().getApplicationContext(), "Veuillez saisir quelque chose", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }
}