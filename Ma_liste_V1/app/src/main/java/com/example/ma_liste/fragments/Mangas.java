package com.example.ma_liste.fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.ma_liste.adapters.CustomListMangaAdapter;
import com.example.ma_liste.Class.Manga;
import com.example.ma_liste.R;
import com.example.ma_liste.new_collection;
import com.example.ma_liste.new_resume;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Mangas extends Fragment {

    private EditText titre;
    private EditText resume;
    private EditText collection;
    private ImageView image;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch statut;
    private Manga manga;


    private String s;
    String c;
    String r;
    Bitmap im;


    private Manga m;
    private ListView liste;
    private List<Manga> list;

    public Mangas() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mangas, container, false);
        View view2 = inflater.inflate(R.layout.list_item_manga_layout, container, false);

        //avoir les éléments
        titre = view.findViewById(R.id.titre);
        resume = view.findViewById(R.id.resume);
        collection = view.findViewById(R.id.collection);
        image = view2.findViewById(R.id.image_manga);
        statut = view.findViewById(R.id.statut);
        Button select_image = view.findViewById(R.id.select_image);
        liste = view.findViewById(R.id.list_mangas);
        Button ajout = view.findViewById(R.id.ajout);
        //avoir les éléments>


        //On instancie la liste
        list = new ArrayList<Manga>();

        //Créer un adapter qui va gerer l'affichage de mes items dans la liste
        CustomListMangaAdapter custom = new CustomListMangaAdapter(getContext(),list);



        //On l'ajoute à la listview
        liste.setAdapter(custom);

        //Si on clique sur le boutton pour ajouter une image
        select_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //On lance le luncher qui va recuperer l'image
                loadPics.launch("image/*");

            }
        });

        //Si on clique sur le boutton pour finaliser l'enregistrement de l'élément
        ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t = titre.getText().toString();
                r = resume.getText().toString();
                c = collection.getText().toString();
                image.setImageBitmap(im);
                image.invalidate();

                boolean checked = statut.isChecked();
                if (checked){
                    s = "Fini";
                }else{s = "En cours";}

                //On vérifie que le titre n'est pas vide
                if(!t.isEmpty()) {
                    //On modifie le titre
                    m = new Manga(t,r,s,im,c);
                }

                //On vérifie que le resume n'est pas vide
                if(!r.isEmpty()) {
                    //On modifie le resume
                    m = new Manga(t,r,s,im,c);
                }else{m = new Manga(t,"",s,im,c);}

                //On vérifie que la collection n'est pas vide
                if(!c.isEmpty()) {
                    //On modifie la collection
                    m = new Manga(t, r, s, im, c);
                }else{m = new Manga(t,r,s,im,"");}

                //On ajoute le manga à la liste
                list.add(m);

                Toast.makeText(getContext().getApplicationContext(), "Le manga a bien été ajouté à la liste", Toast.LENGTH_SHORT).show();

            }
        });

        //Initialisation d'une boite de dialogue
        AlertDialog.Builder adbChoix = new AlertDialog.Builder(getContext());

        //Si on clique sur un éléments de la liste
        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                manga = (Manga) liste.getItemAtPosition(position);
                final int positionToRemove = position;

                adbChoix.setTitle("Que faire ?");

                // liste des différents choix à faire sur l'item choisi
                final String[] choix = {"Supprimer", "Modifier le résumé","Modifier la collection", "Modifier statut", "Modifier l'image"};

                //Boite de dialogue avec différent choix
                adbChoix.setItems(choix, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String choce = choix[which];
                        switch (which)
                        {
                            case 0:
                                //Supprimer l'élément
                                list.remove(positionToRemove);
                                dialog.dismiss();
                                Toast.makeText(getContext().getApplicationContext(),"Vous avez choisi: " + choce,
                                        Toast.LENGTH_SHORT).show();
                                break;

                            case 1:
                                //Modifier le résumé
                                change_resume.launch(null);

                                Toast.makeText(getContext().getApplicationContext(),"vous avez mis à jour le resumé de: "+ manga.getTitre(),
                                        Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                                break;

                            case 2:
                                //Modifier la collection
                                change_collection.launch(null);

                                Toast.makeText(getContext().getApplicationContext(),"vous avez mis à jour votre collection: "+ manga.getCollection(),
                                        Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                                break;

                            case 3:
                                //Modifier le statut
                                if (manga.getStatut() == "En cours"){manga.setStatut("Fini");}
                                else{manga.setStatut("En cours");}
                                Toast.makeText(getContext().getApplicationContext(),"Le statut a bien été modifié",
                                        Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                                break;

                            case 4:
                                //Modifier l'image
                                loadPics.launch("image/*");
                                manga.setImage(im);

                                Toast.makeText(getContext().getApplicationContext(),"Le statut a bien été modifié",
                                        Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                                break;
                        }
                    }
                });

                adbChoix.setCancelable(true);

                adbChoix.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext().getApplicationContext(),"Vous avez annulé le choix",
                                Toast.LENGTH_SHORT).show();
                        //  Cancel
                        dialog.cancel();
                    }
                });
                adbChoix.show();
            }
        });

        return view;
    }

    //Changer la collection
    private ActivityResultCallback<String> callback_collection = new ActivityResultCallback<String>(){

        @Override
        public void onActivityResult(String result)   {
            manga.setCollection(result);
        }
    };

    private ActivityResultContract<String,String> contract_collection = new ActivityResultContract<String, String>() {
        @NonNull
        @Override
        public Intent createIntent(@NonNull Context context, String s) {
            Intent i = new Intent(getContext().getApplicationContext(), new_collection.class);
            i.putExtra("collection", c);
            return i;
        }

        @Override
        public String parseResult(int i, @Nullable Intent intent) {
            //(String) intent.getExtras().get("data");
            return c = intent.getStringExtra("new_co");
        }
    };

    ActivityResultLauncher<String> change_collection = registerForActivityResult(contract_collection, callback_collection);
    //Changer la collection


    //Changer le resume{
    private ActivityResultCallback<String> callback_resume = new ActivityResultCallback<String>(){

        @Override
        public void onActivityResult(String result)   {
            manga.setResume(result);
        }
    };

    private ActivityResultContract<String,String> contract_resume = new ActivityResultContract<String, String>() {
        @NonNull
        @Override
        public Intent createIntent(@NonNull Context context, String s) {
            Intent i = new Intent(getContext().getApplicationContext(), new_resume.class);
            i.putExtra("resume", r);
            return i;
        }

        @Override
        public String parseResult(int i, @Nullable Intent result) {
            //(String) intent.getExtras().get("data");
            return r = result.getStringExtra("new_res");
        }
    };

    ActivityResultLauncher<String> change_resume = registerForActivityResult(contract_resume, callback_resume);
    //Changer le resume


    //Prendre une image dans les fichier
    private ActivityResultCallback<Uri> callback_image = new ActivityResultCallback<Uri>() {
        @Override
        public void onActivityResult(Uri result) {
            Bitmap  mBitmap = null;
            try {
                mBitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), result);
            } catch (IOException e) {
                e.printStackTrace();
            }
            im = mBitmap.copy(Bitmap.Config.ARGB_8888,true);

            /* Pour tester si la fonction prend bien l'image
            Intent test = new Intent(getContext().getApplicationContext(), com.example.ma_liste.test.class);
            test.setData(result);
            startActivity(test);*/
        }
    };

    ActivityResultLauncher<String> loadPics = registerForActivityResult(new ActivityResultContracts.GetContent(), callback_image);


    //Prendre une image dans les fichier



}
