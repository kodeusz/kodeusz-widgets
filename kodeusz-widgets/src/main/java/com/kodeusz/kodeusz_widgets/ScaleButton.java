package com.kodeusz.kodeusz_widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class ScaleButton extends android.support.v7.widget.AppCompatButton {

    private Animation scaleUp;
    private Animation scaleDown;

    public ScaleButton(Context context) {
        super(context);
        init();
    }

    public ScaleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ScaleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        scaleUp = AnimationUtils.loadAnimation(getContext(), R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(getContext(), R.anim.scale_down);

        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startAnimation(scaleDown);
                        return true;
                    case MotionEvent.ACTION_UP:
                        startAnimation(scaleUp);
                        return true;
                }

                return false;
            }
        });
    }
}
