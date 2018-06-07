package com.luisro00005513.gamenews.Activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.luisro00005513.gamenews.Adapters.FragmentPagerAdapter;
import com.luisro00005513.gamenews.Fragments.Generals;
import com.luisro00005513.gamenews.Fragments.Images;
import com.luisro00005513.gamenews.Fragments.TopPlayers;
import com.luisro00005513.gamenews.R;

public class GameInfo extends AppCompatActivity implements Generals.OnFragmentInteractionListener,
        TopPlayers.OnFragmentInteractionListener, Images.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_info);
        //======================todo sobre el tab====================
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //========================================
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Generals"));
        tabLayout.addTab(tabLayout.newTab().setText("Top players"));
        tabLayout.addTab(tabLayout.newTab().setText("Images"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);
        final FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //======================todo sobre el tab(fin)=================
    }

    

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
