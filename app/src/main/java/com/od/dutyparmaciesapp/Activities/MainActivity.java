package com.od.dutyparmaciesapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationBarView;
import com.od.dutyparmaciesapp.R;
import com.od.dutyparmaciesapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    NavHostFragment navHostFragment;
    NavController navController;
    Integer currentFragmentIndex = 1;
    NavigationBarView.OnItemSelectedListener onItemSelectedListener = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigationAll:
                    navController.navigate(R.id.allPharmacyListFragment);
                    return true;
                case R.id.navigationHome:
                    navController.navigate(R.id.mainFragment);
                    return true;
                case R.id.navigationSettings:
                    navController.navigate(R.id.settingsFragment);
                    return true;
            }
            return true;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.navigation.setOnItemSelectedListener(onItemSelectedListener);
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        setSelectedItem();
    }
    private void setSelectedItem(){
        MenuItem item = binding.navigation.getMenu().findItem(R.id.navigationHome);
        item.setChecked(true);
    }
}