package com.house.domotic.my.mylogintest.views.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.house.domotic.my.mylogintest.views.home.chatactivos.ChatActivosFragment;
import com.house.domotic.my.mylogintest.views.home.friendrequest.FriendRequestFragment;
import com.house.domotic.my.mylogintest.views.home.listaamigos.ListaAmigosFragment;

public class HomePagerAdapter extends FragmentPagerAdapter {

    private ChatActivosFragment chatActivosFragment;
    private ListaAmigosFragment listaAmigosFragment;
    private FriendRequestFragment friendRequestFragment;

    public HomePagerAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if (chatActivosFragment == null) {
                    chatActivosFragment = ChatActivosFragment.newInstance();
                }
                return chatActivosFragment;

            case 1:
                if (listaAmigosFragment == null) {
                    listaAmigosFragment = ListaAmigosFragment.newInstance();
                }
                return listaAmigosFragment;

            case 2:
                if (friendRequestFragment == null) {
                    friendRequestFragment = FriendRequestFragment.newInstance();
                }
                return friendRequestFragment;

            default:
                return ChatActivosFragment.newInstance();



        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Chats Activos";

            case 1:
                return "Lista Amigos";

            case 2:
                return "Petitions";

            default:
                return "Chats Activos";


        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
