package com.hs.cathaybankexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.hs.cathaybankexam.area.AreaList.AreaListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentByTag("area_list_fragment");
        if (fragment == null) {

            if (savedInstanceState != null) {
                return;
            }

            fragment = new AreaListFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_holder, fragment, "area_list_fragment").commit();
        }
    }
}
