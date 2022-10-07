package com.example.ma_liste;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
        return null;
    }

    static class ViewHolder {
        TextView titreV;
        TextView chaitreV;
        TextView lienV;
    }
}
