package net.austreelis.wishlisht;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ConnectActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.connectActivity);
    Toolbar toolbar = findViewById(R.id.bigTitleToolbar);
    setSupportActionBar(toolbar);

  }
}
