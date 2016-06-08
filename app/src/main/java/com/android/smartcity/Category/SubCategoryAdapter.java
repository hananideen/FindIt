package com.android.smartcity.Category;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.smartcity.Helper.Constant;
import com.android.smartcity.R;

import java.util.List;

/**
 * Created by Hanani on 11/5/2016.
 */
public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.ViewHolder> {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public TextView tvDetails;
        public ImageView ivLogo;

        public ViewHolder(View v) {
            super(v);
            tvName = (TextView) v.findViewById(R.id.tvName);
            tvDetails = (TextView) v.findViewById(R.id.tvDetails);
            ivLogo = (ImageView) v.findViewById(R.id.ivCategory);
        }
    }

    List<SubCategory> subCategory;
    Context context;

    SubCategoryAdapter(List<SubCategory> subCategory, Context context) {
        this.subCategory = subCategory;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return subCategory.size();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public SubCategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.subcategory_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tvName.setText(subCategory.get(position).categoryName);
        holder.tvDetails.setText(subCategory.get(position).categoryDetails);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra(Constant.NAME, subCategory.get(position).categoryName);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
