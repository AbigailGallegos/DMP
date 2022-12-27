package com.example.animacionxml;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textos [];
    Animation animaciones [];
    AnimationSet as;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textos = new TextView[5];
        textos[0]= (TextView) findViewById( R.id.txt1);
        textos[1]= (TextView) findViewById( R.id.txt2);
        textos[2]= (TextView) findViewById( R.id.txt3);
        textos[3]= (TextView) findViewById( R.id.txt4);
        textos[4]= (TextView) findViewById( R.id.txt5);

        animaciones  = new Animation[5];
        animaciones[0] = AnimationUtils.loadAnimation(this,R.anim.traslacion);
        animaciones[1] = AnimationUtils.loadAnimation(this,R.anim.rotacion);
        animaciones[2] = AnimationUtils.loadAnimation(this,R.anim.transparencia);
        animaciones[3] = AnimationUtils.loadAnimation(this,R.anim.escalamiento);
        // Secuencia de animaciones
        animaciones[4]= AnimationUtils.loadAnimation(this,R.anim.animaciones);

        for( Animation animacion : animaciones){
            animacion.setFillAfter(true);
            animacion.setRepeatMode(Animation.REVERSE);
            animacion.setRepeatCount(6);
            textos[i].startAnimation(animacion);
            i++;
        }
    }


}

