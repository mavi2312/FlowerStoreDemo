package com.mavzapps.flowerstoredemo.Activities;

import android.graphics.Rect;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.mavzapps.flowerstoredemo.Adapters.HomeCategoriesAdapter;
import com.mavzapps.flowerstoredemo.Adapters.HomeDealsAdapter;
import com.mavzapps.flowerstoredemo.Adapters.HomeFeatureAdapter;
import com.mavzapps.flowerstoredemo.Objects.CategoriesObject;
import com.mavzapps.flowerstoredemo.Objects.DealsObject;
import com.mavzapps.flowerstoredemo.Objects.FeaturesObject;
import com.mavzapps.flowerstoredemo.R;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        fab.setVisibility(View.GONE);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_home, container, false);
            //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            RecyclerView homeRecyclerView = (RecyclerView) rootView.findViewById(R.id.homeRecyclerView);
            homeRecyclerView.setHasFixedSize(true);
            VerticalSpaceItemDecoration spaceItemDecoration = new VerticalSpaceItemDecoration(48);
            homeRecyclerView.addItemDecoration(spaceItemDecoration);
            //String[] stringArrayTest = {"Feature 1","Feature 2","Feature 3"};
            if(getArguments().get(ARG_SECTION_NUMBER).equals(1)){
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                homeRecyclerView.setLayoutManager(linearLayoutManager);
                List<FeaturesObject> list = ((HomeActivity)getActivity()).createDummyFeatures();
                HomeFeatureAdapter adapter = new HomeFeatureAdapter(list,getActivity());
                homeRecyclerView.setAdapter(adapter);
            } else if(getArguments().get(ARG_SECTION_NUMBER).equals(2)){
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                homeRecyclerView.setLayoutManager(linearLayoutManager);
                List<DealsObject> listDeals = ((HomeActivity)getActivity()).createDummyDeals();
                HomeDealsAdapter adapter = new HomeDealsAdapter(listDeals,getActivity());
                homeRecyclerView.setAdapter(adapter);
            } else {
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
                homeRecyclerView.setLayoutManager(gridLayoutManager);
                List<CategoriesObject> list = ((HomeActivity)getActivity()).createDummyCategories();
                HomeCategoriesAdapter adapter = new HomeCategoriesAdapter(list,getActivity());
                homeRecyclerView.setAdapter(adapter);
            }
            return rootView;
        }
    }

    private List<FeaturesObject> createDummyFeatures(){
        FeaturesObject roses = new FeaturesObject("Roses","roses_features");
        FeaturesObject orchids = new FeaturesObject("Orchids","orchids_features");
        FeaturesObject sunflowers = new FeaturesObject("Sunflowers","sunflowers_features");

        List<FeaturesObject> list = new ArrayList<>();

        list.add(roses);
        list.add(orchids);
        list.add(sunflowers);

        return list;
    }

    private List<DealsObject> createDummyDeals(){
        DealsObject lilies = new DealsObject("12 Lilies","lilies_deals","$10");
        DealsObject arrangements = new DealsObject("Flower Arrangements","flower_arrangement_deals","$80");
        DealsObject holiday = new DealsObject("Holidays Specials","holiday_deals","$15");
        DealsObject daisies = new DealsObject("30 Daisies","daisies_deals","$20");

        List<DealsObject> list = new ArrayList<>();

        list.add(lilies);
        list.add(arrangements);
        list.add(holiday);
        list.add(daisies);

        return list;
    }

    private List<CategoriesObject> createDummyCategories(){
        CategoriesObject roses = new CategoriesObject("Roses","roses_categories");
        CategoriesObject orchids = new CategoriesObject("Orchids","orchids_categories");
        CategoriesObject carnations = new CategoriesObject("Carnations","carnations_categories");
        CategoriesObject gardenias = new CategoriesObject("Gardenias", "gardenias_categories");
        CategoriesObject lilies = new CategoriesObject("Lilies","lilies_categories");
        CategoriesObject sunflowers = new CategoriesObject("Sunflowers","sunflowers_categories");
        CategoriesObject daisies = new CategoriesObject("Daisies","daisies_categories");
        CategoriesObject violets = new CategoriesObject("Violets","violets_categories");
        CategoriesObject tulips = new CategoriesObject("Tulips","tulips_categories");
        CategoriesObject arrangements = new CategoriesObject("Arrangements","arrangements_categories");
        CategoriesObject basics = new CategoriesObject("Basics","basics_categories");
        CategoriesObject specials = new CategoriesObject("Specials","specials_categories");

        List<CategoriesObject> list = new ArrayList<>();

        list.add(roses);
        list.add(orchids);
        list.add(carnations);
        list.add(lilies);
        list.add(sunflowers);
        list.add(gardenias);
        list.add(daisies);
        list.add(violets);
        list.add(tulips);
        list.add(arrangements);
        list.add(basics);
        list.add(specials);

        return list;

    }

    public static class VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {

        private final int verticalSpaceHeight;

        public VerticalSpaceItemDecoration(int verticalSpaceHeight) {
            this.verticalSpaceHeight = verticalSpaceHeight;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {
            outRect.bottom = verticalSpaceHeight;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Popular";
                case 1:
                    return "Deals";
                case 2:
                    return "Categories";
            }
            return null;
        }
    }
}
