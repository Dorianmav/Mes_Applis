package com.example.meslistes.Class;

import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FABMenu implements View.OnClickListener {

    View view;
    ArrayList<FloatingActionButton> floatingActionButtonArrayList;

    public FABMenu(View view, ArrayList<FloatingActionButton> floatingActionButtonArrayList) {
        this.view = view;
        this.floatingActionButtonArrayList = floatingActionButtonArrayList;
    }

    @Override
    public void onClick(View v) {

    }
}
