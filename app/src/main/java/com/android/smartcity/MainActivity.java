package com.android.smartcity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.android.smartcity.Helper.Constant;
import com.android.smartcity.Services.Category.CategoryFragment;
import com.android.smartcity.Services.MapFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private AppBarLayout appBarLayout;
    private CoordinatorLayout view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        view = (CoordinatorLayout) findViewById(R.id.main_content);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setupView();

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * setup view pager and tab layout
     */
    private void setupView(){
        // Create the adapter that will return the fragments
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        if (viewPager!=null){
            viewPager.setAdapter(mSectionsPagerAdapter);
            //setup page change listener
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                @Override
                public void onPageSelected(int position) {
                    //show the toolbar when switch fragment
                    appBarLayout.setExpanded(true, true);
                    //hide keyboard
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                }
            });
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        if (tabLayout!=null)
            tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            Snackbar.make(drawer, "User Profile Coming Soon", Snackbar.LENGTH_LONG).show();
        } else if (id == R.id.nav_settings) {
            Snackbar.make(drawer, "Settings Coming Soon", Snackbar.LENGTH_LONG).show();
        } else if (id == R.id.nav_about) {
            Snackbar.make(drawer, "About Us Coming Soon", Snackbar.LENGTH_LONG).show();
        } else if (id == R.id.nav_feedback) {
            //Snackbar.make(drawer, "Feedback Coming Soon", Snackbar.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, SplashScreen.class);
            startActivity(intent);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        private SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            switch (position){
                case 0:
                    return MapFragment.newInstance(position);
                case 1:
                    return CategoryFragment.newInstance(position);
                case 2:
                    return EmptyFragment.newInstance(position);
                case 3:
                    return EmptyFragment.newInstance(position);
                case 4:
                    return EmptyFragment.newInstance(position);
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return Constant.NAME_MAP;
                case 1:
                    return Constant.NAME_CATEGORIES;
                case 2:
                    return Constant.NAME_OPPORTUNITIES;
                case 3:
                    return Constant.NAME_ACCOMMODATION;
                case 4:
                    return Constant.NAME_EVENTS;
            }
            return null;
        }
    }
}
