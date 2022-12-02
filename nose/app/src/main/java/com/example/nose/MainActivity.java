package com.example.nose;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt1;
    Animation escalamiento,transparencia;
    int i=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = (TextView) findViewById(R.id.texto1);

        //Animación de transparencia (Aparición)
        transparencia = new AlphaAnimation(0,1);
        transparencia.setInterpolator( new LinearInterpolator());
        transparencia.setDuration(2000);
        transparencia.setRepeatMode(Animation.RESTART);
        transparencia.setRepeatCount(10);
        txt1.startAnimation(transparencia);
    }
}