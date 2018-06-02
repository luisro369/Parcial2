package com.luisro00005513.gamenews.Activities;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import com.luisro00005513.gamenews.Adapters.NewsAdapter;
import com.luisro00005513.gamenews.Classes.News;
import com.luisro00005513.gamenews.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    //=========declarando variables para news=============
    RecyclerView recyclerView;
    ArrayList<News> news_list = new ArrayList<>();
    //ImageView image2;
    //ImageView image3;

    //=========declarando variables para news(fin)========

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

        //=========codigo para news=============
        recyclerView = (RecyclerView)findViewById(R.id.recycler_news);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        fillList();
        NewsAdapter newsAdapter = new NewsAdapter(news_list);
        recyclerView.setAdapter(newsAdapter);
        //=========codigo para news(fin)========

    }

    private void fillList(){
        news_list.add(new News("God of war", "Atreo es loki!!!!"));
        news_list.add(new News("Gta", "michael es gay"));
        news_list.add(new News("The legend of zelda", "link no es zelda :("));
    }//fillList




















    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        //===========aca se le da funcionalidad a los botones del slide
        int id = item.getItemId();

        if (id == R.id.nav_news) {//para el boton news
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.nav_games) {//para los juegos
            Intent intent = new Intent(getApplicationContext(),GameInfo.class);
            startActivity(intent);

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_favorite) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }









}
