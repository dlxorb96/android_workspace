package HelperClass;

import android.graphics.drawable.Drawable;

public class GroceryHelperClassTop {
    int image;
    String title;
    Drawable background;



    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public Drawable getBackground() {
        return background;
    }


    public GroceryHelperClassTop(int image, String title, Drawable background) {
        this.image = image;
        this.title = title;
        this.background = background;
    }

}
