package com.example.ma_liste.fragments;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.ma_liste.adapters.CustomListAdapter;
//import com.example.ma_liste.JSONParser;
import com.example.ma_liste.Class.Produit;
import com.example.ma_liste.R;

import java.util.ArrayList;
import java.util.List;

public class Achats extends Fragment {

    private EditText entree;
    private EditText qte;
    private Button ajout;
    private ListView liste;
    private Produit p;
    private List<Produit> list;

    //Partie base de donnée
    ProgressDialog dialog;
    //JSONParser parser = new JSONParser();
    int success;

    //Fin partie base de donnée

//    static final ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();

    public Achats() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_achats, container, false);

        //< avoir les éléments >
        entree = view.findViewById(R.id.entree);
        qte = view.findViewById(R.id.qte);
        liste = view.findViewById(R.id.list_achat);
        ajout = view.findViewById(R.id.ajout);
        //</ avoir les éléments >

        //On instancie la liste
        list = new ArrayList<Produit>();

        CustomListAdapter custom = new CustomListAdapter(getContext(),list);
        //On l'ajoute à la listview
        liste.setAdapter(custom);

        //Si on clique sur le boutton pour finaliser l'enregistrement de l'élément
        ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String saisie = entree.getText().toString();
                //On vérifie que la saisie n'est pas vide
                if (!saisie.isEmpty()) {
                    String q = qte.getText().toString();

                    //le cas où la valeur quantité est nul (a gerer)
                    if (q == ""){
                        p = new Produit(entree.getText().toString());
                    } else {
                        int quantite = Integer.parseInt(q);
                        p = new Produit(entree.getText().toString(), quantite);
                    }

                    list.add(p);

                    Toast.makeText(getContext().getApplicationContext(), "L'achat a bien été ajouté à la liste", Toast.LENGTH_SHORT).show();

                }
//                Toast.makeText(getContext().getApplicationContext(), "Veuillez saisir quelque chose", Toast.LENGTH_SHORT).show();

                /*//Petit test base de donnée
                new Add().execute();*/


            }
        });

        AlertDialog.Builder adb = new AlertDialog.Builder(getContext());

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Object produit = liste.getItemAtPosition(position);
                adb.setTitle("Supprimer");
                adb.setMessage("Vous etes sur de vouloir supprimer ce produit: " + produit + " de la liste ?");
                final int positionToRemove = position;
                adb.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                                Toast.makeText(getContext().getApplicationContext(),"Vous avez refusé de supprimer ce produit",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                adb.setPositiveButton("Oui", new AlertDialog.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                list.remove(positionToRemove);
                                custom.notifyDataSetChanged();
                                Toast.makeText(getContext().getApplicationContext(),"Vous avez supprimé ce produit: " + produit + " de la liste.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                adb.show();
            }
        });

        return view;
    }

    /*class Add extends AsyncTask<String,String,String>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(getContext());
            dialog.setMessage("Patientez SVP");
            dialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {

            HashMap<String,String> map = new HashMap<String,String>();
            map.put("nom", entree.getText().toString());
            map.put("qte", qte.getText().toString());

            //Problem ici!!!!!!
            JSONObject object = parser.makeHttpRequest("http://10.0.2.2/Bases_de_donnees/Ma_liste/produit/add.php", "GET", map);

            try {
                success = object.getInt("success");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);
            dialog.cancel();

            if (success == 1){
                Toast.makeText(getContext().getApplicationContext(), "L'achat a bien été ajouté à la liste", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getContext().getApplicationContext(), "Echec", Toast.LENGTH_SHORT).show();
            }

        }



    }*/



}



