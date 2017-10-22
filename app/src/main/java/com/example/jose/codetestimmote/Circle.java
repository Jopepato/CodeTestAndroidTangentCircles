package com.example.jose.codetestimmote;

/**
 * Created by Jose on 22/10/2017.
 */

public class Circle {

    private float radius_;
    private float centerX_;
    private float centerY_;

    public Circle(float radius, float centerX, float centerY){
        setRadius(radius);
        setCenterX(centerX);
        setCenterY(centerY);
    }

    public float getRadius(){
        return radius_;
    }

    public void setRadius(float radius){
        radius_ = radius;
    }

    public float getCenterX(){
        return centerX_;
    }

    public void setCenterX(float centerX){
        centerX_ = centerX;
    }

    public float getCenterY(){
        return centerY_;
    }

    public void setCenterY(float centerY){
        centerY_ = centerY;
    }
}
