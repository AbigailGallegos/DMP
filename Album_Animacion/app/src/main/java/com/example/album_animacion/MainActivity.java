package com.example.album_animacion;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView tvnombre;
    ImageView foto;
    AnimationDrawable animacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.btnPlay);
        Button btn2 = (Button) findViewById(R.id.btnStop);

        foto = (ImageView) findViewById(R.id.imageView);
        foto.setBackgroundResource(R.drawable.animacion_fotos);
        animacion= new AnimationDrawable();
        animacion = (AnimationDrawable) foto.getBackground();
        foto.setImageDrawable(animacion);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnPlay)
            animacion.start();
        else
            animacion.stop();
    }
}