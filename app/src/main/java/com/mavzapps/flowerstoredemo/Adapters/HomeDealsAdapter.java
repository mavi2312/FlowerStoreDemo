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
import com.mavzapps.flowerstoredemo.Objects.DealsObject;
import com.mavzapps.flowerstoredemo.Objects.FeaturesObject;
import com.mavzapps.flowerstoredemo.R;

import java.util.List;

/**
 * Created by MariaVirginia on 30/10/2016.
 */

public class HomeDealsAdapter extends RecyclerView.Adapter<HomeDealsAdapter.ViewHolder>{

    private List<DealsObject> mDataset;
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
    public HomeDealsAdapter(List<DealsObject> myDataset, Context context) {
        mDataset = myDataset;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public HomeDealsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_home_features_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        HomeDealsAdapter.ViewHolder vh = new HomeDealsAdapter.ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(HomeDealsAdapter.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        String title = mDataset.get(position).getName() + " at " + mDataset.get(position).getPrice();

        holder.mTitleView.setText(title);

        holder.mImageView.setImageResource(context.getResources().getIdentifier(mDataset.get(position).getImageName(),"drawable",context.getPackageName()));

        holder.mBuyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ProductCategoriesActivity.class);
                context.startActivity(i);
            }
        });

        holder.mViewBtn.setVisibility(View.GONE);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
