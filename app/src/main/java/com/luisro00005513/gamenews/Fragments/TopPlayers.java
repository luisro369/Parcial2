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
import com.luisro00005513.gamenews.Classes.Players;
import com.luisro00005513.gamenews.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.luisro00005513.gamenews.Activities.MainActivity.gameStk;
import static com.luisro00005513.gamenews.Activities.MainActivity.players_list;


public class TopPlayers extends Fragment {

    //TextView idTv,nameTv,bioTv,gameTv;
    //ImageView avatarV;
    String imagen;
    RecyclerView recyclerView;
    ArrayList<Players> listaAux = new ArrayList<>();

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

        //filtrando a los jugadores a partir del juego de noticia
        filtrado();
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_players);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        PlayersAdapter playersAdapter = new PlayersAdapter(getContext(),listaAux);//modifique esto
        recyclerView.setAdapter(playersAdapter);


        return view;
    }//oncreateview

    private void filtrado(){
        for(int i = 0; i < players_list.size(); i++){
            if(players_list.get(i).getGame().equals(gameStk)){
                listaAux.add(players_list.get(i));
            }//if
        }//for
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}//topPlayers
