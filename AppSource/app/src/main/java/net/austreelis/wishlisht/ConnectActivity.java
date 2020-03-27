package net.austreelis.wishlisht;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ConnectActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.connectActivity);
    Toolbar toolbar = findViewById(R.id.bigTitleToolbar);
    setSupportActionBar(toolbar);

    // Handle click on login button
    findViewById(R.id.connectLoginButton).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Log.d(String.valueOf(R.string.appName), "login button clickety click");
      }
    });
  }
}
