package com.luisro00005513.gamenews.Classes;


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

public interface NewsService {

    @POST("/login")
    Call<Login> getToken(@Body Login login);


    @GET("/news")
    public Call<List<News>> getTitles(@Query("title") String title, @Query("game") String game,
                                      @Query("_id") String id, @Query("body") String body,
                                      @Query("created_date") String date, @Query("coverImage") String image,
                                      @Query("description") String description);

}
