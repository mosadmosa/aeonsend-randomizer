package com.example.honza.aeonsend;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.honza.aeonsend.fragments.CharactersFragment;
import com.example.honza.aeonsend.fragments.ExpansionFragment;
import com.example.honza.aeonsend.fragments.MarketFragment;
import com.example.honza.aeonsend.fragments.NemesisFragment;
import com.example.honza.aeonsend.fragments.PlayersFragment;
import com.example.honza.aeonsend.fragments.SetupFragment;

/**
 * Created by honza on 21.9.17.
 */

//Extending FragmentStatePagerAdapter
public class MainPager extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public MainPager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount = tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                PlayersFragment playersFragment = new PlayersFragment();
                return playersFragment;
            case 1:
//                PlayersFragment playersFragment2 = new PlayersFragment();
//                return playersFragment2;
                ExpansionFragment expansionFragment = new ExpansionFragment();
                return expansionFragment;
            case 2:
                SetupFragment setupFragment = new SetupFragment();
                return setupFragment;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}