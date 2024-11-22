package com.example.pagerview;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;  // Make sure this class exists or remove this line
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);  // Ensure this class is defined, or remove it
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                item.setChecked(true);
                drawerLayout.closeDrawer(GravityCompat.START);
                // Handle navigation item clicks here
                if (id == R.id.starTask) {
                                            replaceFragment(new AFragment());
                } else if (id == R.id.category) {
                                                 replaceFragment(new CategoryFragment());
                } else if (id == R.id.widget) {
                                                 replaceFragment(new WidgetFragment());
                } else if (id == R.id.language) {
                    // Handle "Language" action
                } else if (id == R.id.rateUs) {
                    // Handle "Rate Us" action
                } else if (id == R.id.share) {
                    // Handle "Share" action
                } else if (id == R.id.notificaionRemender) {
                    // Handle "Notification Reminder" action
                } else if (id == R.id.taskTone) {
                    // Handle "Task Tone" action
                } else {
                    Toast.makeText(MainActivity.this, "not permitted", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });  // Close setNavigationItemSelectedListener block
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}
