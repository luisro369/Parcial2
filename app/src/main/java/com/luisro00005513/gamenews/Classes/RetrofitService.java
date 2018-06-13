package com.luisro00005513.gamenews.Classes;


import android.support.annotation.Nullable;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**
 * Created by luisro on 6/3/18.
 */

//===========Esta interface nos va a ayudar con retrofit======

public interface RetrofitService {

    //metodo para poder logearme a la api
    @POST("/login")
    Call<Login> getToken(@Body Login login);

    //metodo para poder extraer noticias de la api
    @GET("/news")
    public Call<List<News>> getNews(@Query("title") String title, @Query("game") String game,
                                      @Query("_id") String id, @Query("body") String body,
                                      @Query("created_date") String date, @Query("coverImage") String image,
                                      @Query("description") String description);
    //metodo para poder extraer players de la api
    @GET("players")
    public Call<List<Players>> getPlayers(@Query("avatar") String avatar, @Query("_id") String id,
                                          @Query("name") String name, @Query("biografia") String biografia,
                                          @Query("game") String game
                                          );

}
