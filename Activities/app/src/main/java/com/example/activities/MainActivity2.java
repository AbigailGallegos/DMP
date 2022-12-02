package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    public static final String msg = "mensaje";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView txt1 = (TextView) findViewById(R.id.txt1);
        String  mensaje = getIntent().getStringExtra("mensaje");
        txt1.append("\n\n" + mensaje);

    }
}