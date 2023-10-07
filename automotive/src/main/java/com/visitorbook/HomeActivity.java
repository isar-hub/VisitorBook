package com.visitorbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.button.MaterialButton;

public class HomeActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); // Set the layout for this activity


        TextView name = findViewById(R.id.name);
        TextView email = findViewById(R.id.email);
        TextView userId = findViewById(R.id.user);


        Intent intent = getIntent();

        // Check if the Intent has extras
        if (intent != null && intent.hasExtra("userId") && intent.hasExtra("name") && intent.hasExtra("email")) {
            // Retrieve data from the Intent extras
            userId.setText("UserId : "+intent.getStringExtra("userId"));
            name.setText("Name : "+intent.getStringExtra("name"));
            email.setText("e-mail : "+intent.getStringExtra("email"));
            // Now you can use 'userId', 'name', and 'email' in your activity as needed
        }


    }

    // Other lifecycle methods like onStart, onResume, onPause, onStop, onDestroy can be overridden here
}
