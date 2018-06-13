package com.luisro00005513.gamenews.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.luisro00005513.gamenews.Fragments.Generals;
import com.luisro00005513.gamenews.Fragments.Images;
import com.luisro00005513.gamenews.Fragments.TopPlayers;

/**
 * Created by luisro on 5/31/18.
 */

public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

    int numTabs;


    public FragmentPagerAdapter(FragmentManager fm, int numeroDeTabs) {
        super(fm);
        this.numTabs = numeroDeTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Generals tab1 = new Generals();
                return tab1;
            case 1:
                TopPlayers tab2 = new TopPlayers();
                return tab2;
            case 2:
                Images tab3 = new Images();
                return tab3;
            default:
                return null;
        }//switch
    }



    @Override
    public int getCount() {
        return numTabs;
    }
}
