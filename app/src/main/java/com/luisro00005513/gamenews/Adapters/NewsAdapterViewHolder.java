package com.luisro00005513.gamenews.Adapters;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.luisro00005513.gamenews.Classes.News;
import com.luisro00005513.gamenews.Classes.Players;
import com.luisro00005513.gamenews.Fragments.FragmentContainer;
import com.luisro00005513.gamenews.R;

import java.util.ArrayList;

import static com.luisro00005513.gamenews.Activities.MainActivity.bodyStk;
import static com.luisro00005513.gamenews.Activities.MainActivity.desciptionStk;
import static com.luisro00005513.gamenews.Activities.MainActivity.favorite_news;
import static com.luisro00005513.gamenews.Activities.MainActivity.gameStk;
import static com.luisro00005513.gamenews.Activities.MainActivity.imagenStk;

/**
 * Created by luisro on 6/1/18.
 */

class NewsAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView title;
    ImageView images;
    TextView game;
    ArrayList<News> lista_completa;
    Context context;


    public NewsAdapterViewHolder(View itemView, ArrayList<News> lista_completa, Context context) {
        super(itemView);
        this.lista_completa = lista_completa;
        this.context = context;

        //codigo para hacer clicable el cardview
        itemView.setOnClickListener(this);

        game = (TextView) itemView.findViewById(R.id.news_game);
        title = (TextView) itemView.findViewById(R.id.news_title);
        images = (ImageView) itemView.findViewById(R.id.news_image);



    }


    @Override
    public void onClick(View v) {
        Toast.makeText(context,"Noticia añadida a favoritos",Toast.LENGTH_SHORT).show();
        int position = getAdapterPosition();
        News news = this.lista_completa.get(position);
        favorite_news.add(this.lista_completa.get(position));
        //al dar click setear variables globales con los  valores recogidos
        //------------generals---------------
        gameStk = news.getGame();
        imagenStk = news.getCoverImage();
        desciptionStk = news.getDescription();
        bodyStk = news.getBody();

        FragmentTransaction fr = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
        fr.addToBackStack(null);
        fr.replace(R.id.fragment_padre,new FragmentContainer());

        fr.commit();



    }
}
