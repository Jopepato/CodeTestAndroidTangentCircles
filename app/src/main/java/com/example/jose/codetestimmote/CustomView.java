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
    private boolean paintTangentCircles;

    public CustomView(Context context) {
        super(context);
        init();

    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init(){
        paint = new Paint();
        paintCircles = false;
        paintTangentCircles = false;
        circle1 = new Circle();
        circle2 = new Circle();
        circle3 = new Circle();
        circle4 = new Circle();
        circle5 = new Circle();
        scale = 0;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(7);
        canvas.drawPaint(paint);
        //To get the middle of the screen as the 0,0
        int x = getWidth()/2;
        int y = getHeight()/2;

        if(paintCircles) {
            paint.setColor(Color.parseColor("#000000"));
            canvas.drawCircle(x + circle1.getCenterX() * scale, y + circle1.getCenterY()*scale, circle1.getRadius()*scale, paint);
            canvas.drawCircle(x + circle2.getCenterX() * scale, y + circle2.getCenterY()*scale, circle2.getRadius()*scale, paint);
            canvas.drawCircle(x + circle3.getCenterX() * scale, y + circle3.getCenterY()*scale, circle3.getRadius()*scale, paint);
        }
        if(paintTangentCircles){
            //We paint the tangent circles
            paint.setColor(Color.BLUE);
            canvas.drawCircle(x + circle4.getCenterX() * scale, y + circle4.getCenterY()*scale, circle4.getRadius()*scale, paint);
            canvas.drawCircle(x + circle5.getCenterX() * scale, y + circle5.getCenterY()*scale, circle5.getRadius()*scale, paint);
        }

        paint.setColor(Color.WHITE);
    }


    public void drawCircles(){
        paintCircles = true;
        invalidate();
    }

    public void drawTangentCircles(){
        paintTangentCircles = true;
        invalidate();
    }

    //Getters and Setters for the Circles

    public Circle getCircle1(){
        return circle1;
    }

    public void setCircle1(Circle circle){
        circle1 = circle;
    }

    public Circle getCircle2(){
        return circle2;
    }

    public void setCircle2(Circle circle){
        circle2 = circle;
    }

    public Circle getCircle3(){
        return circle3;
    }

    public void setCircle3(Circle circle){
        circle3 = circle;
    }

    public Circle getCircle4(){
        return circle4;
    }

    public void setCircle4(Circle circle){
        circle4 = circle;
    }

    public Circle getCircle5(){
        return circle5;
    }

    public void setCircle5(Circle circle){
        circle5 = circle;
    }

    public float getScale(){
        return scale;
    }

    public void setScale(float aux){
        scale = aux;
    }

}
