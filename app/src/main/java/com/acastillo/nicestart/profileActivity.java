package com.acastillo.nicestart;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class profileActivity extends AppCompatActivity { // Cambié el nombre a "ProfileActivity"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile); // Asegúrate de que el nombre del layout sea correcto
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView mImagen = findViewById(R.id.perfil);

        Glide.with(this)
                .load("https://preview.redd.it/w2xgfjroo9e51.png?auto=webp&s=4e3cf3ecb3ab58a16fc6eae303f320be4d9c2539")
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                .circleCrop()
                .into(mImagen);
    }
    public void salir(View v){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }
}
