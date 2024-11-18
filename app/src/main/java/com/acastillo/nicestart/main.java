package com.acastillo.nicestart;



import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import com.google.android.material.snackbar.Snackbar;


public class main extends AppCompatActivity {

    private SwipeRefreshLayout swipeLayout;
    private WebView miVisorWeb;

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
        miVisorWeb = (WebView) findViewById(R.id.vistaweb);
        WebSettings webSettings = miVisorWeb.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        miVisorWeb.loadUrl("https://www.google.com/url?sa=i&url=https%3A%2F%2Fcomicvine.gamespot.com%2Fforums%2Fbattles-7%2Fbase-luffy-vs-katakuri-2279496%2F&psig=AOvVaw26yfbxpGVl3MPHtZyK9Nvq&ust=1731668986960000&source=images&cd=vfe&opi=89978449&ved=0CBcQjhxqFwoTCOjs7-zX24kDFQAAAAAdAAAAABAE");

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);
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
    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast toast0 = Toast.makeText(main.this, "Hi there! I don't exist :)", Toast.LENGTH_LONG);
            toast0.show();
            miVisorWeb.reload();
            swipeLayout.setRefreshing(false);
        }
    };

}
