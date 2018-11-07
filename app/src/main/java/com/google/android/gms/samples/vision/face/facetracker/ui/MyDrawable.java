package com.google.android.gms.samples.vision.face.facetracker.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;

import com.google.android.gms.samples.vision.face.facetracker.R;

public class MyDrawable extends AppCompatImageView {
    private static int[] STATE_HORIZONTAL = {R.attr.horizontal};
    private static int[] STATE_VERTICAL = {R.attr.vertical};
    private int horizontal = 0;
    private int vertical = 0;

    public static String TAG = "FACE";
    public MyDrawable(Context context) {
        super(context);
        init(null);
    }

    public MyDrawable(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MyDrawable(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public MyDrawable(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs){
        setImageDrawable(getResources().getDrawable(R.drawable.hat_1));
    }

    @Override
    public int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 2);
        mergeDrawableStates(drawableState, STATE_HORIZONTAL);
        mergeDrawableStates(drawableState, STATE_VERTICAL);
        return drawableState;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        int v = getDrawableState()[0];
        Log.i(TAG, "v: "+v);
        v = getDrawableState()[1];
        Log.i(TAG, "v: "+v);
        v = getDrawableState()[getDrawableState().length-1];
        Log.i(TAG, "v: "+v);
        v = getDrawableState()[getDrawableState().length-2];
        canvas.rotate((float)v);
        super.onDraw(canvas);
    }

    public void update(int horizontal, int vertical){
        this.horizontal = horizontal;
        this.vertical = vertical;
        refreshDrawableState();
    }
}
