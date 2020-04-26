package net.austreelis.wishlisht;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import net.austreelis.wishlisht.Room.WishListRoomDatabase;
import net.austreelis.wishlisht.entities.User;
import net.austreelis.wishlisht.interfaces.DAO.UserDao;
import net.austreelis.wishlisht.interfaces.DAO.FriendshipDao;
import net.austreelis.wishlisht.interfaces.DialogBoxInterface;

abstract class MainActivity extends AppCompatActivity implements DialogBoxInterface {

    protected WishListRoomDatabase bdd;
    protected UserDao udao;

    protected User u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent it = getIntent();
        u = (new Gson()).fromJson(it.getStringExtra("user"), User.class);
        bdd = WishListRoomDatabase.getDatabase(this);
        udao = bdd.userDao();
    }

    public void generateError(int errorMsg){
        TextView dialogBox = (TextView)findViewById(R.id.dialogBox);
        dialogBox.setText(errorMsg);
        dialogBox.setTextColor(getResources().getColor(R.color.error));
    }

    public void generateSuccess(int successMsg){
        TextView dialogBox = (TextView)findViewById(R.id.dialogBox);
        dialogBox.setText(successMsg);
        dialogBox.setTextColor(getResources().getColor(R.color.success));
    }

    public void navigateToFriends(View view) {
        Intent intent = new Intent(this, FriendsListActivity.class);
        intent.putExtra("user", (new Gson()).toJson(u));
        startActivity(intent);
    }

    public void navigateToRequests(View view) {
        Intent intent = new Intent(this, AnswerRequestActivity.class);
        intent.putExtra("user", (new Gson()).toJson(u));
        startActivity(intent);
    }

    public void navigateToAddFriends(View view) {
        Intent intent = new Intent(this, FriendsActivity.class);
        intent.putExtra("user", (new Gson()).toJson(u));
        startActivity(intent);
    }

    public void navigateToProfile(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("user", (new Gson()).toJson(u));
        startActivity(intent);
    }

    public void navigateToWishLists(View view) {
        Intent intent = new Intent(this, WishListCollectionActivity.class);
        intent.putExtra("user", (new Gson()).toJson(u));
        startActivity(intent);
    }


}
