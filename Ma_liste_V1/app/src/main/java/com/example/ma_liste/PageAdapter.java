package com.example.ma_liste;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.ma_liste.fragments.Achats;
import com.example.ma_liste.fragments.Animes;
import com.example.ma_liste.fragments.Mangas;
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
                return  new Achats();
            case 1:
                return  new Animes();
            case 2:
                return  new Mangas();
            default:
                return  new Scans();
        }
    }
    @Override
    public int getItemCount() {return 4; }
}