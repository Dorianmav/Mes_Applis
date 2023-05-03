package com.example.meslistes.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meslistes.R;
import com.example.meslistes.activitys.DetailMangaActivity;
import com.example.meslistes.Class.Manga;

import java.util.ArrayList;

public class RecyclerVMangaGAdapter extends RecyclerView.Adapter<RecyclerVMangaGAdapter.RecVviewHolder> {

    private Context context;
    private ArrayList<Manga> mangasArrayList;
    private Manga manga;
    LayoutInflater layoutInflater;
    View v2;

     public void setSearchList(ArrayList<Manga> mangaSearchList){
         this.mangasArrayList = mangaSearchList;
         notifyDataSetChanged();
     }

    public RecyclerVMangaGAdapter(Context context, ArrayList<Manga> mangasArrayList) {
        this.context = context;
        this.mangasArrayList = mangasArrayList;
    }


    @NonNull
    @Override
    public RecyclerVMangaGAdapter.RecVviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater = LayoutInflater.from(parent.getContext());
        View viewItem = layoutInflater.inflate(R.layout.manga_items_grille, parent, false);
        v2 = layoutInflater.inflate(R.layout.layout_warning_dialog,parent,false);

        return new RecVviewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerVMangaGAdapter.RecVviewHolder holder, int position) {
        manga = mangasArrayList.get(position);
        holder.item_titre_manga.setText(manga.getTitre());
        holder.item_image_manga.setImageBitmap(manga.getImage());

        holder.item_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailMangaActivity.class);
                intent.putExtra("titre", mangasArrayList.get(holder.getAdapterPosition()).getTitre());
                intent.putExtra("resume", manga.getResume());
                intent.putExtra("collection", manga.getCollection());
                intent.putExtra("statut", manga.getStatut());
                //intent.putExtra("image", manga.getImage());

                context.startActivity(intent);
            }
        });

        holder.item_card.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showWarningAlertDialog();
                return false;
            }
        });

    }



    @Override
    public int getItemCount() {
        return mangasArrayList.size();
    }

    public static class RecVviewHolder extends  RecyclerView.ViewHolder{

        CardView item_card;
        ImageView item_image_manga;
        TextView item_titre_manga, item_resume, item_statut, item_collection;

        public RecVviewHolder(@NonNull View itemView) {
            super(itemView);

            item_card = itemView.findViewById(R.id.item_card);
            item_image_manga = itemView.findViewById(R.id.item_image_manga);
            item_titre_manga = itemView.findViewById(R.id.item_titre_manga);        }
    }



    private void showWarningAlertDialog() {
         AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.AlertDialogTheme);
         LayoutInflater l = LayoutInflater.from(context);
         v2.findViewById(R.id.layoutDialogContainer);

         builder.setView(v2);
        ((TextView)v2.findViewById(R.id.dialTitre)).setText("Supprimer");
        ((TextView)v2.findViewById(R.id.dialMessage)).setText("Voulez-vous supprimer ce manga: " + manga.getTitre() + " ?");
        ((Button) v2.findViewById(R.id.buttonYes)).setText("Oui");
        ((Button) v2.findViewById(R.id.buttonNo)).setText("Non");
        ((ImageView)v2.findViewById(R.id.dialImageIcon)).setImageResource(R.drawable.ic_baseline_warning_24);

        final AlertDialog alertDialog = builder.create();

        v2.findViewById(R.id.buttonYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                mangasArrayList.remove(manga);
                notifyDataSetChanged();
            }
        });

        v2.findViewById(R.id.buttonNo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.cancel();
            }
        });
        if (alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }





}
