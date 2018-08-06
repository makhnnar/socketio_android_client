package com.house.domotic.my.mylogintest.views.home;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import com.house.domotic.my.mylogintest.R;
import com.house.domotic.my.mylogintest.views.home.chatactivos.ChatActivosFragment;
import com.house.domotic.my.mylogintest.views.home.listaamigos.ListaAmigosFragment;

public class HomeActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        TabLayout tabLayout = (TabLayout)findViewById(R.id.tl_ah_tablayout);
        ViewPager viewPager = (ViewPager)findViewById(R.id.vp_ah_viewpager);
        viewPager.setAdapter(new HomePagerAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(0);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                // TODO : Something
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });




    }
}
