package edu.uncg.csc.bigo.weather.views.activities;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.widget.Toast;

import edu.uncg.csc.bigo.weather.R;
import edu.uncg.csc.bigo.weather.controllers.DataController;


/**
 * The MainActivity class controls the 3 fragments: Current, Daily, Hourly. The backbone of the
 * views.
 *
 * @Updated: 12/4/2018
 * @Author Steven Tran
 **/
public class MainActivity extends AppCompatActivity {

    //This manages the fragments.
    private SectionsPagerAdapter mSectionsPagerAdapter;

    //This viewpager allows for view changing.
    private ViewPager mViewPager;


    /**
     * The method that is called on start up to manage the view fragments.
     *
     * @param _savedInstanceState
     */
    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);

        //Sets the view to Main Activity.
        setContentView(R.layout.activity_main);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);

        //Allows pages to be changed.
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        //Shared preference to manage if zipcode was already entered initially.
        SharedPreferences sp = getSharedPreferences("GLOBAL", Context.MODE_PRIVATE);


        boolean firstRun = sp.getBoolean("run", true);


        //If zipcode was not an input yet, then the location view will start up.
        if (firstRun) {
            startActivity(new Intent(MainActivity.this, Location.class));
        }
        sp.edit().putBoolean("run", false).apply();

    }

    /**
     * This allows for the top right navigation bar.
     *
     * @param _menu
     * @return true
     */
    public boolean onCreateOptionsMenu(Menu _menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, _menu);
        return true;
    }

    /**
     * This defines what the options in the top right navigation bar do.
     *
     * @param _item
     * @return true
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem _item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = _item.getItemId();

        if (id == R.id.action_location) {
            startActivity(new Intent(this, Location.class));
            return true;
        }

        if (id == R.id.action_clear) {
            // This is used for CRUD operations.
            DataController controller = new DataController();
            controller.removeController();

            // Display a confirmation message when removal is done.
            CharSequence text = "Deletion Complete!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(getApplicationContext(), text, duration);
            toast.show();
            return true;
        }

        return super.onOptionsItemSelected(_item);
    }

    /**
     * A FragmentPager Adapter that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     *
     * @Updated: 12/4/2018
     * @Author: Steven Tran
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        /**
         * Creating the sections pager adapter.
         *
         * @param _fm
         */
        public SectionsPagerAdapter(FragmentManager _fm) {
            super(_fm);
        }

        /**
         * Initialize the fragment views.
         *
         * @param _position
         * @return fragment
         */
        @Override
        public Fragment getItem(int _position) {
            Fragment fragment = null;
            switch (_position) {
                case 0:
                    fragment = new CurrentWeather();
                    break;
                case 1:
                    fragment = new DailyWeather();
                    break;
                case 2:
                    fragment = new HourlyWeather();
                    break;
            }
            return fragment;
        }

        /**
         * Gets the count of how many fragments.
         *
         * @return 3
         */
        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        /**
         * Titles the fragments for declaration.
         *
         * @param _position
         * @return null
         */
        @Override
        public CharSequence getPageTitle(int _position) {
            switch (_position) {
                case 0:
                    return "Current";
                case 1:
                    return "Daily";
                case 2:
                    return "Hourly";
            }
            return null;
        }
    }
}
