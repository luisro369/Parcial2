package com.luisro00005513.gamenews.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luisro00005513.gamenews.Classes.Players;
import com.luisro00005513.gamenews.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by luisro on 6/13/18.
 */

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapterViewHolder>{

    ArrayList<Players> players_lists;
    private Context context;

    public PlayersAdapter(Context context, ArrayList<Players> players_lists) {
        this.players_lists = players_lists;
        this.context = context;
    }

    @NonNull
    @Override
    public PlayersAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View player_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_players,parent,false);
        return new PlayersAdapterViewHolder(player_view,players_lists,context);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayersAdapterViewHolder holder, int position) {
        holder.game.setText(players_lists.get(position).getGame());
        holder.biografia.setText(players_lists.get(position).getBiografia());
        holder.name.setText(players_lists.get(position).getName());

        Picasso.with(context).load(players_lists.get(position).getAvatar()).into(holder.avatar);


    }

    @Override
    public int getItemCount() {
        return players_lists.size();
    }
}
