package com.mavzapps.flowerstoredemo.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mavzapps.flowerstoredemo.Activities.ProductCategoriesActivity;
import com.mavzapps.flowerstoredemo.Objects.FeaturesObject;
import com.mavzapps.flowerstoredemo.R;

import java.util.List;

/**
 * Created by MariaVirginia on 30/10/2016.
 */

public class HomeFeatureAdapter extends RecyclerView.Adapter<HomeFeatureAdapter.ViewHolder> {

    private List<FeaturesObject> mDataset;
    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View mView;
        public ImageView mImageView;
        public TextView mTitleView;
        public Button mBuyBtn, mViewBtn;
        public ViewHolder(View v) {
            super(v);
            mView = v;
            mImageView = (ImageView)mView.findViewById(R.id.cardImageView);
            mTitleView = (TextView)mView.findViewById(R.id.cardTitleLbl);
            mBuyBtn = (Button)mView.findViewById(R.id.buyBtn);
            mViewBtn = (Button)mView.findViewById(R.id.viewBtn);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public HomeFeatureAdapter(List<FeaturesObject> myDataset, Context context) {
        mDataset = myDataset;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public HomeFeatureAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_home_features_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTitleView.setText(mDataset.get(position).getName());

        holder.mImageView.setImageResource(context.getResources().getIdentifier(mDataset.get(position).getImageName(),"drawable",context.getPackageName()));

        holder.mBuyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ProductCategoriesActivity.class);
                context.startActivity(i);
            }
        });

        holder.mBuyBtn.setVisibility(View.GONE);

        holder.mViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ProductCategoriesActivity.class);
                context.startActivity(i);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
