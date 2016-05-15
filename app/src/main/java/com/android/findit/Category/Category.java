package com.android.findit.Category;

import android.graphics.drawable.Drawable;

/**
 * Created by Hanani on 24/4/2016.
 */
public class Category {
    String categoryName;
    Drawable categoryIcon;

    Category(String categoryName, Drawable categoryIcon) {
        this.categoryName = categoryName;
        this.categoryIcon = categoryIcon;
    }
}
