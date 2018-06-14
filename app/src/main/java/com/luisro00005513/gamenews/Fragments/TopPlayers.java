package com.luisro00005513.gamenews.Fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.luisro00005513.gamenews.Adapters.PlayersAdapter;
import com.luisro00005513.gamenews.R;
import com.squareup.picasso.Picasso;

import static com.luisro00005513.gamenews.Activities.MainActivity.players_list;


public class TopPlayers extends Fragment {

    //TextView idTv,nameTv,bioTv,gameTv;
    //ImageView avatarV;
    String imagen;
    RecyclerView recyclerView;

    public TopPlayers() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_players, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_players);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        PlayersAdapter playersAdapter = new PlayersAdapter(getContext(),players_list);//modifique esto
        recyclerView.setAdapter(playersAdapter);


        return view;
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
