package com.mavzapps.flowerstoredemo.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mavzapps.flowerstoredemo.Objects.DealsObject;
import com.mavzapps.flowerstoredemo.R;

import java.util.List;

/**
 * Created by MariaVirginia on 3/11/2016.
 */

public class ProductDealAdapter extends RecyclerView.Adapter<ProductDealAdapter.ViewHolder>{

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
        public ViewHolder(View v) {
            super(v);
            mView = v;
            mImageView = (ImageView)mView.findViewById(R.id.cardImageView);
            mTitleView = (TextView)mView.findViewById(R.id.cardTitleLbl);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ProductDealAdapter(List<DealsObject> myDataset, Context context) {
        mDataset = myDataset;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ProductDealAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_deals_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ProductDealAdapter.ViewHolder vh = new ProductDealAdapter.ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ProductDealAdapter.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        String title = mDataset.get(position).getName() + " at " + mDataset.get(position).getPrice();

        holder.mTitleView.setText(title);

        holder.mImageView.setImageResource(context.getResources().getIdentifier(mDataset.get(position).getImageName(),"drawable",context.getPackageName()));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
