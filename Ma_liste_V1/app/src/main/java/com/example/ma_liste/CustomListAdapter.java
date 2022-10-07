package com.example.ma_liste;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    private List<Produit> listeProduit;
    private LayoutInflater layoutInflater;
    private Context context;


    public CustomListAdapter(Context aContext, List<Produit> listeProduit) {
        this.context = aContext;
        this.listeProduit = listeProduit;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listeProduit.size();
    }

    @Override
    public Object getItem(int position) {
        return listeProduit.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_layout, null);
            holder = new ViewHolder();
            holder.produitV = (TextView) convertView.findViewById(R.id.produit);
            holder.qteV = (TextView) convertView.findViewById(R.id.qte);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Produit produit = this.listeProduit.get(position);
        holder.produitV.setText(produit.getNom());
        holder.qteV.setText("x"+ produit.getQte());

        return convertView;
    }

    static class ViewHolder {
        TextView produitV;
        TextView qteV;
    }
}
