package com.my.zhomprass_java.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.my.zhomprass_java.Adapters.TabPaggerAdapter;
import com.my.zhomprass_java.Fragments.BrandsFragment;
import com.my.zhomprass_java.Fragments.CategoryFragment;
import com.my.zhomprass_java.Fragments.My_Invoice;
import com.my.zhomprass_java.Fragments.My_Joining;
import com.my.zhomprass_java.Fragments.New_Customer;
import com.my.zhomprass_java.Fragments.ShopsFragment;
import com.my.zhomprass_java.R;

public class Customer extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView logoImageViewId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        tabLayout=findViewById(R.id.tab_layout);
        viewPager=findViewById(R.id.productdetails_viewPager);
        logoImageViewId = findViewById(R.id.logoImageId);


        TabPaggerAdapter tabPaggerAdapter = new TabPaggerAdapter(getSupportFragmentManager());
        tabPaggerAdapter.addFragment(new New_Customer());
        tabPaggerAdapter.addFragment(new My_Joining());
        tabPaggerAdapter.addFragment(new My_Invoice());
        viewPager.setAdapter(tabPaggerAdapter);

        checkConnection();
        showContactUs();

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
    }


    private void showContactUs() {
        logoImageViewId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Customer.this,ContactUs.class);
                startActivity(intent);
            }
        });
    }


    public void checkConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();

        if (null != activeNetwork) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {

            } else {

            }

        } else {
            Snackbar.make(findViewById(R.id.layoutCustomerActivity), R.string.offline_message, Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);

    }
}
