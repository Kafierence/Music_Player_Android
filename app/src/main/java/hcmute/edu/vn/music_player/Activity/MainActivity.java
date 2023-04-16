package hcmute.edu.vn.music_player.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import hcmute.edu.vn.music_player.Fragment.HomeFragment;
import hcmute.edu.vn.music_player.Fragment.LibraryFragment;
import hcmute.edu.vn.music_player.Fragment.SearchFragment;
import hcmute.edu.vn.music_player.R;
import hcmute.edu.vn.music_player.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    LibraryFragment libraryFragment = new LibraryFragment();
    SearchFragment searchFragment = new SearchFragment();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.layout_wrapper, homeFragment).commit();
        bottomNavigationView = findViewById(R.id.bottom_navigation);


        //setting action when loading content layout
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.layout_wrapper, homeFragment).commit();
                        return true;
                    case R.id.nav_search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.layout_wrapper, searchFragment).commit();
                        return true;
                    case R.id.nav_library:
                        getSupportFragmentManager().beginTransaction().replace(R.id.layout_wrapper, libraryFragment).commit();
                        return true;

                }
                return false;
            }
        });
    }

    //when user use application => status of user will online
    @Override
    protected void onStart() {
        super.onStart();
    }

    //when user stop use application => status offline
    @Override
    protected void onStop() {
        super.onStop();
    }

}