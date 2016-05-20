package com.android.findit.Helper;

import android.app.Activity;
import android.graphics.Point;

/**
 * Created by Hanani on 20/5/2016.
 */
public class Utils {

    /**
     * @param activity activity
     * @return device width in pixles.
     */
    public static float getDeviceWidth(Activity activity) {
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(size);
        return size.x;
    }
}
