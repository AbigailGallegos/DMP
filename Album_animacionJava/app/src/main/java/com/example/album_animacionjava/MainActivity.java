package com.example.album_animacionjava;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    AnimationDrawable animacion;
    ImageView foto;
    Button btn1,btn2;
    int t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foto = (ImageView) findViewById(R.id.imageView);
        btn1 = (Button) findViewById(R.id.btnPlay);
        btn2 = (Button) findViewById(R.id.btnStop);
        t=200;
        animacion = new AnimationDrawable();

        animacion.addFrame(getResources().getDrawable(R.drawable.c1),t);
        animacion.addFrame(getResources().getDrawable(R.drawable.c2),t);
        animacion.addFrame(getResources().getDrawable(R.drawable.c3),t);
        animacion.addFrame(getResources().getDrawable(R.drawable.c4),t);
        animacion.addFrame(getResources().getDrawable(R.drawable.c5),t);
        animacion.addFrame(getResources().getDrawable(R.drawable.c6),t);
        animacion.addFrame(getResources().getDrawable(R.drawable.c7),t);
        animacion.addFrame(getResources().getDrawable(R.drawable.c9),t);
        animacion.addFrame(getResources().getDrawable(R.drawable.c10),t);
        animacion.addFrame(getResources().getDrawable(R.drawable.c11),t);
        animacion.addFrame(getResources().getDrawable(R.drawable.c12),t);
        animacion.addFrame(getResources().getDrawable(R.drawable.c13),t);

        animacion.setOneShot(false);
        foto.setImageDrawable(animacion);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnPlay)
            animacion.start();
        else
            animacion.stop();

    }
}