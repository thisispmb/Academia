package com.example.academia;

import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        // Connect toolbar with navigation drawer
        toolbar = findViewById(R.id.toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer
        );

        // Listen for changes to the drawer
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Set initial Fragment if no saved state
        if (savedInstanceState == null) {
            navigationView.setCheckedItem(R.id.it_home);
            showFragment(new HomeFragment(), "Home");
        }

        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.it_home) {
                showFragment(new HomeFragment(), "Home");
            } else if (id == R.id.it_about) {
                showFragment(new AboutFragment(), "About");
            } else if (id == R.id.it_department) {
                showFragment(new DepartmentFragment(), "Department");
            } else if (id == R.id.it_events) {
                showFragment(new EventsFragment(), "Events");
            } else if (id == R.id.it_contacts) {
                showFragment(new ContactsFragment(), "Contacts");
            }

            // Closing the drawer after user selected a menu
            drawerLayout.closeDrawers();
            return true;
        });
    }

    private void showFragment(Fragment fragment, String title) {
        // Replace current Fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
        toolbar.setTitle(title);
    }

}