package net.austreelis.wishlisht;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.google.gson.Gson;

import net.austreelis.wishlisht.Room.WishListRoomDatabase;
import net.austreelis.wishlisht.entities.User;
import net.austreelis.wishlisht.interfaces.DAO.UserDao;
import net.austreelis.wishlisht.interfaces.NavBarInterface;

public class ProfileActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.profile_activity);

        ((TextView)findViewById(R.id.loginField)).setText(u.getName());
        ((TextView)findViewById(R.id.emailField)).setText(u.getEmail());
        ((TextView)findViewById(R.id.addressField)).setText(u.getAddress());
        ((TextView)findViewById(R.id.sizeField)).setText(u.getAddress());
        ((TextView)findViewById(R.id.colorField)).setText(u.getColor());
        ((TextView)findViewById(R.id.firstInterestField)).setText(u.getInterest1());
        ((TextView)findViewById(R.id.secondInterestField)).setText(u.getInterest2());
        ((TextView)findViewById(R.id.thirdInterestField)).setText(u.getInterest3());

    }

    public void resetData(View view){

        u = udao.loadUser(u.getUserid())[0];
        ((TextView)findViewById(R.id.loginField)).setText(u.getName());
        ((TextView)findViewById(R.id.emailField)).setText(u.getEmail());
        ((TextView)findViewById(R.id.addressField)).setText(u.getAddress());
        ((TextView)findViewById(R.id.sizeField)).setText(u.getSize());
        ((TextView)findViewById(R.id.colorField)).setText(u.getColor());
        ((TextView)findViewById(R.id.firstInterestField)).setText(u.getInterest1());
        ((TextView)findViewById(R.id.secondInterestField)).setText(u.getInterest2());
        ((TextView)findViewById(R.id.thirdInterestField)).setText(u.getInterest3());

    }

    public void saveData(View view){

        String tmppass = ((TextView)findViewById(R.id.passwordField)).getText().toString();
        String newpass = ((TextView)findViewById(R.id.newPasswordField)).getText().toString();

        if(tmppass.equals("")){generateError(R.string.errorPasswordMissing);return;}
        if(!tmppass.equals(u.getPassword())){generateError(R.string.errorLoginDenied);return;}

        if(!newpass.equals("")){u.setPassword(newpass);}

        u.setName(((TextView)findViewById(R.id.loginField)).getText().toString());
        u.setEmail(((TextView)findViewById(R.id.emailField)).getText().toString());
        u.setAddress(((TextView)findViewById(R.id.addressField)).getText().toString());
        u.setSize(((TextView)findViewById(R.id.sizeField)).getText().toString());
        u.setColor(((TextView)findViewById(R.id.colorField)).getText().toString());
        u.setInterest1(((TextView)findViewById(R.id.firstInterestField)).getText().toString());
        u.setInterest2(((TextView)findViewById(R.id.secondInterestField)).getText().toString());
        u.setInterest3(((TextView)findViewById(R.id.thirdInterestField)).getText().toString());

        int res = udao.updateUser(u);

        if(res>0)this.generateSuccess(R.string.successUpdate);
        else this.generateError(R.string.errorOccuredUpdate);
    }

    public void changePic(View view){

    }


}
