package com.example.tablayoutdemo2.model;

import com.example.tablayoutdemo2.R;

/**
 * Created by Promlert on 10/4/2015.
 */
public class Planet {
    private String mName;
    private int mImageResource;

    private Planet(String name, int imageResource) {
        this.mName = name;
        this.mImageResource = imageResource;
    }

    public String getName() {
        return mName;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public static final Planet[] PLANETS = {
            new Planet("Mercury", R.drawable.mercury),
            new Planet("Venus", R.drawable.venus),
            new Planet("Earth", R.drawable.earth),
            new Planet("Mars", R.drawable.mars),
            new Planet("Jupiter", R.drawable.jupiter),
            new Planet("Saturn", R.drawable.saturn),
            new Planet("Uranus", R.drawable.uranus),
            new Planet("Neptune", R.drawable.neptune)
    };
}
