package com.google.android.apps.markers;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import org.dsandler.apps.markers.R;

public class TestActivity extends Activity {
    private Slate mSlate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final Window win = getWindow();
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(win.getAttributes());
        lp.format = PixelFormat.RGBA_8888;
        win.setBackgroundDrawableResource(R.drawable.transparent);
        win.setAttributes(lp);
        win.requestFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mSlate = (Slate) getLastNonConfigurationInstance();
        if (mSlate == null) {
            mSlate = new Slate(this);
        }
        final ViewGroup root = ((ViewGroup) findViewById(R.id.root));
        root.addView(mSlate, 0);

        mSlate.setZoomMode(false);
        mSlate.setPenSize(2, 24);
        mSlate.setPenColor(0xFF000000);
        mSlate.setPenType(1);
        mSlate.setPenType(1);
        mSlate.setPenType(1);
    }

    public void setPenColor(int color) {
        mSlate.setPenColor(color);
    }

    public void setPenType(int type) {
        mSlate.setPenType(type);
    }

    @Override
    public Object onRetainNonConfigurationInstance() {
        ((ViewGroup) mSlate.getParent()).removeView(mSlate);
        return mSlate;
    }
}
