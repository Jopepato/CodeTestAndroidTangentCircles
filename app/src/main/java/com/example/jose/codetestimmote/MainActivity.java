package com.example.jose.codetestimmote;

import android.content.Intent;
import android.support.annotation.FloatRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonDraw;
    private EditText editTextRadius1, editTextRadius2, editTextRadius3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //We have to get the editTexts and Button
        buttonDraw = (Button) findViewById(R.id.buttonDraw);
        editTextRadius1 = (EditText)findViewById(R.id.editTextRadius1);
        editTextRadius2 = (EditText)findViewById(R.id.editTextRadius2);
        editTextRadius3 = (EditText)findViewById(R.id.editTextRadius3);

        editTextRadius3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(checkEditTexts()){
                    buttonDraw.setEnabled(true);
                }else{
                    buttonDraw.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(checkEditTexts()){
                    buttonDraw.setEnabled(true);
                }else{
                    buttonDraw.setEnabled(false);
                }
            }
        });

        editTextRadius2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(checkEditTexts()){
                    buttonDraw.setEnabled(true);
                }else{
                    buttonDraw.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(checkEditTexts()){
                    buttonDraw.setEnabled(true);
                }else{
                    buttonDraw.setEnabled(false);
                }
            }
        });

        editTextRadius1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(checkEditTexts()){
                    buttonDraw.setEnabled(true);
                }else{
                    buttonDraw.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(checkEditTexts()){
                    buttonDraw.setEnabled(true);
                }else{
                    buttonDraw.setEnabled(false);
                }
            }
        });

        buttonDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float r1 = Float.valueOf(editTextRadius1.getText().toString());
                float r2 = Float.valueOf(editTextRadius2.getText().toString());
                float r3 = Float.valueOf(editTextRadius3.getText().toString());
                checkRadius(r1, r2, r3);

            }
        });

    }

    private void checkRadius(float r1, float r2, float r3){
        //Check if the radius fulfills the condition r1 = r2 + r3;
        if(r1 == (r2+r3)){
            //We change the activity to the drawing one, passing this values into a bundle
            Intent mIntent = new Intent(this, DrawingActivity.class);
            Bundle mBundle = new Bundle();
            mBundle.putFloat("R1", r1);
            mBundle.putFloat("R2", r2);
            mBundle.putFloat("R3", r3);
            mIntent.putExtras(mBundle);
            startActivity(mIntent);
        }else{
            //We tell the user that the radius must fulfill the condition
            Toast toast = Toast.makeText(this, "The radius must fulfill the condition r1=r2+r3", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private boolean checkEditTexts(){
        //Check if the three editTexts have some values inside
        String textRadius1 = editTextRadius1.getText().toString();
        String textRadius2 = editTextRadius2.getText().toString();
        String textRadius3 = editTextRadius3.getText().toString();

        if(textRadius1.isEmpty() || textRadius2.isEmpty() || textRadius3.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
