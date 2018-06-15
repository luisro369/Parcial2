package com.luisro00005513.gamenews.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luisro00005513.gamenews.Adapters.FavoriteAdapter;
import com.luisro00005513.gamenews.Adapters.ImagesAdapter;
import com.luisro00005513.gamenews.R;

import static com.luisro00005513.gamenews.Activities.MainActivity.favorite_news;
import static com.luisro00005513.gamenews.Activities.MainActivity.news_lists;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteNews extends Fragment {

    RecyclerView recyclerView;

    public FavoriteNews() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite_news, container, false);



        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_favorites);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.GAP_HANDLING_NONE));
        FavoriteAdapter favoriteAdapter  = new FavoriteAdapter(getContext(),favorite_news);
        recyclerView.setAdapter(favoriteAdapter);

        return view;
    }

}
