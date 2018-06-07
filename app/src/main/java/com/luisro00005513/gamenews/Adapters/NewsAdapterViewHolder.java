package com.luisro00005513.gamenews.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.luisro00005513.gamenews.R;

/**
 * Created by luisro on 6/1/18.
 */

class NewsAdapterViewHolder extends RecyclerView.ViewHolder {

    TextView title;
    ImageView image;
    TextView game;

    public NewsAdapterViewHolder(View itemView) {
        super(itemView);

        game = (TextView) itemView.findViewById(R.id.news_game);
        title = (TextView) itemView.findViewById(R.id.news_title);
        image = (ImageView) itemView.findViewById(R.id.news_image);



    }


}
