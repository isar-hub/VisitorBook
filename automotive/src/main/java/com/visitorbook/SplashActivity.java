package com.visitorbook;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends Activity {

    // Set the duration of the splash screen in milliseconds (e.g., 10 seconds)
    private static final long SPLASH_DURATION = 3000; // 10 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        VideoView videoView = findViewById(R.id.videoView);
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash_video);

        // Set the video file to be played
        videoView.setVideoURI(videoUri);

        // Start playing the video
        videoView.start();

        // Use a handler to delay launching the main activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Create an Intent to start the main activity
                Intent mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(mainIntent);
                finish(); // Close the splash activity so it's not on the back stack
            }
        }, SPLASH_DURATION);
    }
}
