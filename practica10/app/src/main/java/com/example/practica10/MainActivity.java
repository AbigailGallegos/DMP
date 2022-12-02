package com.example.practica10;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    int colors [] = {Color.rgb(240,238,232),Color.rgb(171,225,136),Color.rgb(247,239,153) ,Color.rgb(241,187,135),Color.rgb(247,142,105) ,Color.rgb(93,103,91) };





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Vistagraficos graficas = new Vistagraficos(this);
        setContentView(graficas);

    }

    public class Vistagraficos extends View{
        public Vistagraficos(Context context) {
            super(context);
        }



        @Override protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint pintura = new Paint();
            pintura.setColor(colors[0]);
            canvas.drawPaint(pintura);


            int ancho, alto;
            ancho = canvas.getWidth();
            alto = canvas.getHeight();

            int ex = 50;
            pintura.setStrokeWidth(ex);
            //Lineas
            for (int color : colors) {
                pintura.setColor(color);
                canvas.drawLine(ex - 30, 0, ex, (float) alto, pintura);
                ex += 50;
            }


            //Rectangulo
            pintura.setColor(colors[1]);
            canvas.save();
            canvas.rotate(-30);
            RectF rectangulo = new RectF(300, 150, 800, 550);
            canvas.drawRect(rectangulo, pintura);
            canvas.restore();

            //Círculo
            pintura.setColor(colors[3]);
            canvas.drawCircle(700, 535, 200, pintura);

            //Trayectoria
            pintura.setTextSize(40);
            Path trazo = new Path();
            trazo.addCircle(ancho/2, alto/2 + 300, 300, Path.Direction.CCW);//CCW en contra de las manecillas
            pintura.setColor(colors[5]);
            canvas.drawTextOnPath("Práctica 10 Canvas Práctica 10 Canvas Práctica 10 Canvas Práctica 10 Canvas    ", trazo, 0,0, pintura);



        }
    }
}


