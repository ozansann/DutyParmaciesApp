package com.od.dutyparmaciesapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;

import com.od.dutyparmaciesapp.R;

public class BaseFragment extends Fragment {
    NavHostFragment navHostFragment;
    NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
    }

    public void navigate(Integer nav_host){
        NavOptions.Builder navBuilder =  new NavOptions.Builder();
        navBuilder.setEnterAnim(R.anim.slide_in_right).setExitAnim(R.anim.slide_out_left).setPopEnterAnim(R.anim.slide_in_left).setPopExitAnim(R.anim.slide_out_right);
        navController.navigate(nav_host,null,navBuilder.build());
    }

    public void navigateWithBundle(Integer nav_host, Bundle bundle){
        NavOptions.Builder navBuilder =  new NavOptions.Builder();
        navBuilder.setEnterAnim(R.anim.slide_in_right).setExitAnim(R.anim.slide_out_left).setPopEnterAnim(R.anim.slide_in_left).setPopExitAnim(R.anim.slide_out_right);
        navController.navigate(nav_host,bundle,navBuilder.build());
    }
}
