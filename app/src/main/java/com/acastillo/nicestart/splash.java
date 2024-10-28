package com.acastillo.nicestart;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class splash extends AppCompatActivity {
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView aka = findViewById(R.id.logo);
        TextView studio = findViewById(R.id.studio);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.blink);
        aka.startAnimation(anim);
        studio.startAnimation(anim);

        openApp();
    }

    private void openApp() {

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> {
            Intent intent = new Intent(splash.this, login.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }, 5000);
    }
}
