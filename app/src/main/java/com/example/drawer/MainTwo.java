package com.example.drawer;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.drawer.ui.academy.AcademyFragment;
import com.example.drawer.ui.flexclub.FlexFragment;
import com.example.drawer.ui.help.HelpFragment;
import com.example.drawer.ui.home.HomeFragment;
import com.example.drawer.ui.invitefriends.InviteFriendsFragment;
import com.example.drawer.ui.portfolio.PortfolioFragment;
import com.example.drawer.ui.settings.SettingsFragment;
import com.example.drawer.ui.support.SupportFragment;
import com.example.drawer.ui.watchlist.WatchlistFragment;
import com.example.drawer.ui.withdraw.WithdrawFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainTwo extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    FragmentManager fragmentManager;
    private AppBarConfiguration mAppBarConfiguration;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_flex, R.id.nav_invite,R.id.nav_withdraw,R.id.nav_settings,R.id.nav_help,R.id.nav_academy)
                .setOpenableLayout(drawerLayout)
                .build();


        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        bottomNavigationView = findViewById(R.id.bottomNavBar);
        bottomNavigationView.setBackground(null);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId== R.id.bottomHome){
                    openFragment(new HomeFragment());
                    return true;
                } else if (itemId == R.id.bottomWatchlist) {
                    openFragment(new WatchlistFragment());
                    return true;
                } else if (itemId == R.id.bottomPortfolio) {
                    openFragment(new PortfolioFragment());
                    return true;
                }else if (itemId == R.id.bottomSupport) {
                    openFragment(new SupportFragment());
                    return true;
                }

                return false;
            }
        });

        fragmentManager = getSupportFragmentManager();
        openFragment(new HomeFragment());


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId== R.id.bottomHome){
            openFragment(new HomeFragment());
        } else if (itemId == R.id.nav_flex) {
            openFragment(new FlexFragment());
        } else if (itemId == R.id.nav_invite) {
            openFragment(new InviteFriendsFragment());
        }else if (itemId == R.id.nav_withdraw) {
            openFragment(new WithdrawFragment());
        } else if (itemId == R.id.nav_settings) {
            openFragment(new SettingsFragment());
        }else if (itemId == R.id.nav_help) {
            openFragment(new HelpFragment());
        } else if (itemId == R.id.nav_academy) {
            openFragment(new AcademyFragment());
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void openFragment(Fragment fragment){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.nav_host_fragment_content_main, fragment);
        transaction.commit();
    }
}
