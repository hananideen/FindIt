package com.android.findit.Category;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.findit.Helper.Constant;
import com.android.findit.Helper.Database;
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
            toolbar.inflateMenu(R.menu.menu_subcategory);
            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    int id = item.getItemId();
                    if (id == R.id.action_filter) {
                        Toast.makeText(SubCategoryActivity.this, "Filter", Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
            });

        }

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        if(mRecyclerView!=null){
            mRecyclerView.setHasFixedSize(true);

            // use a linear layout manager
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLayoutManager);

            Database.initializeSub();

            // specify an adapter (see also next example)
            SubCategoryAdapter mAdapter = new SubCategoryAdapter(Database.subCategories, this);
            mRecyclerView.setAdapter(mAdapter);
        }
    }
}
