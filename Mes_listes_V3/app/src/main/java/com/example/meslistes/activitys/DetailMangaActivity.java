package com.example.meslistes.activitys;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.meslistes.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class DetailMangaActivity extends AppCompatActivity {

    TextView detail_titre_manga, detail_resume_manga, detail_collection_manga;
    ImageView detail_image_manga;
    Button mod_resume, mod_collection;
    EditText new_resume, new_collection;
    FloatingActionButton fab;
    CheckBox detail_statut;

    boolean cacher = true;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_manga);

        detail_titre_manga = findViewById(R.id.detail_titre_manga);
        detail_resume_manga = findViewById(R.id.detail_resume_manga);
        detail_collection_manga = findViewById(R.id.detail_collection_manga);
        detail_image_manga = findViewById(R.id.detail_image_manga);
        detail_statut = findViewById(R.id.detail_statut);
        new_resume = findViewById(R.id.new_resume);
        new_collection = findViewById(R.id.new_collection);
        mod_resume = findViewById(R.id.mod_resume);
        mod_collection = findViewById(R.id.mod_collection);
        mod_resume.setVisibility(View.GONE);
        mod_collection.setVisibility(View.GONE);
        new_resume.setVisibility(View.GONE);
        new_collection.setVisibility(View.GONE);
        fab = findViewById(R.id.fab);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            detail_titre_manga.setText(bundle.getString("titre"));
            detail_resume_manga.setText(bundle.getString("resume"));
            detail_collection_manga.setText(bundle.getString("collection"));
            String state = bundle.getString("statut");
            if (Objects.equals(state, "Fini")){
                detail_statut.setChecked(true);
                //detail_statut.setEnabled(false);
            }else {
                detail_statut.setChecked(false);
            }
            //detail_image_manga.setImageBitmap(bundle.getParcelable("image"));
        }


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSlideMenu();
            }
        });

        mod_resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cacher){
                    new_resume.animate().translationX(0).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            String nc = new_resume.getText().toString();
                            if (!nc.isEmpty()){
                                detail_resume_manga.setText(nc);
                                Toast.makeText(DetailMangaActivity.this, "Résume mit à jour", Toast.LENGTH_SHORT).show();
                            }
                            new_resume.setVisibility(View.GONE);
                            new_resume.setText("");
                        }
                    });

                } else {
                    new_resume.setVisibility(View.VISIBLE);
                    new_resume.setAlpha(0.0f);
                    new_resume.animate().translationX(20).alpha(1.0f).setListener(null);
                }
                cacher =!cacher;
            }
        });

        mod_collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cacher){
                    new_collection.animate().translationX(0).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            String nc = new_collection.getText().toString();
                            if (!nc.isEmpty()){
                                detail_collection_manga.setText(nc);
                                Toast.makeText(DetailMangaActivity.this, "Collection mit à jour", Toast.LENGTH_SHORT).show();
                            }
                            new_collection.setVisibility(View.GONE);
                            new_collection.setText("");
                        }
                    });

                } else {
                    new_collection.setVisibility(View.VISIBLE);
                    new_collection.setAlpha(0.0f);
                    new_collection.animate().translationX(20).alpha(1.0f).setListener(null);
                }
                cacher =!cacher;
            }
        });

    }

    private void onSlideMenu() {
        if (cacher){
            if (new_resume.getVisibility() == View.VISIBLE || new_collection.getVisibility() == View.VISIBLE|| new_resume.getVisibility() == View.VISIBLE && new_collection.getVisibility() == View.VISIBLE) {
                new_resume.animate().translationY(0).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        new_resume.setVisibility(View.GONE);
                        mod_resume.animate().translationY(0).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                mod_resume.setVisibility(View.GONE);
                                new_collection.animate().translationY(0).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        super.onAnimationEnd(animation);
                                        new_collection.setVisibility(View.GONE);
                                        mod_collection.animate().translationY(0).alpha(0.0f).setListener(null);
                                    }
                                });
                            }
                        });
                    }
                });
                new_resume.setText("");
                new_collection.setText("");
            } else {
                mod_resume.animate().translationY(0).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        mod_resume.setVisibility(View.GONE);
                        mod_collection.animate().translationY(0).alpha(0.0f).setListener(null);
                    }
                });
            }
        } else {
            mod_collection.setVisibility(View.VISIBLE);
            mod_collection.setAlpha(0.0f);
            mod_collection.animate().translationY(-20).alpha(1.0f).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    mod_resume.setVisibility(View.VISIBLE);
                    mod_resume.setAlpha(0.0f);
                    mod_resume.animate().translationY(-20).alpha(1.0f).setListener(null);
                }
            });
        }
        cacher = !cacher;
    }









}
