package net.austreelis.wishlisht;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ConnectActivity extends AppCompatActivity {

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

}
