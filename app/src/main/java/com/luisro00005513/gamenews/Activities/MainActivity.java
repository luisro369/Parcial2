package com.luisro00005513.gamenews.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.luisro00005513.gamenews.Classes.News;
import com.luisro00005513.gamenews.Classes.Players;
import com.luisro00005513.gamenews.Fragments.FavoriteNews;
import com.luisro00005513.gamenews.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
        implements
        NavigationView.OnNavigationItemSelectedListener {

    //--------------variables globales entre clases(esto sustituye al bundle)------
    //---------------variables globales para Generals--------------------
    public static String gameStk,desciptionStk,bodyStk,imagenStk;
    //---------------variables globales para TopPlayers--------------------
    public static ArrayList<Players> players_list = new ArrayList<>();
    //---------------variables globales para Images--------------------
    public static ArrayList<News> news_lists = new ArrayList<>();
    //---------------variables globales para favoritos------------------
    public static ArrayList<News> favorite_news = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);






    }//on create





















    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }






    //===============aca decido que hace cada boton del drawer==============

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        //===========aca se le da funcionalidad a los botones del slide
        int id = item.getItemId();

        if (id == R.id.nav_news) {//para el boton news
            Fragment Fnews = getSupportFragmentManager().findFragmentById(R.id.fragment_padre);
            if(Fnews != null){
                //codigo para inflar el fragment ya creado (backsatack)
                Fnews.getFragmentManager().popBackStackImmediate();
            }
            else {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
            // Handle the camera action
        } else if (id == R.id.nav_games) {//para los juegos

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_favorite) {
            //lleno el fragment padre con el fragment de favoritos
            FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
            fr.addToBackStack(null);
            fr.replace(R.id.fragment_padre, new FavoriteNews());
            fr.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
