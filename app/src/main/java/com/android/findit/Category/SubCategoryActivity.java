package com.android.findit.Category;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.findit.Constant;
import com.android.findit.R;

/**
 * Created by Hanani on 11/5/2016.
 */
public class SubCategoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subcategory_activity);

        String name = getIntent().getStringExtra(Constant.CATEGORY);

        // setup toolbar if found in layout
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        if(toolbar!=null){
            // set title
            toolbar.setTitle(name);
            // home tap goes back
            toolbar.setNavigationIcon(R.drawable.ic_back);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

        }
    }
}
