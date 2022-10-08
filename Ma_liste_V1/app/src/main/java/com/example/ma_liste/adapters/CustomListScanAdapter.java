package com.example.ma_liste.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ma_liste.R;
import com.example.ma_liste.Class.Scan;

import java.util.List;

public class CustomListScanAdapter extends BaseAdapter {

    private List<Scan> listeScan;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListScanAdapter(Context aContext, List<Scan> listeScan) {
        this.context = aContext;
        this.listeScan = listeScan;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() { return listeScan.size(); }

    @Override
    public Object getItem(int position) { return listeScan.get(position); }

    @Override
    public long getItemId(int position) { return position;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_scan_layout, null);
            holder = new CustomListScanAdapter.ViewHolder();
            holder.titreV = (TextView) convertView.findViewById(R.id.titre);
            holder.chaitreV = (TextView) convertView.findViewById(R.id.chapitre);
            //holder.lienV = (TextView) convertView.findViewById(R.id.lien_scan);

            convertView.setTag(holder);

        } else {
            holder = (CustomListScanAdapter.ViewHolder) convertView.getTag();
        }

        Scan scan = this.listeScan.get(position);
        holder.titreV.setText(scan.getTitre());
        holder.chaitreV.setText(scan.getChapitre());
        //holder.lienV.setText(scan.getSLien());

        return convertView;
    }

    static class ViewHolder {
        TextView titreV;
        TextView chaitreV;
        TextView lienV;
    }


}
