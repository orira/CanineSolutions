package com.rsd.caninesolutions.presentation;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.rsd.caninesolutions.R;
import com.rsd.caninesolutions.adapter.MainRecyclerViewAdapter;
import com.rsd.caninesolutions.domain.CanineService;
import com.rsd.caninesolutions.widget.RobotoTextView;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends AbstractActivity implements NavigationView {

    private static final int SPAN_COUNT = 2;

    RecyclerView.LayoutManager mLayoutManager;

    @InjectView(R.id.recycler_view_main)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        if (CanineService.getAll().size() == 0) {
            CanineService.setup();
        }

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this, SPAN_COUNT);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(new MainRecyclerViewAdapter(this));
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onItemSeletedForNavigation(View view) {
        KenBurnsView kenBurnsImageView = null;
        ImageView imageView = null;
        RobotoTextView textView = null;

        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View child = viewGroup.getChildAt(i);

            if (child instanceof KenBurnsView) {
                kenBurnsImageView = (KenBurnsView) child;
            } else if (child instanceof ImageView) {
                imageView = (ImageView) child;
            } else if (child instanceof RobotoTextView) {
                textView = (RobotoTextView) child;
            }
        }


        Intent intent = new Intent(this, GroomingActivity.class);
        Bundle extras = new Bundle();
        extras.putString(TITLE, textView.getText().toString());

        int imageViewTag = kenBurnsImageView == null ? (int) imageView.getTag() : (int) kenBurnsImageView.getTag();
        extras.putInt(IMAGE_ID, imageViewTag);
        intent.putExtras(extras);

        ViewCompat.setTransitionName(view, textView.getText().toString());
        //ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, imageView, "imageVew");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, view, ViewCompat.getTransitionName(view));
        ActivityCompat.startActivity(this, intent, options.toBundle());
    }
}
