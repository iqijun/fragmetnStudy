package com.xinggs.viewStudy;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016/2/15.
 */
public class DrawView extends View{
    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public DrawView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    Paint paint = new Paint();
    public float coordinateX = 50;
    public float coordinateY = 50;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        coordinateX = event.getX();
        coordinateY = event.getY();
        invalidate();
        System.out.println("========onTouchEvent===========");
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        System.out.println("======onDraw========");
        paint.setColor(Color.RED);
        canvas.drawCircle(coordinateX,coordinateY,15,paint);
    }
}
