package com.example.jose.codetestimmote;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Jose on 22/10/2017.
 */

public class DrawingActivity extends Activity{

    private Button buttonDraw;
    private CustomView customView;
    private TextView scaleText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);
        buttonDraw = (Button)findViewById(R.id.buttonDraw);
        customView = (CustomView)findViewById(R.id.customView);
        scaleText = (TextView)findViewById(R.id.scaleText);

        scaleText.setText(scaleText.getText().toString() + getIntent().getExtras().getFloat("Scale") + "x");


        buttonDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customView.drawCircles();
            }
        });
    }
}
