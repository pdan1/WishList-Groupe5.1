package net.austreelis.wishlisht;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.austreelis.wishlisht.Room.WishListRoomDatabase;
import net.austreelis.wishlisht.adapters.RequestAdapter;
import net.austreelis.wishlisht.entities.User;
import net.austreelis.wishlisht.interfaces.DAO.FriendshipDao;

import java.util.ArrayList;

public class AnswerRequestActivity extends MainActivity {
    User[] users;
    ArrayList<User> pending;
    RequestAdapter adapter;
    RecyclerView list;
    protected FriendshipDao friendshipDao;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_answer_request);
        Toolbar toolbar = findViewById(R.id.bigTitleToolbar);

        bdd = WishListRoomDatabase.getDatabase(this);
        friendshipDao = bdd.friendshipDao();

        setSupportActionBar(toolbar);

        list = findViewById(R.id.listOfRequests);

        pending = new ArrayList<>();

        users = this.udao.loadAllUsers();

        for (User user : users) {
            String friendship = friendshipDao.loadFriendshipStatus(u.getName(), user.getName());
            if(friendship != null && friendship.equals("pending")) {
                pending.add(user);
            }
        }
        adapter=new RequestAdapter(pending);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    public void accept(View view) {
        System.out.println("accept pressed");
    }
    public void deny(View view) {
        System.out.println("deny pressed");
    }
}
