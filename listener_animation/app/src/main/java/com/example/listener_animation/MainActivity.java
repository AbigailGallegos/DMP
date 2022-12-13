package com.example.listener_animation;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  Animation.AnimationListener{

    TextView txt1;
    Button boton1;
    Animation escalamiento,transparencia,traslacion,animboton;
    int i=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = (TextView) findViewById(R.id.texto1);
        boton1= (Button) findViewById(R.id.boton1);
        txt1.setText( "Contador = " + i);


        //Animación de transparencia (Aparición)
        transparencia = new AlphaAnimation(0,1);
        transparencia.setInterpolator( new LinearInterpolator());
        transparencia.setDuration(2000);
        transparencia.setRepeatMode(Animation.RESTART);
        transparencia.setRepeatCount(10);
        txt1.startAnimation(transparencia);

        //Animacion de escalamiento
        int rs= ScaleAnimation.RELATIVE_TO_SELF;
        escalamiento = new ScaleAnimation(1,2,1,5,rs,0.5f,rs,0.5f);
        escalamiento.setDuration(5000);
        escalamiento.setInterpolator(new LinearInterpolator());
        escalamiento.setFillAfter(true);
        //txt1.startAnimation(escalamiento);

        //Animación de traslación
        int rs2 = TranslateAnimation.RELATIVE_TO_SELF;
        traslacion = new TranslateAnimation(rs2, 0, rs2, 0, rs2, 0, rs2, 0.3f);
        traslacion.setDuration(10000);
        traslacion.setInterpolator(new BounceInterpolator());
        traslacion.setFillAfter(true);
        //txt1.startAnimation(traslacion);

        //Animación del botón
        animboton = new ScaleAnimation(1,1,0,1);
        animboton.setInterpolator(new BounceInterpolator () );
        animboton.setFillAfter(true);
        animboton.setDuration(500);
        animboton.setRepeatMode(AnimationSet.RESTART);
        animboton.setRepeatCount(1);

        transparencia.setAnimationListener(this);
        escalamiento.setAnimationListener(this);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boton1.startAnimation(animboton);
            }
        });

    }

    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == transparencia){
            txt1.setText("BOOM!");
            txt1.startAnimation(escalamiento);
        }
        if (animation == escalamiento){
            txt1.startAnimation(traslacion);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        if (animation == transparencia){
            i--;
            txt1.setText("Contador= " + i);
        }

    }
}