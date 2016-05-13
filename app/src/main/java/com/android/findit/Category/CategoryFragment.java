package com.android.findit.Category;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
        categories.add(new Category("Restaurants"));
        categories.add(new Category("Fresh Markets"));
        categories.add(new Category("Shopping Malls"));
        categories.add(new Category("Gadgets"));
        categories.add(new Category("Mosques"));
        categories.add(new Category("Clinics"));
        categories.add(new Category("Banks/ATMs"));
        categories.add(new Category("Petrol Stations"));
        categories.add(new Category("Homestays"));
        categories.add(new Category("Hotels"));
        categories.add(new Category("Nurseries"));
        categories.add(new Category("Tailors"));
        categories.add(new Category("Boutiques"));
        categories.add(new Category("Beauty Shops"));
    }
}

