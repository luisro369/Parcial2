package com.luisro00005513.gamenews.Fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.luisro00005513.gamenews.R;
import com.squareup.picasso.Picasso;

import static com.luisro00005513.gamenews.Activities.MainActivity.players_list;


public class TopPlayers extends Fragment {

    TextView idTv,nameTv,bioTv,gameTv;
    ImageView avatarV;
    String imagen;

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
        nameTv = (TextView)view.findViewById(R.id.player_name);
        gameTv = (TextView)view.findViewById(R.id.player_game);
        bioTv = (TextView)view.findViewById(R.id.player_biografia);
        avatarV = (ImageView)view.findViewById(R.id.player_avatar);

        nameTv.setText(players_list.get(3).getName());
        gameTv.setText(players_list.get(3).getGame());
        bioTv.setText(players_list.get(3).getBiografia());
        imagen = players_list.get(3).getAvatar();
        Picasso.with(getContext()).load(imagen).into(avatarV);


        return view;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
