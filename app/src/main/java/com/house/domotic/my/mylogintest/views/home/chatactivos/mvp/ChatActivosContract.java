package com.house.domotic.my.mylogintest.views.home.chatactivos.mvp;

import com.house.domotic.my.mylogintest.views.home.chatactivos.ChatActivosAdapter;
import com.house.domotic.my.mylogintest.views.home.chatactivos.model.ChatActivosItemData;

import org.json.JSONArray;

import java.util.ArrayList;

public class ChatActivosContract {

    public interface  FriendInteractor{

        void chatActivosRecieve(JSONArray jsonArray);

    }


    public interface ChatResponse{

        void ChatActivosSuccess(ArrayList<ChatActivosItemData> mDataset);
        void ChatActivosFailed();

    }

    public interface OnChatDeleteResponse{

        void deleteChatActivosSuccess();
        void deleteChatActivosFailed();
    }

    public interface Presenter{

        void getChatActivos();
        void deleteChatActivos(int pos);

    }

    public interface View{

        void getChatActivosSuccess(ArrayList<ChatActivosItemData> mDataset);
        void getChatActivosFailed();
    }

}
