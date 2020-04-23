package net.austreelis.wishlisht;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.austreelis.wishlisht.Room.WishListRoomDatabase;
import net.austreelis.wishlisht.adapters.WishListAdapter;
import net.austreelis.wishlisht.entities.User;
import net.austreelis.wishlisht.entities.Wish;
import net.austreelis.wishlisht.entities.WishList;
import net.austreelis.wishlisht.interfaces.DAO.UserDao;
import net.austreelis.wishlisht.interfaces.DAO.WishListDao;
import net.austreelis.wishlisht.interfaces.NavBarInterface;

public class WishListCollectionActivity extends MainActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wishlist_collection_activity);
        RecyclerView recyclerView = findViewById(R.id.listContainer);

        /*final WishListAdapter adapter = new WishListAdapter(dataset);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));*/
    }

}
