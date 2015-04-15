package com.rsd.caninesolutions;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.app.Application;

/**
 * Created by wadereweti on 14/04/15.
 */
public class CanineApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
