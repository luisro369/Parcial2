package com.luisro00005513.gamenews.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.luisro00005513.gamenews.Classes.News;
import com.luisro00005513.gamenews.Fragments.FragmentContainer;
import com.luisro00005513.gamenews.Fragments.Generals;
import com.luisro00005513.gamenews.R;

import java.util.ArrayList;

/**
 * Created by luisro on 6/1/18.
 */

class NewsAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    android.support.v4.app.Fragment fragmentoViejo;
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
        int position = getAdapterPosition();
        News news = this.lista_completa.get(position);
        FragmentTransaction fr = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
        fr.addToBackStack(null);
        fr.replace(R.id.fragment_padre,new FragmentContainer());
        Bundle bundle = new Bundle();
        bundle.putString("id",news.getId());
        bundle.putString("imagen",news.getCoverImage());
        bundle.putString("title",news.getTitle());
        bundle.putString("body",news.getBody());
        bundle.putString("date",news.getCreatedDate());
        bundle.putString("description",news.getDescription());
        bundle.putString("game",news.getGame());
        Generals generals = new Generals();
        generals.setArguments(bundle);
        fr.commit();
        /*
        Intent intent = new Intent(this.context, GameInfo.class);
        intent.putExtra("id",news.getId());
        intent.putExtra("imagen",news.getCoverImage());
        intent.putExtra("title",news.getTitle());
        intent.putExtra("body",news.getBody());
        intent.putExtra("date",news.getCreatedDate());
        intent.putExtra("description",news.getDescription());
        intent.putExtra("game",news.getGame());
        this.context.startActivity(intent);
        */

    }
}
