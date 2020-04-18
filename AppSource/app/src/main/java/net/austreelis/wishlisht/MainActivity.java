package net.austreelis.wishlisht;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.austreelis.wishlisht.interfaces.DialogBoxInterface;

public class MainActivity extends AppCompatActivity implements DialogBoxInterface {

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


}
