package jp.aeriagames.tanuki;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Locale;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

    // Pager
    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set Action Bar
        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create the adapter that will return a fragment
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        // set layout before find pager
        setContentView(R.layout.pager);
        mViewPager = (ViewPager) this.findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        // When swiping between different sections, select the corresponding tab.
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position){
                getActionBar().setSelectedNavigationItem(position);
            }
        });
        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this)
            );
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private Fragment fragment_social;
        private Fragment fragment_chat;
        private Fragment fragment_profile;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            fragment_social = new SocialFragment();
            fragment_chat = new ChatFragment();
            fragment_profile = new ProfileFragment();

            Bundle args = new Bundle();

            // TODO: Profile Fragment
            args.putInt(ProfileFragment.ARG_SECTION_NUMBER, position + 1);
            fragment_profile.setArguments(args);

            switch (position) {
                case 0:
                    return fragment_social;
                case 1:
                    return fragment_chat;
                case 2:
                    return fragment_profile;
            }

            return fragment_profile;
        }

        @Override
        public int getCount() {
            // total pages
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale locale = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_tab_social).toUpperCase(locale);
                case 1:
                    return getString(R.string.title_tab_chat).toUpperCase(locale);
                case 2:
                    return getString(R.string.title_tab_profile).toUpperCase(locale);
            }
            return null;
        }


    }




}



