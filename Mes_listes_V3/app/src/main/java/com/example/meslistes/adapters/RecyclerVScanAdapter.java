package com.example.meslistes.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meslistes.Class.Manga;
import com.example.meslistes.Class.Scan;
import com.example.meslistes.R;

import java.util.ArrayList;

public class RecyclerVScanAdapter extends RecyclerView.Adapter<RecyclerVScanAdapter.RecVviewHolder> {

    private Context context;
    private ArrayList<Scan> scansArrayList;
    private Scan scan;
    LayoutInflater layoutInflater;
    View v2;

    // Stocker les données dans les SharedPreferences
    SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
    SharedPreferences.Editor editor = prefs.edit();
    Set<String> mySet = new HashSet<String>();
mySet.addAll(myDataList);
editor.putStringSet("myData", mySet);
editor.apply();

    // Récupérer les données des SharedPreferences
    Set<String> mySet = prefs.getStringSet("myData", null);
if (mySet != null) {
        myDataList.clear();
        myDataList.addAll(mySet);
    }

// Réinsérer les données dans l'adaptateur pour RecyclerView
myAdapter.notifyDataSetChanged();

    public RecyclerVScanAdapter(Context context, ArrayList<Scan> scansArrayList) {
        this.context = context;
        this.scansArrayList = scansArrayList;
    }

    @NonNull
    @Override
    public RecyclerVScanAdapter.RecVviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater = LayoutInflater.from(parent.getContext());
        View viewItem = layoutInflater.inflate(R.layout.scan_items,parent,false);
        v2 = layoutInflater.inflate(R.layout.layout_choice,parent,false);


        return new RecVviewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerVScanAdapter.RecVviewHolder holder, int position) {
        scan = scansArrayList.get(position);
        holder.item_titre_scan.setText(String.format("%s - " + scan.getTitre(),position));
        holder.item_chapitre_selecteur.setMinValue(1);
        holder.item_chapitre_selecteur.setMaxValue(2000);
        holder.item_chapitre_selecteur.setWrapSelectorWheel(false);
        holder.item_chapitre_selecteur.setVisibility(View.GONE);
        holder.item_chapitre_selecteur.setValue(Integer.parseInt(scan.getChapitre()));
        holder.item_chapitre.setText(scan.getChapitre());

        holder.item_chapitre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.item_chapitre_selecteur.setVisibility(View.VISIBLE);
                holder.item_chapitre.setVisibility(View.GONE);
            }
        });

        holder.item_chapitre_selecteur.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                holder.item_chapitre.setText(String.format("%s",newVal));
                scan.setChapitre(String.format("%s",newVal));
            }
        });
        holder.item_chapitre_selecteur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.item_chapitre.setVisibility(View.VISIBLE);
                holder.item_chapitre_selecteur.setVisibility(View.GONE);
            }
        });
        
        holder.item_card.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //showNeutralAlertDialog();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {return scansArrayList.size();}

    public static class RecVviewHolder extends RecyclerView.ViewHolder {

        CardView item_card;
        TextView item_titre_scan, item_chapitre;
        NumberPicker item_chapitre_selecteur;

        public RecVviewHolder(@NonNull View itemView) {
            super(itemView);

            item_card = itemView.findViewById(R.id.item_card);
            item_titre_scan = itemView.findViewById(R.id.item_titre_scan);
            item_chapitre = itemView.findViewById(R.id.item_chapitre);
            item_chapitre_selecteur = itemView.findViewById(R.id.item_chapitre_selecteur);
        }
    }


    public void setSearchList(ArrayList<Scan> scansSearchList){
        this.scansArrayList = scansSearchList;
        notifyDataSetChanged();
    }


    private void showNeutralAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.AlertDialogTheme);
        LayoutInflater l = LayoutInflater.from(context);
        v2.findViewById(R.id.layoutDialogContainer);

        builder.setView(v2);
        ((TextView)v2.findViewById(R.id.dialTitre)).setText("Internet");
        ((TextView)v2.findViewById(R.id.dialMessage)).setText("A quoi voulez-vous acceder?");
        ((Button) v2.findViewById(R.id.buttonYes)).setText("Acceuil scan");
        ((Button) v2.findViewById(R.id.buttonNo)).setText("Au dernier chapitre");
        //((ImageView)v2.findViewById(R.id.dialImageIcon)).setImageResource(R.drawable.ic_baseline_warning_24);

        final AlertDialog alertDialog = builder.create();

        v2.findViewById(R.id.buttonYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "acceuil scan", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
                String url_acceuil = scan.getSite_internet();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url_acceuil));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                context.startActivity(intent);
            }
        });

        v2.findViewById(R.id.buttonNo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "chapitre direct", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
                String url_chap = scan.getSite_chapitre() + scan.getChapitre();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url_chap));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                context.startActivity(intent);
            }
        });
        if (alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();

    }


}
