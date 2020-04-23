package net.austreelis.wishlisht;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import net.austreelis.wishlisht.Room.WishListRoomDatabase;
import net.austreelis.wishlisht.entities.User;
import net.austreelis.wishlisht.interfaces.DAO.UserDao;
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

    public void showPopup(View view, int popupid, boolean isJustMessage) {

        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(popupid, null);

        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        if(isJustMessage) {
            popupView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    popupWindow.dismiss();
                    return true;
                }
            });
        }

        popupView.findViewById(R.id.closePopupButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

}
