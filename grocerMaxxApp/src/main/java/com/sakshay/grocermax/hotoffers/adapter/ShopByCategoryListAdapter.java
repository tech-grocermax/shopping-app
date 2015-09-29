package com.sakshay.grocermax.hotoffers.adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.sakshay.grocermax.BaseActivity;
import com.sakshay.grocermax.R;
import com.sakshay.grocermax.bean.ShopByCategoryModel;
import com.sakshay.grocermax.hotoffers.HotOffersActivity;
import com.sakshay.grocermax.hotoffers.fragment.ItemDetailFragment;

import java.util.ArrayList;

public class ShopByCategoryListAdapter extends RecyclerView.Adapter<ShopByCategoryListAdapter.ViewHolder> {

    private Activity context;
    private Fragment fragment;
    private ArrayList<ShopByCategoryModel> data;
    public ShopByCategoryListAdapter(Activity activity, Fragment fragment) {
//        this.context = context;
        this.context = activity;
        this.fragment = fragment;
        ((BaseActivity) activity).initImageLoaderM();
    }

    public void setListData(ArrayList<ShopByCategoryModel> data) {

        this.data = data;

    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView footer;
//        CardView parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.img);
            footer = (TextView) itemView.findViewById(R.id.footer);
//            parentLayout = (CardView) itemView.findViewById(R.id.layoutParent);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.option_list_item, parent, false);

        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        ImageLoader.getInstance().displayImage(data.get(position).getImages(),
                holder.imageView, ((BaseActivity) context).baseImageoptions);

        holder.footer.setText("Offer " +data.get(position).getOffercount() +" >");
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //fragment.setExitTransition(TransitionInflater.from(context).inflateTransition(android.R.transition.explode));
//                ((HotOffersActivity)context).hitForShopByCategory(data.get(position).getCategory_id());
            }
        });

        holder.footer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((HotOffersActivity)context).hitForShopByCategory(data.get(position).getCategory_id());
            }
        });

    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

}
