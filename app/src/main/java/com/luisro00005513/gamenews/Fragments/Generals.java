package com.luisro00005513.gamenews.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.luisro00005513.gamenews.R;


public class Generals extends Fragment {
    TextView id,imagen,title,body,date,description,game;

    public Generals() {
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
        View view = inflater.inflate(R.layout.fragment_generals,container,false);
        //llenando con datos de bundle de actividad Gameinfo
        game = (TextView)getActivity().findViewById(R.id.fragment_game);
        description = (TextView)getActivity().findViewById(R.id.fragment_description);
        body = (TextView)getActivity().findViewById(R.id.fragment_body);

        game.setText("HOLLAAAAAAAAAA");
        /*
        game.setText(getArguments().getString("game"));
        description.setText(getArguments().getString("description"));
        body.setText(getArguments().getString("body"));
        */
        return view;

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
