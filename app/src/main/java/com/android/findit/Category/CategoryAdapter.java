package com.android.findit.Category;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.findit.Constant;
import com.android.findit.R;

import java.util.List;

/**
 * Created by Hanani on 24/4/2016.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvCategory;
        public ImageView ivCategory;

        public ViewHolder(View v) {
            super(v);
            tvCategory = (TextView) v.findViewById(R.id.tvCategory);
            ivCategory = (ImageView) v.findViewById(R.id.ivCategory);
        }
    }

    List<Category> category;
    Context context;

    CategoryAdapter(List<Category> category, Context context) {
        this.category = category;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tvCategory.setText(category.get(position).categoryName);
        holder.ivCategory.setImageDrawable(category.get(position).categoryIcon);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SubCategoryActivity.class);
                intent.putExtra(Constant.CATEGORY, category.get(position).categoryName);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
