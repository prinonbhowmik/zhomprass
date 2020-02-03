package com.my.zhomprass_java.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.my.zhomprass_java.Adapters.SubTabPaggerAdapter;
import com.my.zhomprass_java.Fragments.BrandsFragment;
import com.my.zhomprass_java.Fragments.CategoryFragment;
import com.my.zhomprass_java.Fragments.DistrictFragment;
import com.my.zhomprass_java.R;

public class DistrictActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.productdetails_viewPager);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        SubTabPaggerAdapter  adapter = new SubTabPaggerAdapter(getSupportFragmentManager());

        adapter.addFragment(new CategoryFragment());
        adapter.addFragment(new BrandsFragment());
        adapter.addFragment(new DistrictFragment());

        tabLayout.addTab(tabLayout.newTab().setText("Categories"));
        tabLayout.addTab(tabLayout.newTab().setText("Brands"));
        tabLayout.addTab(tabLayout.newTab().setText("Shops"));

        viewPager.setAdapter(adapter);

        viewPager.setCurrentItem(2);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.homeId:
                        startActivity(new Intent(DistrictActivity.this,MainActivity.class));
                        return true;
                    case R.id.orderId:
                        startActivity(new Intent(DistrictActivity.this,OrderActivity.class));
                        return true;
                    case R.id.cartId:
                        startActivity(new Intent(DistrictActivity.this,CartActivity.class));
                }
                return false;
            }
        });



    }
}