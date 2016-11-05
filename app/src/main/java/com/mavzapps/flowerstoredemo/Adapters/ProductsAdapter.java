package com.mavzapps.flowerstoredemo.Adapters;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mavzapps.flowerstoredemo.Fragments.ProductDetailFragment;
import com.mavzapps.flowerstoredemo.Objects.FeaturesObject;
import com.mavzapps.flowerstoredemo.Objects.ProductsObject;
import com.mavzapps.flowerstoredemo.R;

import java.util.List;

/**
 * Created by MariaVirginia on 1/11/2016.
 */

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    private List<ProductsObject> mDataset;
    private Context context;
    private Fragment fragment;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View mView;
        public ImageView mImageView;
        public TextView mTitleView, mDescriptionView;
        public Button mBuyBtn, mViewBtn;
        public ViewHolder(View v) {
            super(v);
            mView = v;
            mImageView = (ImageView)mView.findViewById(R.id.cardImageView);
            mTitleView = (TextView)mView.findViewById(R.id.cardTitleLbl);
            mDescriptionView = (TextView)mView.findViewById(R.id.cardDescriptionLbl);
            mBuyBtn = (Button)mView.findViewById(R.id.buyBtn);
            mViewBtn = (Button)mView.findViewById(R.id.viewBtn);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ProductsAdapter(List<ProductsObject> myDataset, Context context, Fragment fragment) {
        mDataset = myDataset;
        this.context = context;
        this.fragment = fragment;
    }

    @Override
    public int getItemViewType(int position) {
        // Just as an example, return 0 or 2 depending on position
        // Note that unlike in ListView adapters, types don't have to be contiguous
        return position % 2;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v;
        switch (viewType){
            case 0:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_product_list_left_item, parent, false);
                break;
            case 1:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_product_list_right_item, parent, false);
                break;
            default:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_product_list_left_item, parent, false);
        }
        // set the view's size, margins, paddings and layout parameters
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTitleView.setText(mDataset.get(position).getName());

        holder.mDescriptionView.setText(mDataset.get(position).getDescription());
        //holder.mDescriptionView.setEllipsize(TextUtils.TruncateAt.END);

        holder.mImageView.setImageResource(context.getResources().getIdentifier(mDataset.get(position).getImageName(),"drawable",context.getPackageName()));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.mImageView.setTransitionName("fromListToProductImage"+String.valueOf(position));
            Log.d("onBind-TransitionName",holder.mImageView.getTransitionName());
        }

        holder.mViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment productFragment = new ProductDetailFragment();
                String transitionName = "";

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    fragment.setSharedElementReturnTransition(TransitionInflater.from(context).inflateTransition(R.transition.change_image_transform));
                    fragment.setExitTransition(TransitionInflater.from(context).inflateTransition(android.R.transition.fade));

                    transitionName = holder.mImageView.getTransitionName();
                    Bundle bundle = new Bundle();
                    bundle.putString("TransitionName", holder.mImageView.getTransitionName());
                    Log.d("onClick-TransitionName",holder.mImageView.getTransitionName());
                    productFragment.setSharedElementEnterTransition(TransitionInflater.from(context).inflateTransition(R.transition.change_image_transform));
                    productFragment.setEnterTransition(TransitionInflater.from(context).inflateTransition(android.R.transition.fade));
                    productFragment.setArguments(bundle);
                }

                FragmentTransaction transaction = ((AppCompatActivity)context).getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.productsFragment,productFragment).addToBackStack("Product Detail").addSharedElement(holder.mImageView,transitionName);
                transaction.commit();
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}