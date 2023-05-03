package com.example.meslistes.activitys;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.fabrevealmenu.helper.OnFABMenuSelectedListener;
import com.example.fabrevealmenu.helper.RevealDirection;
import com.example.meslistes.R;
import com.example.meslistes.adapters.RecyclerVMangaGAdapter;
import com.example.meslistes.Class.Manga;
import com.example.meslistes.adapters.RecyclerVMangaLAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.util.ArrayList;

public class MangaActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Manga> mangasArrayList;
    View formulaire, menu_items;
    EditText manga_titre, resume, collection;
    Switch statut;
    ImageButton newmanga;
    ImageView image;
    Button select_image, ajoutmanga;
    RecyclerVMangaGAdapter recyclerVMangaGAdapter;
    RecyclerVMangaLAdapter recyclerVMangaLAdapter;

    SearchView searchView;

    private Parcelable saveRVLayoutState;
    private static String LIST_STATE = "list_state";
    private static final String BUNDLE_RECYCLER_LAYOUT = "recycler_layout";

    private FloatingActionButton fabmenu, mode_grille, mode_ligne;



    boolean cacher = true;
    Bitmap im;
    Manga manga;
    String r,s,c;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manga);
        View v2 = View.inflate(this, R.layout.manga_items_grille, null);

        formulaire = findViewById(R.id.ajoutMangaform);
        formulaire.setVisibility(View.GONE);
        searchView = findViewById(R.id.manga_seach);
        recyclerView = findViewById(R.id.recvManga);
        manga_titre = findViewById(R.id.manga_titre);
        resume = findViewById(R.id.resume);
        collection = findViewById(R.id.collection);
        statut = findViewById(R.id.statut);
        newmanga = findViewById(R.id.ajout);
        image = v2.findViewById(R.id.item_image_manga);
        select_image = findViewById(R.id.select_image);
        ajoutmanga = findViewById(R.id.ajoutmanga);
        mode_grille = findViewById(R.id.mode_grille);
        mode_ligne = findViewById(R.id.mode_ligne);
        mode_grille.setVisibility(View.GONE);
        mode_ligne.setVisibility(View.GONE);
        fabmenu = findViewById(R.id.fab);


        fabmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSlideMenu();
                /*Potentiellement changer l'image du fabmenu*/
            }
        });


        System.out.println(savedInstanceState);
        if (savedInstanceState == null) {
            Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
        } else {
            saveRVLayoutState = savedInstanceState.getParcelable(BUNDLE_RECYCLER_LAYOUT);
        }

        mangasArrayList = new ArrayList<>();
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerVMangaGAdapter = new RecyclerVMangaGAdapter(this,mangasArrayList);
        recyclerView.setAdapter(recyclerVMangaGAdapter);

        mode_grille.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
                recyclerVMangaGAdapter = new RecyclerVMangaGAdapter(getApplicationContext(),mangasArrayList);
                recyclerView.setAdapter(recyclerVMangaGAdapter);
                onSlideMenu();
            }
        });
        mode_ligne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerVMangaLAdapter = new RecyclerVMangaLAdapter(getApplicationContext(),mangasArrayList);
                recyclerView.setAdapter(recyclerVMangaLAdapter);
                onSlideMenu();
            }
        });


        /*Cliquer sur le petit plus pour faire apparaitre le formulaire pour ajouter un nv manga*/
        newmanga.setOnClickListener(v -> {
            onSlideFormulaire(formulaire);
        });

        //Si on clique sur le boutton pour ajouter une image

        select_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //On lance le luncher qui va recuperer l'image
                loadPics.launch("image/*");

            }
        });

        //Si on clique sur le boutton pour finaliser l'enregistrement de l'élément
        ajoutmanga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t = manga_titre.getText().toString();
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
                    manga = new Manga(t,r,s,im,c);
                }

                //On vérifie que le resume n'est pas vide
                if(!r.isEmpty()) {
                    //On modifie le resume
                    manga = new Manga(t,r,s,im,c);
                }else{manga = new Manga(t,"",s,im,c);}

                //On vérifie que la collection n'est pas vide
                if(!c.isEmpty()) {
                    //On modifie la collection
                    manga = new Manga(t, r, s, im, c);
                }else{manga = new Manga(t,r,s,im,"");}

                //On ajoute le manga à la liste
                mangasArrayList.add(manga);

                slideUp(formulaire);
                manga_titre.setText("");
                resume.setText("");
                collection.setText("");
                Toast.makeText(getApplicationContext(), "Le manga a bien été ajouté à la liste", Toast.LENGTH_SHORT).show();

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
        ArrayList<Manga> mangaSearchList = new ArrayList<>();
        for (Manga manga : mangasArrayList){
            if (manga.getTitre().toLowerCase().contains(text.toLowerCase())){
                mangaSearchList.add(manga);
            }
        }
        if (mangaSearchList.isEmpty()){
            Toast.makeText(this, "Pas trouvé", Toast.LENGTH_SHORT).show();
        } else {
            recyclerVMangaGAdapter.setSearchList(mangaSearchList);
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

    /*fonction pour gerer l'apparition du menu*/

    public void onSlideMenu() {
        if (cacher) {
            mode_ligne.animate()
                    .translationY(0)
                    .alpha(0.0f)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            mode_ligne.setVisibility(View.GONE);
                            mode_grille.animate()
                                    .translationY(0)
                                    .alpha(0.0f)
                                    .setListener(null);
                        }
                    });
        } else {
            mode_grille.setVisibility(View.VISIBLE);
            mode_grille.setAlpha(0.0f);
            // Start the animation
            mode_grille.animate()
                    .translationY(-20)
                    .alpha(1.0f)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            mode_ligne.setVisibility(View.VISIBLE);
                            mode_ligne.setAlpha(0.0f);
                            mode_ligne.animate()
                                    .translationY(-20)
                                    .alpha(1.0f)
                                    .setListener(null);
                        }
                    });
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



    //Prendre une image dans les fichier
    private ActivityResultCallback<Uri> callback_image = new ActivityResultCallback<Uri>() {
        @Override
        public void onActivityResult(Uri result) {
            Bitmap mBitmap = null;
            try {
                mBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), result);
            } catch (IOException e) {
                e.printStackTrace();
            }
            im = mBitmap.copy(Bitmap.Config.ARGB_8888,true);
        }
    };

    ActivityResultLauncher<String> loadPics = registerForActivityResult(new ActivityResultContracts.GetContent(), callback_image);

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        saveRVLayoutState = recyclerView.getLayoutManager().onSaveInstanceState();
        outState.putParcelable(BUNDLE_RECYCLER_LAYOUT, saveRVLayoutState);
        System.out.println("on save outstate " + outState);
        super.onSaveInstanceState(outState);
    }



    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            System.out.println("on restore saveInstance " + savedInstanceState);
            saveRVLayoutState = savedInstanceState.getParcelable(BUNDLE_RECYCLER_LAYOUT);
//           recyclerView.setLayoutManager((RecyclerView.LayoutManager) saveRVLayoutState);
            System.out.println("on restore save RVL " + saveRVLayoutState);

        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (saveRVLayoutState != null){
            recyclerView.getLayoutManager().onRestoreInstanceState(saveRVLayoutState);
        }
    }
}