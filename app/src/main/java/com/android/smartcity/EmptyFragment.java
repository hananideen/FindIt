package com.android.smartcity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.smartcity.Helper.Constant;

/**
 * Created by Hanani on 20/6/2016.
 */
public class EmptyFragment extends Fragment {
    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static EmptyFragment newInstance(int sectionNumber) {
        EmptyFragment fragment = new EmptyFragment();
        Bundle args = new Bundle();
        args.putInt(Constant.ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public EmptyFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.empty_fragment, container, false);
        TextView name = (TextView) rootView.findViewById(R.id.textView);
        if (getArguments().getInt(Constant.ARG_SECTION_NUMBER)==2)
            name.setText(Constant.NAME_OPPORTUNITIES);
        else if (getArguments().getInt(Constant.ARG_SECTION_NUMBER)==3)
            name.setText(Constant.NAME_ACCOMMODATION);
        else if (getArguments().getInt(Constant.ARG_SECTION_NUMBER)==4)
            name.setText(Constant.NAME_EVENTS);

        return rootView;
    }
}
