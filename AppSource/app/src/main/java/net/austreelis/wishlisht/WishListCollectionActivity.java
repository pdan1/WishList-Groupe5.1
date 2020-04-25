package net.austreelis.wishlisht;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WishListCollectionActivity extends MainActivity {

    protected ArrayList<WishList> loadedWishLists;
    protected WishListDao wldao;
    protected PopupWindow popup;
    public RecyclerView recyclerView;
    protected WishListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wishlist_collection_activity);

        recyclerView = findViewById(R.id.listContainer);
        wldao = bdd.wishListDao();

        loadedWishLists = new ArrayList<WishList>(Arrays.asList(wldao.loadWishListsFromUser(ou.getUserid())));

        adapter = new WishListAdapter(loadedWishLists, u, ou, wldao);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void showPopup(View view){
        popup = this.showPopup(view, R.layout.wishlist_creation_popup, false);
    }

    public void addWishList(View view){

        View popupView = popup.getContentView();

        // Load ui data
        WishList createdWishList = new WishList(((TextView) popupView.findViewById(R.id.wishListName)).getText().toString(), u.getUserid(),((TextView) popupView.findViewById(R.id.wishListDesc)).getText().toString());

        // Check fields not empty
        if(createdWishList.getDesc().equals("")||createdWishList.getName().equals("")){generateError(R.string.errorMandatory);return;}

        // Check for already registered entries
        if(loadedWishLists.contains(createdWishList)){generateError(R.string.errorAlreadyExists);return;}

        // Insert in both bdd and ui memory
        wldao.insert(createdWishList);
        loadedWishLists.add(createdWishList);

        // Updating ui state
        popup.dismiss();
        adapter.updateDataSet(loadedWishLists);
        generateSuccess(R.string.successCreation);
    }


}
