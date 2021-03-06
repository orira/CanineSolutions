package com.rsd.caninesolutions.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;

import com.rsd.caninesolutions.R;
import com.rsd.caninesolutions.widget.typeface.RobotoTypeface;
import com.rsd.caninesolutions.widget.typeface.TypefaceUtil;


/**
 * Created by Raukawa on 6/29/2014.
 */
public class RobotoButton extends Button implements RobotoWidget{
    public RobotoButton(Context context) {
        super(context);
        initialiseTypeface(context, null);
    }

    public RobotoButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialiseTypeface(context, attrs);
    }

    public RobotoButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialiseTypeface(context, attrs);
    }

    @Override
    public void initialiseTypeface(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RobotoWidget);
            String typeFaceString = a.getString(R.styleable.RobotoWidget_typeface);

            if (typeFaceString != null) {
                int typeface = Integer.parseInt(typeFaceString);
                RobotoTypeface robotTypeFace = RobotoTypeface.values()[typeface];

                this.setTypeface(TypefaceUtil.getFont(context, robotTypeFace));
            } else {
                setTypeface(TypefaceUtil.getFont(context, RobotoTypeface.REGULAR));
            }
        }
    }
}
