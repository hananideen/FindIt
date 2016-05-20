package com.android.findit.Category;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.findit.Helper.Constant;
import com.android.findit.Helper.Database;
import com.android.findit.R;
import com.android.findit.Helper.Utils;

/**
 * Created by Hanani on 24/4/2016.
 */
public class CategoryFragment extends Fragment {

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
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        gridLayoutManager.setAutoMeasureEnabled(true);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        // set grid columns after calculating columns from screen width and cell width
        gridLayoutManager.setSpanCount((int) Math.max(1, Utils.getDeviceWidth(getActivity()) / (getResources().getDimension(R.dimen.category_item_width)-20)));


        Database.initializeCategories(getResources());

        // specify an adapter (see also next example)
        CategoryAdapter mAdapter = new CategoryAdapter(Database.categories, getContext());
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

}

