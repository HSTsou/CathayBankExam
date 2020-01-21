package com.hs.cathaybankexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.hs.cathaybankexam.area.AreaListFragment;
import com.hs.cathaybankexam.network.RetrofitServiceGenerator;
import com.hs.cathaybankexam.network.request.AreaRequest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentByTag("area_list_fragment");
        if (fragment == null) {
            fragment = AreaListFragment.newInstance();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.fragment_holder, fragment, "area_list_fragment");
            ft.commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
