package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String mensaje;
    double [] arregloDouble = new double[10];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = (Button) findViewById(R.id.bt1);
        btn1.setOnClickListener(this);

        mensaje="Bienvenido a la actividad 2";

        for (int i=0 ; i<10 ; i++){

        }
    }

    @Override
    public void onClick(View view){
        Intent intencion = new Intent(this,MainActivity2.class);
        intencion.putExtra(MainActivity2.msg,mensaje);
        startActivity(intencion);
        Toast.makeText(this,"Cambiando al Activity 2",Toast.LENGTH_LONG).show();

    }
}