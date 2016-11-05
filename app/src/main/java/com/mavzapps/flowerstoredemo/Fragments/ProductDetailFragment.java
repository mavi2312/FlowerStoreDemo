package com.mavzapps.flowerstoredemo.Fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.mavzapps.flowerstoredemo.Activities.HomeActivity;
import com.mavzapps.flowerstoredemo.Adapters.ProductDealAdapter;
import com.mavzapps.flowerstoredemo.Objects.DealsObject;
import com.mavzapps.flowerstoredemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDetailFragment extends Fragment {


    public ProductDetailFragment() {
        // Required empty public constructor
    }

    static String[] photosArray = {"red_roses_inner_product1","red_roses_inner_product2","red_roses_inner_product3"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_detail, container, false);
        ViewPager gallery = (ViewPager)view.findViewById(R.id.productGallery);
        ImageView productImage = (ImageView)view.findViewById(R.id.productImageView);

        if(getArguments()!=null){
            String transitionName = getArguments().getString("TransitionName");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //gallery.setTransitionName(transitionName);
                productImage.setTransitionName(transitionName);
                Log.d("Detail-TransitionName",transitionName);
            }
        }

        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getChildFragmentManager());

        gallery.setAdapter(adapter);

        RecyclerView dealsList = (RecyclerView)view.findViewById(R.id.dealsList);

        List<DealsObject> list = createDummyDeals();

        HomeActivity.VerticalSpaceItemDecoration spaceItemDecoration = new HomeActivity.VerticalSpaceItemDecoration(10);
        dealsList.addItemDecoration(spaceItemDecoration);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        dealsList.setLayoutManager(linearLayoutManager);

        ProductDealAdapter adapter1 = new ProductDealAdapter(list,getActivity());

        dealsList.setAdapter(adapter1);

        Spinner quantity = (Spinner)view.findViewById(R.id.quantitySpinner);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.quantity_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        quantity.setAdapter(adapter2);

        return view;
    }

    private List<DealsObject> createDummyDeals(){
        DealsObject roses = new DealsObject("12 roses","lilies_deals","$50");
        DealsObject arrangements = new DealsObject("Roses Arrangements","flower_arrangement_deals","$80");
        DealsObject combination = new DealsObject("5 red roses + 3 white roses","lilies_deals","$25");
        DealsObject wedding = new DealsObject("Wedding Bouquets","flower_arrangement_deals","$80");
        DealsObject combination2 = new DealsObject("4 Burgundy Roses + 4 Red Roses","lilies_deals","$50");
        DealsObject holidays = new DealsObject("Roses Holiday Arrangements","flower_arrangement_deals","$80");

        List<DealsObject> list = new ArrayList<>();

        list.add(roses);
        list.add(arrangements);
        list.add(combination);
        list.add(wedding);
        list.add(combination2);
        list.add(holidays);

        return list;
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
            View rootView = inflater.inflate(R.layout.product_gallery_item, container, false);
            //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            ImageView productImageView = (ImageView)rootView;

            productImageView.setImageResource(getActivity().getResources().getIdentifier(photosArray[getArguments().getInt(ARG_SECTION_NUMBER)],"drawable",getActivity().getPackageName()));

            return rootView;
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
            return PlaceholderFragment.newInstance(position);
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
                    return "Roses";
                case 1:
                    return "Sunflowers";
                case 2:
                    return "Lilies";
            }
            return null;
        }
    }

}
