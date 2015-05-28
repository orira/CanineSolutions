package com.rsd.caninesolutions.presentation;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by wadereweti on 17/04/15.
 */
public class AbstractActivity extends ActionBarActivity {
    protected static final String TITLE = "bundleArgTitle";
    protected static final String IMAGE_ID = "bundleArgImageId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(android.view.Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().requestFeature(android.view.Window.FEATURE_ACTIVITY_TRANSITIONS);
            getWindow().requestFeature(android.view.Window.FEATURE_ACTION_BAR_OVERLAY);
        }

        super.onCreate(savedInstanceState);
    }
}
