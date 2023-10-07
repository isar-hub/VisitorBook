package com.visitorbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.visitorbook.Models.NewUser;
import com.visitorbook.Models.user;
import com.visitorbook.Service.ApiService;
import com.visitorbook.Service.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class LoginActivity extends Activity {

    String TAG = getClass().toString();
    ProgressBar progressBar;
    EditText userName, password;

    Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Set the layout for this activity

        userName = findViewById(R.id.usernameEditText);
        password = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        progressBar =findViewById(R.id.progress);



    loginButton.setOnClickListener(view -> {
        progressBar.setVisibility(View.VISIBLE);

        int userId = Integer.parseInt(userName.getText().toString());//70236
        long pass = Long.parseLong(password.getText().toString());//887744558877
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Perform your network request here
                // Make sure to update the UI on the main thread when needed
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ApiCall(userId,pass);
                        // Update UI components with the network response
                    }
                });
            }
        }).start();

    });

    }


    public void ApiCall(int userId,long password) {
        // Replace these values with the actual user ID and password


        Call<user> userCall = RetrofitClient.getmClient().getApi().getEmployeeData(userId, password);


        userCall.enqueue(new Callback<user>() {
            @Override
            public void onResponse(Call<user> call, Response<user> response) {
               if (response.isSuccessful()){

                   Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                   intent.putExtra("userId",response.body().getNewUser().getUserId());
                   intent.putExtra("name",response.body().getNewUser().getName());
                   intent.putExtra("email",response.body().getNewUser().getEmail());
                   startActivity(intent);
               }
               else {
                   Toast.makeText(getApplicationContext(),"Invalid User Id and Password",Toast.LENGTH_LONG).show();
               }

            }

            @Override
            public void onFailure(Call<user> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Invalid User Id and Password",Toast.LENGTH_LONG).show();
                // Handle the failure
            }
        });

    }

}
