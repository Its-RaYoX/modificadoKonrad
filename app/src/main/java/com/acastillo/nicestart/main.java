package com.acastillo.nicestart;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;


public class main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView ola = findViewById(R.id.ola);
        registerForContextMenu(ola);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        final ConstraintLayout mLayout = findViewById(R.id.main);

        if (id == R.id.item) {
            Snackbar snackbar = Snackbar
                    .make(mLayout, "Copiando", Snackbar.LENGTH_LONG)
                    .setAction("UNDO", view -> {
                        Snackbar snackbar1 = Snackbar.make(mLayout, "Copia cancelada", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    });
            snackbar.show();
        } else if (id == R.id.item2) {
            Snackbar snackbar = Snackbar
                    .make(mLayout, "Descargando", Snackbar.LENGTH_LONG)
                    .setAction("UNDO", view -> {
                        Snackbar snackbar1 = Snackbar.make(mLayout, "Descarga cancelada", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    });
            snackbar.show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        final ConstraintLayout mLayout = findViewById(R.id.main);

        if (id == R.id.item) {
            Snackbar snackbar = Snackbar
                    .make(mLayout, "Copiando", Snackbar.LENGTH_LONG)
                    .setAction("UNDO", view -> {
                        Snackbar snackbar1 = Snackbar.make(mLayout, "Copia cancelada", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    });
            snackbar.show();
        } else if (id == R.id.item2) {
            Snackbar snackbar = Snackbar
                    .make(mLayout, "Descargando", Snackbar.LENGTH_LONG)
                    .setAction("UNDO", view -> {
                        Snackbar snackbar1 = Snackbar.make(mLayout, "Descarga cancelada", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    });
            snackbar.show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }
}
