package net.austreelis.wishlisht;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import net.austreelis.wishlisht.interfaces.NavBarInterface;

public class ProfileActivity extends MainActivity implements NavBarInterface {
    private String login, email, password1, password2, picturePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
    }

    public void resetData(View view){

    }

    public void saveData(View view){

    }

    public void changePic(View view){

    }

    @Override
    public void navigateToFriends(View view) {
        return;
    }

    @Override
    public void navigateToProfile(View view) {

    }

    @Override
    public void navigateToWishLists(View view) {
        return;
    }

}
