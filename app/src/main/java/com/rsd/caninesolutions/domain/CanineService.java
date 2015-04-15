package com.rsd.caninesolutions.domain;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.rsd.caninesolutions.R;

import java.util.List;

/**
 * Created by wadereweti on 14/04/15.
 */

@Table(name = "CanineServices")
public class CanineService extends Model {

    @Column(name = "ServiceName")
    public String mServiceName;

    @Column(name = "ServiceImagePath")
    public int mServiceImagePath;

    public static List<CanineService> getAll() {
        return new Select().from(CanineService.class).execute();
    }

    public static void setup() {

        for (int i = 0; i < 4; i++) {
            CanineService canineService = new CanineService();

            String serviceName = "";
            int imageResourceId = 0;

            switch (i) {
                case 0:
                    serviceName = "Dog Daycare";
                    imageResourceId = R.drawable.dog_daycare;
                    break;
                case 1:
                    serviceName = "Grooming";
                    imageResourceId = R.drawable.dog_grooming;
                    break;
                case 2:
                    serviceName = "Home Training";
                    imageResourceId = R.drawable.dog_home_training;
                    break;
                case 3:
                    serviceName = "Classes";
                    imageResourceId = R.drawable.dog_training_class;
                    break;
            }

            canineService.mServiceName = serviceName;
            canineService.mServiceImagePath = imageResourceId;
            canineService.save();
        }
    }

    public static void deleteAll() {
        new Delete().from(CanineService.class).execute();
    }
}
