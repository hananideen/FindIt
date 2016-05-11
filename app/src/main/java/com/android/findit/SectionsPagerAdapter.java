package com.android.findit;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.android.findit.Category.CategoryFragment;

/**
 * Created by Hanani on 24/4/2016.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        switch (position){
            case 0:
                return MapFragment.newInstance(position + 1);
            case 1:
                return CategoryFragment.newInstance(position);
            case 2:
                return AboutFragment.newInstance(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        // Show total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Map View";
            case 1:
                return "Categories";
            case 2:
                return "About";
        }
        return null;
    }
}
