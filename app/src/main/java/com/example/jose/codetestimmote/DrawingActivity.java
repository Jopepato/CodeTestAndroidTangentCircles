package com.example.jose.codetestimmote;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Jose on 22/10/2017.
 */

public class DrawingActivity extends AppCompatActivity {

    private float r1, r2, r3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);

        r1 = getIntent().getExtras().getFloat("R1");
        r2 = getIntent().getExtras().getFloat("R2");
        r3 = getIntent().getExtras().getFloat("R3");


    }
}
