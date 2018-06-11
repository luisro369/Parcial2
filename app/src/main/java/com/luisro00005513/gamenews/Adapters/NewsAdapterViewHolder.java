package com.luisro00005513.gamenews.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.luisro00005513.gamenews.Activities.GameInfo;
import com.luisro00005513.gamenews.Activities.MainActivity;
import com.luisro00005513.gamenews.Classes.News;
import com.luisro00005513.gamenews.R;

import java.util.ArrayList;

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
        int position = getAdapterPosition();
        News news = this.lista_completa.get(position);
        Intent intent = new Intent(this.context, GameInfo.class);
        intent.putExtra("id",news.getId());
        intent.putExtra("imagen",news.getCoverImage());
        intent.putExtra("title",news.getTitle());
        intent.putExtra("body",news.getBody());
        intent.putExtra("date",news.getCreatedDate());
        intent.putExtra("description",news.getDescription());
        intent.putExtra("game",news.getGame());
        this.context.startActivity(intent);

    }
}
