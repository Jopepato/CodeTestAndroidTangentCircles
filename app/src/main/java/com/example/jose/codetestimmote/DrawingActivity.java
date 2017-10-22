package com.example.jose.codetestimmote;

import android.app.Activity;
import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Jose on 22/10/2017.
 */



public class DrawingActivity extends Activity{

    static {
        System.loadLibrary("native-lib");
    }

    private Button buttonDraw;
    private CustomView customView;
    private TextView scaleText;
    private TextView radius4Text, radius5Text;
    private float r1, r2, r3, scale;
    private int count=1;
    Circle circle1, circle2, circle3, circle4, circle5;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);
        buttonDraw = (Button)findViewById(R.id.buttonDraw);
        customView = (CustomView)findViewById(R.id.customView);
        scaleText = (TextView)findViewById(R.id.scaleText);
        radius4Text = (TextView)findViewById(R.id.textViewRadius4);
        radius5Text = (TextView)findViewById(R.id.textViewRadius5);

        scaleText.setText(scaleText.getText().toString() + getIntent().getExtras().getFloat("Scale") + "x");

        //We get the extras from the bundle
        r1 = getIntent().getExtras().getFloat("R1");
        r2 = getIntent().getExtras().getFloat("R2");
        r3 = getIntent().getExtras().getFloat("R3");
        scale = getIntent().getExtras().getFloat("Scale");
        circle1 = new Circle(r1);
        circle2 = new Circle(r2);
        circle3 = new Circle(r3);
        circle4 = new Circle();
        circle5 = new Circle();
        calculateCoordinates(circle1, circle2, circle3);

        customView.setCircle1(circle1);
        customView.setCircle2(circle2);
        customView.setCircle3(circle3);
        customView.setScale(scale);

        calculateTangentCirclesSameLine(circle1, circle2, circle3, circle4, circle5);

        customView.setCircle4(circle4);
        customView.setCircle5(circle5);

        buttonDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==1) {
                    customView.drawCircles();
                    buttonDraw.setText("Draw Tangents!");
                    count--;
                }else if(count == 0){
                    customView.drawTangentCircles();
                    //Set the texts of the radius
                    radius4Text.setText("R4: " + String.format("%.2g%n", circle4.getRadius()));
                    radius5Text.setText("R5: " + String.format("%.2g%n", circle5.getRadius()));

                }
            }
        });
    }


    public native void calculateCoordinates(Circle circle1, Circle circle2, Circle circle3);
    public native void calculateTangentCirclesSameLine(Circle circle1, Circle circle2, Circle circle3, Circle circle4, Circle circle5);
}
