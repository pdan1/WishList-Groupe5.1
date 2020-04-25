package net.austreelis.wishlisht;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.google.gson.Gson;

import java.io.Console;
import java.util.List;
import java.util.ArrayList;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.sql.*;
import androidx.room.Query;

import net.austreelis.wishlisht.Room.WishListRoomDatabase;
import net.austreelis.wishlisht.entities.Friendship;
import net.austreelis.wishlisht.interfaces.DAO.FriendshipDao;
import net.austreelis.wishlisht.interfaces.DAO.UserDao;
import net.austreelis.wishlisht.interfaces.NavBarInterface;

public class FriendsListActivity extends MainActivity {

    ListView listView;
    List list = new ArrayList();
    ArrayAdapter adapter;
    protected FriendshipDao fdao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bdd = WishListRoomDatabase.getDatabase(this);
        fdao = bdd.friendshipDao();

        setContentView(R.layout.friendlist);

        listView = (ListView)findViewById(R.id.FList);

        String[] FList1 = fdao.loadFriendsWithStatus1(u.getUserid());
        for (int i = 0; i < FList1.length; i++) {
            list.add(FList1[i]);
        }


        String[] FList2 = fdao.loadFriendsWithStatus2(u.getUserid());
        for (int i = 0; i < FList2.length; i++) {
            list.add(FList2[i]);
        }

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

    }

}
