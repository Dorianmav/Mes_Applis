package com.example.mes_listes_v4.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mes_listes_v4.Class.ItemCourse;
import com.example.mes_listes_v4.R;

import java.util.ArrayList;

public class RecyclerVAchatAdapter extends RecyclerView.Adapter<RecyclerVAchatAdapter.RecVviewHolder> {

    Context context;
    ArrayList<ItemCourse> produitArrayList;

    public RecyclerVAchatAdapter(Context context, ArrayList<ItemCourse> produitArrayList) {
        this.context = context;
        this.produitArrayList = produitArrayList;
    }


    @NonNull
    @Override
    public RecyclerVAchatAdapter.RecVviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View viewItem = layoutInflater.inflate(R.layout.achat_items, parent, false);

        return new RecVviewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerVAchatAdapter.RecVviewHolder holder, @SuppressLint("RecyclerView") int position) {
        ItemCourse produit = produitArrayList.get(position);
        holder.item_nom.setText(produit.getNom());
        holder.item_qte.setText("x" + produit.getQuantite());
        holder.item_magasin.setText(produit.getMagasin());


        //Faire un text cliquable

        SpannableString ss = new SpannableString("x" + produit.getQuantite());
        ClickableSpan clickableSpan = new ClickableSpan() {
            public void onClick(View textView) {

            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };
        ss.setSpan(clickableSpan, 0, produitArrayList.size(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        holder.item_qte.setText(ss);
        holder.item_qte.setMovementMethod(LinkMovementMethod.getInstance());
        holder.item_qte.setHighlightColor(Color.TRANSPARENT);

        holder.item_card.setOnClickListener(
                v -> Toast.makeText(context, "nom du produit: " +
                        holder.item_nom.getText() + "\n quantité " +
                        holder.item_qte.getText() + "\n magasin " +
                        holder, Toast.LENGTH_SHORT).show());

        //supprimer la carte en cliquand tur l'image de la poubele
        holder.item_delete.setOnClickListener(v -> {
            produitArrayList.remove(position);
            notifyDataSetChanged();
        });

    }




    @Override
    public int getItemCount() {
        return produitArrayList.size();
    }


    public class RecVviewHolder extends  RecyclerView.ViewHolder{
        TextView item_nom, item_qte, item_magasin;
        ImageButton item_delete;
        CardView item_card;
        CheckBox item_check;

        public RecVviewHolder(@NonNull View itemView) {
            super(itemView);

            item_nom = itemView.findViewById(R.id.achat_item_nom);
            item_qte = itemView.findViewById(R.id.achat_item_qte);
            item_magasin = itemView.findViewById(R.id.achat_item_magasin);
            item_delete = itemView.findViewById(R.id.achat_item_delete);
            item_check = itemView.findViewById(R.id.achat_item_checkBox);
            item_card = itemView.findViewById(R.id.item_card);


        }
    }

}
