package com.example.ma_liste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.ma_liste.adapters.PageAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //< creation de la page >
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //</ creation de la page >

        //< avoir les éléments >
        TabLayout tab = findViewById(R.id.tabs);
        ViewPager2 page = findViewById(R.id.pages);
        //</ avoir les éléments >

        PageAdapter adapter = new PageAdapter(this);
        page.setAdapter(adapter);

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                page.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        page.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position){
                super.onPageSelected(position);
                tab.getTabAt(position).select();
            }
        });

    }
}