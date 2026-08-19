package com.example.academia;

import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setCheckedItem(R.id.it_home);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new Home())
                .commit();

        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.it_about) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new About())
                        .commit();
            } else if (id == R.id.it_department) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new Department())
                        .commit();
            } else if (id == R.id.it_events) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new Events())
                        .commit();
            } else if (id == R.id.it_contacts) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new Contact())
                        .commit();
            } else if (id == R.id.it_home) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new Home())
                        .commit();
            }
            drawerLayout.closeDrawers();
            return true;
        });
    }

}