package com.example.ma_liste.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.ma_liste.fragments.Achats;
import com.example.ma_liste.fragments.Animes;
import com.example.ma_liste.fragments.Mangas;
import com.example.ma_liste.fragments.Precommandes;
import com.example.ma_liste.fragments.Scans;

public class PageAdapter extends FragmentStateAdapter {

    public PageAdapter(@NonNull FragmentActivity fragmentActivity)
    {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return  new Scans();
            case 1:
                return  new Mangas();
            case 2:
                return  new Animes();
            case 3:
                return  new Achats();
            default:
                return new Precommandes();
        }
    }
    @Override
    public int getItemCount() {return 5; }
}