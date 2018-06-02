package com.luisro00005513.gamenews.Adapters;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luisro00005513.gamenews.Classes.News;
import com.luisro00005513.gamenews.R;

import java.util.ArrayList;

/**
 * Created by luisro on 6/1/18.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapterViewHolder>{

    ArrayList<News> news_list;

    public NewsAdapter (ArrayList<News> news_list){
        this.news_list = news_list;
    }


    @NonNull
    @Override
    public NewsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View news_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_news, parent, false);
        return new NewsAdapterViewHolder(news_view);
    }


    @Override
    public void onBindViewHolder(@NonNull NewsAdapterViewHolder holder, int position){
        holder.description.setText(news_list.get(position).getDescription());
        holder.title.setText(news_list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return news_list.size();
    }



}
