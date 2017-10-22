package com.example.jose.codetestimmote;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by Jose on 22/10/2017.
 */

public class CustomView extends View {
    Paint paint = null;
    private Circle circle1, circle2, circle3, circle4, circle5;
    private float scale;
    private boolean paintCircles;

    public CustomView(Context context) {
        super(context);
        paint = new Paint();
        paintCircles = false;

    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paintCircles = false;
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paintCircles = false;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int x = getWidth();
        int y = getHeight();
        int radius;
        radius = 400;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(7);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
        // Use Color.parseColor to define HTML colors
        paint.setColor(Color.parseColor("#000000"));
        if(paintCircles) {
            canvas.drawCircle(x / 2, y / 2, radius, paint);
        }
    }

    public void drawCircles(Circle circle1, Circle circle2, Circle circle3){
        invalidate();
    }

    public void drawCircles(){
        paintCircles = true;
        invalidate();
    }

}
