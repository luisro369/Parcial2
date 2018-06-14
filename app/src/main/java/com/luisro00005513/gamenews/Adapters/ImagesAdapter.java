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

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapterViewHolder>{

    ArrayList<News> news_lists;
    private Context context;

    public ImagesAdapter(Context context,ArrayList<News> news_lists) {
        this.news_lists = news_lists;
        this.context = context;
    }

    @NonNull
    @Override
    public ImagesAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View image_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_images,parent,false);
        return new ImagesAdapterViewHolder(image_view,news_lists,context);
    }

    @Override
    public void onBindViewHolder(@NonNull ImagesAdapterViewHolder holder, int position) {

        Picasso.with(context).load(news_lists.get(position).getCoverImage()).into(holder.imagenes);


    }

    @Override
    public int getItemCount() {
        return news_lists.size();
    }
}
