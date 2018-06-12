package com.luisro00005513.gamenews.Fragments;

import android.content.Context;
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


public class Generals extends Fragment {
    TextView idTv,titleTv,bodyTv,dateTv,descriptionTv,gameTv;
    ImageView imagenV;
    String imagen;

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
        //llenando con datos de bundle de viewHolder
        gameTv = (TextView)view.findViewById(R.id.fragment_game);
        descriptionTv = (TextView)view.findViewById(R.id.fragment_description);
        bodyTv = (TextView)view.findViewById(R.id.fragment_body);
        imagenV = (ImageView)view.findViewById(R.id.fragment_image);

        if(savedInstanceState != null){
            //aca seteo lo recibido en bundle al fragmento
            gameTv.setText(getArguments().getString("game"));
            descriptionTv.setText(getArguments().getString("description"));
            bodyTv.setText(getArguments().getString("body"));
            imagen = getArguments().getString("imagen");
            Picasso.with(getContext()).load(imagen).into(imagenV);
            return view;
        }

        else{
            gameTv.setText("lamentablemente usted no puede pasar datos desde fragment");
            descriptionTv.setText("da lastima");
            bodyTv.setText("suicidese");
            return view;

        }

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
