package com.example.tablayoutdemo2;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tablayoutdemo2.model.Planet;

public class MainActivity extends AppCompatActivity {

    private PlanetPagerAdapter mPlanetPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlanetPagerAdapter = new PlanetPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mPlanetPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    public class PlanetPagerAdapter extends FragmentPagerAdapter {

        public PlanetPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlanetFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return Planet.PLANETS.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return Planet.PLANETS[position].getName();
        }
    }

    public static class PlanetFragment extends Fragment {

        private static final String ARG_PLANET_INDEX = "planet_index";
        private int mPlanetIndex;

        public static PlanetFragment newInstance(int planetIndex) {
            PlanetFragment fragment = new PlanetFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_PLANET_INDEX, planetIndex);
            fragment.setArguments(args);
            return fragment;
        }

        public PlanetFragment() {
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            if (getArguments() != null) {
                mPlanetIndex = getArguments().getInt(ARG_PLANET_INDEX);
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            ImageView planetImage = (ImageView) rootView.findViewById(R.id.planet_image);
            planetImage.setImageResource(Planet.PLANETS[mPlanetIndex].getImageResource());
            return rootView;
        }
    }
}
