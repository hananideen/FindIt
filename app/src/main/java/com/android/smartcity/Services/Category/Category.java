package com.android.smartcity.Services.Category;

import android.graphics.drawable.Drawable;

/**
 * Created by Hanani on 24/4/2016.
 */
public class Category {
    String categoryName;
    Drawable categoryIcon;

    public Category(String categoryName, Drawable categoryIcon) {
        this.categoryName = categoryName;
        this.categoryIcon = categoryIcon;
    }
}
