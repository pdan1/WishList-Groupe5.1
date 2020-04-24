package net.austreelis.wishlisht;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.widget.Toolbar;

import net.austreelis.wishlisht.Room.WishListRoomDatabase;
import net.austreelis.wishlisht.entities.User;
import net.austreelis.wishlisht.interfaces.DAO.FriendshipDao;

import java.util.ArrayList;

public class AnswerRequestActivity extends MainActivity {
    User[] users;
    ArrayList<String> pending= new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView list = findViewById(R.id.listOfRequests);
    protected FriendshipDao friendshipDao;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_answer_request);
        Toolbar toolbar = findViewById(R.id.bigTitleToolbar);
        bdd = WishListRoomDatabase.getDatabase(this);
        friendshipDao = bdd.friendshipDao();
        setSupportActionBar(toolbar);
    }

    public void answer(View view) {
        // Check si on a une demande d'ami
        users = this.udao.loadAllUsers();
        for (User user : users) {
            if(friendshipDao.loadFriendshipStatus(u.getName(), user.getName())[0] == "pending") {
                pending.add(user.getName());
            }
        }
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                pending);
        list.setAdapter(adapter);
        // Répondre
    }
}
