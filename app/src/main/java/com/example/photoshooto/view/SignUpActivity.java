package com.example.photoshooto.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.photoshooto.BottomNavigationActivity;
import com.example.photoshooto.R;


public class SignUpActivity extends AppCompatActivity {
Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signup=(Button)findViewById(R.id.login_button);
    }

    public void signUp(View view) {
        startActivity(new Intent(this, BottomNavigationActivity.class));
    }
}