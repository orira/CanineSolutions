package com.rsd.caninesolutions.presentation;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.rsd.caninesolutions.R;
import com.rsd.caninesolutions.widget.RobotoTextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by wadereweti on 17/04/15.
 */
public class GroomingActivity extends AbstractActivity {

    @InjectView(R.id.container) RelativeLayout mContainer;
    //@InjectView(R.id.image_view_grooming) KenBurnsView mImageView;
    @InjectView(R.id.image_view_grooming) ImageView mImageView;
    @InjectView(R.id.title_grooming) RobotoTextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grooming);

        ButterKnife.inject(this);

        //mImageView.pause();

        Bundle extras = getIntent().getExtras();
        String title = extras.getString(TITLE);
        int imageResourceId = extras.getInt(IMAGE_ID);

        ViewCompat.setTransitionName(mContainer, title);

        mTitle.setText(title);
        mImageView.setImageResource(imageResourceId);

        Runnable foo = new Runnable() {
            @Override
            public void run() {
                //mImageView.resume();
            }
        };

        new Handler().postDelayed(foo, 600);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ///mImageView.resume();
    }
}
