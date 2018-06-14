package com.luisro00005513.gamenews.Fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luisro00005513.gamenews.Adapters.ImagesAdapter;
import com.luisro00005513.gamenews.Adapters.PlayersAdapter;
import com.luisro00005513.gamenews.Classes.News;
import com.luisro00005513.gamenews.Classes.Players;
import com.luisro00005513.gamenews.R;

import java.util.ArrayList;

import static com.luisro00005513.gamenews.Activities.MainActivity.gameStk;
import static com.luisro00005513.gamenews.Activities.MainActivity.news_lists;
import static com.luisro00005513.gamenews.Activities.MainActivity.players_list;


public class Images extends Fragment {
    RecyclerView recyclerView;
    ArrayList<News> listaAux2 = new ArrayList<>();


    public Images() {
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
        View view = inflater.inflate(R.layout.fragment_images, container, false);

        //filtrando a las imagenes a partir del juego de noticia
        filtrado();
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_images);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ImagesAdapter imagesAdapter  = new ImagesAdapter(getContext(),listaAux2);
        recyclerView.setAdapter(imagesAdapter);


        return view;
    }

    private void filtrado(){
        for(int i = 0; i < news_lists.size(); i++){
            if(news_lists.get(i).getGame().equals(gameStk)){
                listaAux2.add(news_lists.get(i));
            }//if
        }//for
    }









    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
