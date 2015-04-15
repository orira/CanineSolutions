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
import com.rsd.caninesolutions.widget.RobotoTextView;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by wadereweti on 14/04/15.
 */
public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = MainRecyclerViewAdapter.class.getSimpleName();

    private Context mContext;
    private List<CanineService> mCanineServices;

    public MainRecyclerViewAdapter(Context context) {
        mContext = context;
        mCanineServices = CanineService.getAll();
    }

    @Override
    public MainRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e(TAG, "onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_main, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MainRecyclerViewAdapter.ViewHolder holder, int position) {
        Log.e(TAG, "onBindViewHolder");
        CanineService currentCanineService = mCanineServices.get(position);

        holder.mTextView.setText(currentCanineService.mServiceName);
        Picasso.with(mContext)
                .load("http://www.funchap.com/wp-content/uploads/2014/05/Cute-Dog-Wallpapers.jpg")
                .placeholder(currentCanineService.mServiceImagePath)
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        Log.e(TAG, "getItemCount is = " + mCanineServices.size());
        return mCanineServices.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.text_view_recycler_view_main) public RobotoTextView mTextView;
        @InjectView(R.id.image_view_recycler_view_main) public ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            Log.e(TAG, "ViewHolder Constructor");

            ButterKnife.inject(this, itemView);
        }
    }
}
