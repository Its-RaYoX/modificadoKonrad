package com.acastillo.nicestart;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // Inicializamos la ImageView dentro de onCreate
        ImageView mLuffy = findViewById(R.id.luffy);

        // Usamos Glide para cargar una imagen en mLuffy
        Glide.with(this)
                .load("https://opbr-en.bn-ent.net/assets/data/webp/character/0005_2d.png.webp") // o usa una URL si lo prefieres
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.green)))
                .centerCrop()
                .into(mLuffy);



        // Ajustamos los Insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Método para abrir la actividad de registro
    public void openSignup(View v) {
        Intent intent = new Intent(this, sign_up.class);
        startActivity(intent);
    }

    // Método para ir a la pantalla principal
    public void loginToMain(View view) {
        Intent intent = new Intent(this, main.class);
        startActivity(intent);
    }
}
