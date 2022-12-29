package com.example.animacionesjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.LayoutAnimationController;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    TextView tv1;
    AnimationSet animaciones;
    Animation anim1, anim2;
    LinearLayout ly1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "aqui estoy en el oncreate", Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_main);
        ly1 = (LinearLayout) findViewById(R.id.ly1);
        tv1 = (TextView) findViewById(R.id.texto1);//tv1.startAnimation(anim2);
        //Animation de traslación

        int rs1 = TranslateAnimation.RELATIVE_TO_SELF;
        anim1 = new TranslateAnimation(rs1, 1f, rs1, 0f, rs1, 0f, rs1, 0f);
        anim1.setDuration(2000);
        anim1.setInterpolator(new LinearInterpolator());
        anim1.setFillAfter(true);
        anim1.setAnimationListener(this);

        //Animación de escalamiento
        int rs2 = ScaleAnimation.RELATIVE_TO_SELF;
        anim2 = new ScaleAnimation(1, 2, 1, 2, rs2, 0f, rs2, 0f);
        anim2.setDuration(1000);
        anim2.setInterpolator(new BounceInterpolator());
        anim2.setFillAfter(true);


        //Animación combinada
        animaciones = new AnimationSet(true);
        animaciones.addAnimation(anim1);
        animaciones.addAnimation(anim2);

        //Creando el objeto Layout Animation
        LayoutAnimationController controlAnmacion = new LayoutAnimationController(anim1);
        controlAnmacion.setDelay(1);
        controlAnmacion.setOrder(LayoutAnimationController.ORDER_NORMAL);
        ly1.setLayoutAnimation(controlAnmacion);

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        tv1.setText("FIN");
        tv1.startAnimation(animaciones);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

}



