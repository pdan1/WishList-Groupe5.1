package net.austreelis.wishlisht;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import net.austreelis.wishlisht.Room.WishListRoomDatabase;
import net.austreelis.wishlisht.entities.User;

public class ConnectActivity extends MainActivity{

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.connect_activity);
    Toolbar toolbar = findViewById(R.id.bigTitleToolbar);
    setSupportActionBar(toolbar);
  }

  public void register(View view){
    Intent intent = new Intent(this, RegisterActivity.class);
    startActivity(intent);
  }

  public void login(View view){
    User[] us = udao.loginUser(((TextView)findViewById(R.id.connectLoginField)).getText().toString(), ((TextView)findViewById(R.id.connectPasswordField)).getText().toString());

    if(us.length==0){
      generateError(R.string.errorLoginDenied);
      return;
    }

    u = us[0];
    navigateToWishLists(view);
  }
}
