package com.luisro00005513.gamenews.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.luisro00005513.gamenews.Classes.Players;
import com.luisro00005513.gamenews.R;

import java.util.ArrayList;

import static com.luisro00005513.gamenews.Activities.MainActivity.players_list;

/**
 * Created by luisro on 6/13/18.
 */

public class PlayersAdapterViewHolder extends RecyclerView.ViewHolder {

    TextView game,biografia,name;
    ImageView avatar;

    ArrayList<Players> players_lists;
    Context context;

    public PlayersAdapterViewHolder(View itemView, ArrayList<Players> players_lists, Context context) {
        super(itemView);
        this.players_lists = players_lists;
        this.context = context;

        game = (TextView) itemView.findViewById(R.id.player_game);
        biografia = (TextView) itemView.findViewById(R.id.player_biografia);
        name = (TextView) itemView.findViewById(R.id.player_name);
        avatar = (ImageView) itemView.findViewById(R.id.player_avatar);

    }

}
