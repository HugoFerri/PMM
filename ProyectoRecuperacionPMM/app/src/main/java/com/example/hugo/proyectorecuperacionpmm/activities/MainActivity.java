package com.example.hugo.proyectorecuperacionpmm.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hugo.proyectorecuperacionpmm.R;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_USER = 0;
    private String userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivityForResult(intent, REQUEST_USER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_USER) {
            if (resultCode == RESULT_OK) {
                userEmail = data.getStringExtra("email");
            }
        }
    }
}
