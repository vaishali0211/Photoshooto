package com.example.photoshooto.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.photoshooto.R;

import static com.example.photoshooto.R.layout.action_bar_layout;

public class LoginActivity extends AppCompatActivity {
Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=(Button)findViewById(R.id.login_button);
    }

    @SuppressLint("WrongConstant")
    public void loginButton(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);

//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(action_bar_layout);
    }
}