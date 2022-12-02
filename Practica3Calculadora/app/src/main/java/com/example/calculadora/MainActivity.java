package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout  line1 = (LinearLayout) findViewById(R.id.line1);
    }

    @Override
    public void onClick(View view) {

    }

    public  void  addTxt(LinearLayout  ly1 , String  txt1 , int tam , String color ,String  colorback) {
        TextView tv = new  TextView(this);
        tv.setText(txt1);
        tv.setTextSize(tam);
        tv.setTextColor(Color.parseColor(color));
        tv.setGravity(Gravity.CENTER);
        tv.setBackgroundColor(Color.parseColor(colorback));
    }

}