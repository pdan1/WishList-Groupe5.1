package net.austreelis.wishlisht;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.widget.Toolbar;

import net.austreelis.wishlisht.Room.WishListRoomDatabase;
import net.austreelis.wishlisht.entities.User;
import net.austreelis.wishlisht.interfaces.DAO.FriendshipDao;

import java.util.ArrayList;

public class AnswerRequestActivity extends MainActivity {
    User[] users;
    ArrayList<String> pending;
    ArrayList<String> all;
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapterAll;
    ListView list;
    ListView listAll;
    protected FriendshipDao friendshipDao;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_answer_request);
        Toolbar toolbar = findViewById(R.id.bigTitleToolbar);

        bdd = WishListRoomDatabase.getDatabase(this);
        friendshipDao = bdd.friendshipDao();

        setSupportActionBar(toolbar);

        list = findViewById(R.id.listOfRequests);
        listAll = findViewById(R.id.allUsers);

        pending = new ArrayList<>();
        all = new ArrayList<>();

        users = this.udao.loadAllUsers();

        list.setClickable(true);
        list.setOnItemClickListener((arg0, arg1, position, arg3) -> {
            Object o = list.getItemAtPosition(position);
            System.out.println(o.toString());
            friendshipDao.setFriendStatus(u.getUserid(),o.toString(),"approved");
        });

        for (User user : users) {
            if(friendshipDao.loadFriendshipStatus(u.getName(), user.getName()).equals("pending")) {
                pending.add(user.getName());
            }
        }
        adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                pending);
        list.setAdapter(adapter);

        for (User user : users) {
            all.add(user.getName().concat((u.getName().equals(user.getName()))?" (you)":""));
        }
        adapterAll=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                all);
        listAll.setAdapter(adapterAll);
    }

    public void answer(View view) {

    }
}
