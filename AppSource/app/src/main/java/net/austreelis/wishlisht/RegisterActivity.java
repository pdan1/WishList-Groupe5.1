package net.austreelis.wishlisht;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends MainActivity {

    private String login, email, password1, password2, emailCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity_base_info);
        Toolbar toolbar = findViewById(R.id.bigTitleToolbar);
        setSupportActionBar(toolbar);
    }

    public void provideBaseInfo(View view){

        this.login = ((EditText) findViewById(R.id.registerLoginField)).getText().toString();
        this.email = ((EditText) findViewById(R.id.registerEmailField)).getText().toString();

        if(this.login.equals("")||this.email.equals("")){
            this.generateError(R.string.errorMandatory);
            return;
        }

        setContentView(R.layout.register_activity_email_check);

    }

    public void provideEmailCheckCode(View view){

        // Code logic missing, need for a imap server
        // Faking success
        this.emailCode = ((EditText) findViewById(R.id.emailCheckCodeField)).getText().toString();
        if(this.emailCode.equals("")){
            this.generateError(R.string.errorMandatory);
            return;
        }
        setContentView(R.layout.register_activity_pass);

    }

    public void providePasswords(View view){

        this.password1 = ((EditText) findViewById(R.id.registerFirstPasswordField)).getText().toString();
        this.password2 = ((EditText) findViewById(R.id.registerSecondPasswordField)).getText().toString();

        if(this.password1.equals("")){
            this.generateError(R.string.errorMandatory);
            return;
        }

        if(!this.password1.equals(this.password2)){
            this.generateError(R.string.errorNoMatch);
            return;
        }

        setContentView(R.layout.profile_activity);

    }
}
