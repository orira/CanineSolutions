package com.rsd.caninesolutions.adapter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.rsd.caninesolutions.R;
import com.rsd.caninesolutions.domain.CanineService;
import com.rsd.caninesolutions.presentation.NavigationView;
import com.rsd.caninesolutions.widget.RobotoTextView;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.logging.Logger;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by wadereweti on 14/04/15.
 */
public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = MainRecyclerViewAdapter.class.getSimpleName();

    private Context mContext;
    private NavigationView mNavigationView;
    private List<CanineService> mCanineServices;

    public MainRecyclerViewAdapter(Context context) {
        mContext = context;
        mNavigationView = (NavigationView) context;
        mCanineServices = CanineService.getAll();
    }

    @Override
    public MainRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_main, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, mNavigationView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MainRecyclerViewAdapter.ViewHolder holder, int position) {
        CanineService currentCanineService = mCanineServices.get(position);

        holder.mTextView.setText(currentCanineService.mServiceName);
        Picasso.with(mContext)
                .load("http://www.funchap.com/wp-content/uploads/2014/05/Cute-Dog-Wallpapers.jpg")
                .placeholder(currentCanineService.mServiceImagePath)
                .into(holder.mImageView);

        holder.mImageView.setTag(currentCanineService.mServiceImagePath);
    }

    @Override
    public int getItemCount() {
        return mCanineServices.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private NavigationView mNavigationView;

        @InjectView(R.id.text_view_recycler_view_main) public RobotoTextView mTextView;
        @InjectView(R.id.image_view_recycler_view_main) public ImageView mImageView;

        public ViewHolder(View itemView, NavigationView navigationView) {
            super(itemView);

            mNavigationView = navigationView;
            itemView.setOnClickListener(this);

            ButterKnife.inject(this, itemView);
        }

        @Override
        public void onClick(View view) {
            mNavigationView.onItemSeletedForNavigation(view);
        }
    }
}
