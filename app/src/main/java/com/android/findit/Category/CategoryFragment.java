package com.android.findit.Category;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.findit.Constant;
import com.android.findit.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hanani on 24/4/2016.
 */
public class CategoryFragment extends Fragment {

    private List<Category> categories;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static CategoryFragment newInstance(int sectionNumber) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putInt(Constant.ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public CategoryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.category_fragment, container, false);
        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        //LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        // use a grid layout manager
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 4);
        gridLayoutManager.setAutoMeasureEnabled(true);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        initializeData();

        // specify an adapter (see also next example)
        CategoryAdapter mAdapter = new CategoryAdapter(categories, getContext());
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    private void initializeData(){
        categories = new ArrayList<>();
        categories.add(new Category("Banks/ATMs", getResources().getDrawable(R.drawable.ic_local_atm_black_24dp)));
        categories.add(new Category("Beauty Shops", getResources().getDrawable(R.drawable.ic_spa_black_24dp)));
        categories.add(new Category("Book Stores", getResources().getDrawable(R.drawable.ic_book_black_24dp)));
        categories.add(new Category("Boutiques", getResources().getDrawable(R.drawable.ic_shopping_basket_black_24dp)));
        categories.add(new Category("Clinics", getResources().getDrawable(R.drawable.ic_local_hospital_black_24dp)));
        categories.add(new Category("Fitness", getResources().getDrawable(R.drawable.ic_fitness_center_black_24dp)));
        categories.add(new Category("Florist", getResources().getDrawable(R.drawable.ic_local_florist_black_24dp)));
        categories.add(new Category("Gadgets", getResources().getDrawable(R.drawable.ic_phone_android_black_24dp)));
        categories.add(new Category("Groceries", getResources().getDrawable(R.drawable.ic_local_grocery_store_black_24dp)));
        categories.add(new Category("Hardware & DIY", getResources().getDrawable(R.drawable.ic_vpn_key_black_24dp)));
        categories.add(new Category("Homestays", getResources().getDrawable(R.drawable.ic_store_mall_directory_black_24dp)));
        categories.add(new Category("Hotels", getResources().getDrawable(R.drawable.ic_hotel_black_24dp)));
        categories.add(new Category("Laundry Services", getResources().getDrawable(R.drawable.ic_local_laundry_service_black_24dp)));
        categories.add(new Category("Library", getResources().getDrawable(R.drawable.ic_local_library_black_24dp)));
        categories.add(new Category("Mosques", getResources().getDrawable(R.drawable.ic_brightness_3_black_24dp)));
        categories.add(new Category("Nurseries", getResources().getDrawable(R.drawable.ic_child_friendly_black_24dp)));
        categories.add(new Category("Pet Stores", getResources().getDrawable(R.drawable.ic_pets_black_24dp)));
        categories.add(new Category("Petrol Stations", getResources().getDrawable(R.drawable.ic_local_gas_station_black_24dp)));
        categories.add(new Category("Photocopy", getResources().getDrawable(R.drawable.ic_local_printshop_black_24dp)));
        categories.add(new Category("Post Offices", getResources().getDrawable(R.drawable.ic_local_post_office_black_24dp)));
        categories.add(new Category("Restaurants", getResources().getDrawable(R.drawable.ic_restaurant_black_24dp)));
        categories.add(new Category("Shopping Malls", getResources().getDrawable(R.drawable.ic_local_mall_black_24dp)));
        categories.add(new Category("Swimming Pools", getResources().getDrawable(R.drawable.ic_pool_black_24dp)));
        categories.add(new Category("Tailors", getResources().getDrawable(R.drawable.ic_person_black_24dp)));

    }
}

