package com.example.drfinder.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.drfinder.R;
import com.example.drfinder.databinding.ActivityDetailsBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DetailsActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    ActivityDetailsBinding binding;
    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_details);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        navController = navHostFragment.getNavController();

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_home:
                navController.popBackStack();
                navController.navigate(R.id.homeFragment);
                break;
            case R.id.item_search:
                navController.popBackStack();
                navController.navigate(R.id.searchFragment);
                break;
            case R.id.item_profile:
                navController.popBackStack();
                navController.navigate(R.id.profileFragment);
                break;
        }
        return true;
    }
}