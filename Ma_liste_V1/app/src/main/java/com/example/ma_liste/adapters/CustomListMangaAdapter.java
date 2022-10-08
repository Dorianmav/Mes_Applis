package com.example.ma_liste.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ma_liste.Class.Manga;
import com.example.ma_liste.R;

import java.util.List;

public class CustomListMangaAdapter extends BaseAdapter {

    private List<Manga> listeManga;
    private LayoutInflater layoutInflater;
    private Context context;


    public CustomListMangaAdapter(Context aContext, List<Manga> listeManga) {
        this.context = aContext;
        this.listeManga = listeManga;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listeManga.size();
    }

    @Override
    public Object getItem(int position) {
        return listeManga.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_manga_layout, null);
            holder = new ViewHolder();
            holder.titreV = (TextView) convertView.findViewById(R.id.titre);
            holder.resumeV = (TextView) convertView.findViewById(R.id.resume);
            holder.collectionV = (TextView) convertView.findViewById(R.id.collection);
            holder.statutV = (TextView) convertView.findViewById(R.id.statut);
            holder.imageV = convertView.findViewById(R.id.image_manga);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Manga manga = this.listeManga.get(position);
        holder.titreV.setText(manga.getTitre());
        holder.resumeV.setText(manga.getResume());
        holder.imageV.setImageBitmap(manga.getImage());
        holder.collectionV.setText("Ma collection: " + manga.getCollection());
        holder.statutV.setText("Statut: \n" + manga.getStatut());

        return convertView;
    }

    static class ViewHolder {
        TextView titreV;
        TextView resumeV;
        TextView collectionV;
        TextView statutV;
        ImageView imageV;
    }
}
