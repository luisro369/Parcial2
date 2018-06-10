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
import android.widget.TextView;
import android.widget.Toast;

import com.luisro00005513.gamenews.Adapters.NewsAdapter;
import com.luisro00005513.gamenews.Classes.ImagenesParaCardView;
import com.luisro00005513.gamenews.Classes.Login;
import com.luisro00005513.gamenews.Classes.News;
import com.luisro00005513.gamenews.Classes.NewsService;
import com.luisro00005513.gamenews.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.os.SystemClock.sleep;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    //=========declarando variables para news=============
    RecyclerView recyclerView;
    ArrayList<News> news_list = new ArrayList<>();
    ArrayList<News> lista_Completa = new ArrayList<>();
    //TextView titulo;
    String imagen;
    private static String token;
    public static final String BASE_URL = "https://gamenewsuca.herokuapp.com";


    //--------------codigo para retrofit2---------------------
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request newRequest = chain.request().newBuilder()
                    .addHeader("Authorization","Bearer " + token)
                    .build();
            return chain.proceed(newRequest);
        }
    }).build();


    Retrofit.Builder buider = new Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());
    Retrofit retrofit = buider.build();
    NewsService newsService = retrofit.create(NewsService.class);

    //--------------codigo para retrofit2---------------------

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


        //titulo = (TextView)findViewById(R.id.news_title);
        //retrofit
        getToken();
        //creando CardViews



    }

    private void CreandoCardViews(){
        //=========codigo para CardView de news=============
        recyclerView = (RecyclerView)findViewById(R.id.recycler_news);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        NewsAdapter newsAdapter = new NewsAdapter(getApplicationContext(),news_list);//modifique esto
        recyclerView.setAdapter(newsAdapter);
        //=========codigo para CardView de news(fin)========
    }



    //==============aca creo el metodo que llame en la interfaz(NewsService) para POST========================
    private void getToken(){
        Login login = new Login("username","password");
        Call<Login> call = newsService.getToken(login);
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if(response.isSuccessful()){
                    token = response.body().getToken();
                    Toast.makeText(MainActivity.this,"El token es: "+response.body().getToken(),Toast.LENGTH_SHORT).show();
                    //=====si tuvimos exito y generamos un token manda a llama lo demas========
                    //getListaNoticias(token);
                    getTitles();
                }
                else{
                    Toast.makeText(MainActivity.this,"Fallo al agarrar token",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Fallo de conexion",Toast.LENGTH_SHORT).show();
            }
        });

    }//getToken
    //==============aca creo el metodo que llame en la interfaz(NewsService) para GET========================
    private void getTitles(){
        Call<List<News>> call = newsService.getTitles("title","game","_id","body", "date",
                "coverImage", "description");
        call.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                Toast.makeText(MainActivity.this,"Conexion exitosa",Toast.LENGTH_SHORT).show();
                for(int i = 0; i < 10; i++) {
                    //Noticia completa
                    String id = response.body().get(i).getId();
                    String imagen = response.body().get(i).getCoverImage();
                    String body = response.body().get(i).getBody();
                    String date = response.body().get(i).getCreatedDate();
                    String description = response.body().get(i).getDescription();
                    //cardviews
                    String titulo = response.body().get(i).getTitle();
                    String game = response.body().get(i).getGame();
                    news_list.add(new News(titulo,game));//arreglo para cardviews
                    lista_Completa.add(new News(id,titulo,body,game,date,imagen,description));
                }

                //imagen = response.body().get(3).getCoverImage();
                //ImagenesParaCardView imagenesParaCardView = new ImagenesParaCardView();
                //imagenesParaCardView.setImagenUrl(imagen);
                CreandoCardViews();
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"fallo de recoleccion de datos",Toast.LENGTH_SHORT).show();

            }
        });

    }//getTitles



















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
