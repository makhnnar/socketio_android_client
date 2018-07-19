package com.house.domotic.my.mylogintest.views.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.house.domotic.my.mylogintest.views.home.chatactivos.ChatActivosFragment;
import com.house.domotic.my.mylogintest.views.home.listaamigos.ListaAmigosFragment;

public class HomePagerAdapter extends FragmentPagerAdapter {

    private ChatActivosFragment chatActivosFragment;
    private ListaAmigosFragment listaAmigosFragment;

    public HomePagerAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            if (chatActivosFragment == null) {
                chatActivosFragment = ChatActivosFragment.newInstance();
            }
            return chatActivosFragment;
        } else if (position == 1) {
            if (listaAmigosFragment == null) {
                listaAmigosFragment = ListaAmigosFragment.newInstance();
            }
            return listaAmigosFragment;

        } else {
            return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Chats Activos";

            case 1:
                return "Lista Amigos";

            default:
                return "Chats Activos";


        }

    }

    @Override
    public int getCount() {
        return 2;
    }
}
