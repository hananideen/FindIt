package com.android.findit.Helper;

import android.content.res.Resources;

import com.android.findit.Category.Category;
import com.android.findit.Category.SubCategory;
import com.android.findit.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hanani on 15/5/2016.
 */
public class Database {

    public static List<Category> categories;
    public static List<SubCategory> subCategories;

    public static void initializeCategories(Resources resources){
        categories = new ArrayList<>();
        categories.add(new Category("Banks/ATMs", resources.getDrawable(R.drawable.ic_local_atm_black_24dp)));
        categories.add(new Category("Beauty Shops", resources.getDrawable(R.drawable.ic_spa_black_24dp)));
        categories.add(new Category("Book Stores", resources.getDrawable(R.drawable.ic_book_black_24dp)));
        categories.add(new Category("Boutiques", resources.getDrawable(R.drawable.ic_shopping_basket_black_24dp)));
        categories.add(new Category("Clinics", resources.getDrawable(R.drawable.ic_local_hospital_black_24dp)));
        categories.add(new Category("Fitness", resources.getDrawable(R.drawable.ic_fitness_center_black_24dp)));
        categories.add(new Category("Florist", resources.getDrawable(R.drawable.ic_local_florist_black_24dp)));
        categories.add(new Category("Gadgets", resources.getDrawable(R.drawable.ic_phone_android_black_24dp)));
        categories.add(new Category("Groceries", resources.getDrawable(R.drawable.ic_local_grocery_store_black_24dp)));
        categories.add(new Category("Hardware & DIY", resources.getDrawable(R.drawable.ic_vpn_key_black_24dp)));
        categories.add(new Category("Homestays", resources.getDrawable(R.drawable.ic_store_mall_directory_black_24dp)));
        categories.add(new Category("Hotels", resources.getDrawable(R.drawable.ic_hotel_black_24dp)));
        categories.add(new Category("Laundry Services", resources.getDrawable(R.drawable.ic_local_laundry_service_black_24dp)));
        categories.add(new Category("Library", resources.getDrawable(R.drawable.ic_local_library_black_24dp)));
        categories.add(new Category("Mosques", resources.getDrawable(R.drawable.ic_brightness_3_black_24dp)));
        categories.add(new Category("Nurseries", resources.getDrawable(R.drawable.ic_child_friendly_black_24dp)));
        categories.add(new Category("Pet Stores", resources.getDrawable(R.drawable.ic_pets_black_24dp)));
        categories.add(new Category("Petrol Stations", resources.getDrawable(R.drawable.ic_local_gas_station_black_24dp)));
        categories.add(new Category("Photocopy", resources.getDrawable(R.drawable.ic_local_printshop_black_24dp)));
        categories.add(new Category("Post Offices", resources.getDrawable(R.drawable.ic_local_post_office_black_24dp)));
        categories.add(new Category("Restaurants", resources.getDrawable(R.drawable.ic_restaurant_black_24dp)));
        categories.add(new Category("Shopping Malls", resources.getDrawable(R.drawable.ic_local_mall_black_24dp)));
        categories.add(new Category("Swimming Pools", resources.getDrawable(R.drawable.ic_pool_black_24dp)));
        categories.add(new Category("Tailors", resources.getDrawable(R.drawable.ic_person_black_24dp)));

    }

    public static void initializeSub(){
        subCategories = new ArrayList<>();
        subCategories.add(new SubCategory("Place 1", "Description"));
        subCategories.add(new SubCategory("Place 2", "Description"));
        subCategories.add(new SubCategory("Place 3", "Description"));
        subCategories.add(new SubCategory("Place 4", "Description"));
        subCategories.add(new SubCategory("Place 5", "Description"));

    }
}
