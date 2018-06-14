package com.luisro00005513.gamenews.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.luisro00005513.gamenews.Classes.News;
import com.luisro00005513.gamenews.R;

import java.util.ArrayList;

/**
 * Created by luisro on 6/14/18.
 */

public class ImagesAdapterViewHolder extends RecyclerView.ViewHolder {

    ImageView imagenes;

    ArrayList<News> news_lists;
    Context context;


    public ImagesAdapterViewHolder(View itemView,ArrayList<News> news_lists , Context context) {
        super(itemView);
        this.context = context;
        this.news_lists = news_lists;

        imagenes = (ImageView)itemView.findViewById(R.id.images_image);
    }


}


