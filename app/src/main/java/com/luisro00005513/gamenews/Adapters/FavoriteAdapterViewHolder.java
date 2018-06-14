package com.luisro00005513.gamenews.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.luisro00005513.gamenews.Classes.News;
import com.luisro00005513.gamenews.R;

import java.util.ArrayList;

/**
 * Created by luisro on 6/14/18.
 */

public class FavoriteAdapterViewHolder extends RecyclerView.ViewHolder {

    TextView title;
    ImageView images;
    TextView game;
    ArrayList<News> lista_completa;
    Context context;


    public FavoriteAdapterViewHolder(View itemView,ArrayList<News> lista_completa, Context context) {
        super(itemView);
        this.lista_completa = lista_completa;
        this.context = context;


        game = (TextView) itemView.findViewById(R.id.favorite_game);
        title = (TextView) itemView.findViewById(R.id.favorite_title);
        images = (ImageView) itemView.findViewById(R.id.favorite_image);
    }
}
