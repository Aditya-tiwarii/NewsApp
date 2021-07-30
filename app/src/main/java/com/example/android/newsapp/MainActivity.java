package com.example.android.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mhome,msports,mhealth,mscience,mentertainment,mtechnology,mstartup;
    PagerAdapter pagerAdapter;
    Toolbar mtoolbar;

    String api ="a0b7d61fbf9a43b9b842c8b6460dff44";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);

        hooks();
        ViewPager viewPager = findViewById(R.id.fragmentContainer);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),7);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2 || tab.getPosition()==3 || tab.getPosition()==4 || tab.getPosition()==5 || tab.getPosition()==6){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

    private void hooks() {
        mhome = findViewById(R.id.home);
        msports= findViewById(R.id.sports);
        mhealth= findViewById(R.id.health);
        mscience= findViewById(R.id.science);
        mentertainment= findViewById(R.id.entertainment);
        mtechnology= findViewById(R.id.technology);
        mstartup= findViewById(R.id.startup);
        tabLayout = findViewById(R.id.tabLayout);
    }
}