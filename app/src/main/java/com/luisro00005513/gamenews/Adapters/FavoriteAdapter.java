package com.luisro00005513.gamenews.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luisro00005513.gamenews.Classes.News;
import com.luisro00005513.gamenews.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by luisro on 6/14/18.
 */

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapterViewHolder>  {

    ArrayList<News> news_list;
    private Context context;

    public FavoriteAdapter(Context context,ArrayList<News> news_list) {
        this.news_list = news_list;
        this.context = context;
    }

    @NonNull
    @Override
    public FavoriteAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View news_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_favorites, parent, false);
        return new FavoriteAdapterViewHolder(news_view,news_list,context);
    }

    @Override
    public void onBindViewHolder(FavoriteAdapterViewHolder holder, int position) {
        holder.game.setText(news_list.get(position).getGame());
        holder.title.setText(news_list.get(position).getTitle());
        //holder.image.setImageURI();
        Picasso.with(context).load(news_list.get(position).getCoverImage()).into(holder.images);

    }

    @Override
    public int getItemCount() {
        return news_list.size();
    }
}
