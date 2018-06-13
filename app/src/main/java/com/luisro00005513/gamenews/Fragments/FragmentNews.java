package com.luisro00005513.gamenews.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.luisro00005513.gamenews.Adapters.NewsAdapter;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentNews extends Fragment {
    //=========declarando variables para news=============
    RecyclerView recyclerView;
    ArrayList<News> news_list = new ArrayList<>();
    //ArrayList<News> lista_Completa = new ArrayList<>();
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



    public FragmentNews() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_news, container, false);
        getToken();
        return view;
    }









    private void CreandoCardViews(){
        //=========codigo para CardView de news=============
        recyclerView = (RecyclerView)getView().findViewById(R.id.recycler_news);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        NewsAdapter newsAdapter = new NewsAdapter(getContext(),news_list);//modifique esto
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
                    Toast.makeText(getContext(),"El token es: "+response.body().getToken(),Toast.LENGTH_SHORT).show();
                    //=====si tuvimos exito y generamos un token manda a llama lo demas========
                    //getListaNoticias(token);
                    getTitles();
                }
                else{
                    Toast.makeText(getContext(),"Fallo al agarrar token",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(getContext(),"Fallo de conexion",Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getContext(),"Conexion exitosa",Toast.LENGTH_SHORT).show();
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
                    //news_list.add(new News(titulo,game,imagen));//arreglo para cardviews
                    news_list.add(new News(id,titulo,body,game,date,imagen,description));//arreglo para noticia
                }

                CreandoCardViews();
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                Toast.makeText(getContext(),"fallo de recoleccion de datos",Toast.LENGTH_SHORT).show();

            }
        });

    }//getTitles






}//fragments News
