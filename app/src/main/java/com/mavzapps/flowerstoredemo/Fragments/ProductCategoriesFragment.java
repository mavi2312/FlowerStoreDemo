package com.mavzapps.flowerstoredemo.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mavzapps.flowerstoredemo.Activities.HomeActivity;
import com.mavzapps.flowerstoredemo.Adapters.ProductsAdapter;
import com.mavzapps.flowerstoredemo.Objects.FeaturesObject;
import com.mavzapps.flowerstoredemo.Objects.ProductsObject;
import com.mavzapps.flowerstoredemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ProductCategoriesFragment extends Fragment {

    public ProductCategoriesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_categories, container, false);

        RecyclerView productList = (RecyclerView)view.findViewById(R.id.productCategoriesRecyclerView);

        productList.setHasFixedSize(true);
        HomeActivity.VerticalSpaceItemDecoration spaceItemDecoration = new HomeActivity.VerticalSpaceItemDecoration(48);
        productList.addItemDecoration(spaceItemDecoration);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        productList.setLayoutManager(linearLayoutManager);
        List<ProductsObject> dummyProducts = createDummyProducts();
        ProductsAdapter adapter = new ProductsAdapter(dummyProducts,getActivity(),this);
        productList.setAdapter(adapter);


        return view;
    }

    private List<ProductsObject> createDummyProducts(){
        ProductsObject red = new ProductsObject("Red Roses","red_roses_product","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        ProductsObject white = new ProductsObject("White Roses","white_roses_product","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        ProductsObject yellow = new ProductsObject("Yellow Roses","yellow_roses_product","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        ProductsObject pink = new ProductsObject("Pink Roses","pink_roses_product","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        ProductsObject burgundy = new ProductsObject("Burgundy Roses","burgundy_roses_product","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");

        List<ProductsObject> list = new ArrayList<>();

        list.add(red);
        list.add(white);
        list.add(yellow);
        list.add(pink);
        list.add(burgundy);

        return list;
    }

}
