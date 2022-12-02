package com.example.practica12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    float x[] = {300, 300,800,400};
    float y[] = {600, 800,1700,1000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        Vistagrafico mivista = new Vistagrafico(this);
        setContentView(mivista);
    }

    class Vistagrafico extends
            View {


        float radio[] = {60, 100, 200,120};
        int seleccion = -1;
        String txtEvento = "Evento";

        Vistagrafico(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            int color [] =  { Color.parseColor("#FBE285"),Color.parseColor("#F86624"),Color.parseColor("#EA3546"),Color.parseColor("#662E9B"),Color.parseColor("#43BCCD")};
            canvas.drawColor(color[0]);

            Paint paint[] = new Paint[4];
            for(int i=0 ; i<4;i++){
                paint[i] = new Paint();
                LinearGradient gradient = new LinearGradient(0, 0, 0, getHeight(),color[i+1], Color.TRANSPARENT, Shader.TileMode.CLAMP);
                paint[i].setDither(true);
                paint[i].setShader(gradient);
                paint[i].setColor(color[i+1]);
                canvas.drawCircle(x[i],
                        y[i], radio[i], paint[i]);
            }

            Paint paint2 = new Paint();
            paint2.setColor(Color.BLACK);
            paint2.setTextSize(60);
            paint2.setStyle(Paint.Style.FILL_AND_STROKE);

            canvas.drawText("Selecciona un circulo", 100, 80, paint2);
            for (int i =0 ; i<4 ;i++){
                canvas.drawText("x" + i + "= " + x[i] + "         y"+ i + "= " + y[i], 100 , 150 + 80*i, paint2);
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent Evento) {

            float nx = Evento.getX();
            float ny = Evento.getY();
            float distancia;

            if (Evento.getAction() == MotionEvent.ACTION_DOWN) {
                seleccion = -1;
                for (int i = 0; i < 4; i++) {
                    distancia = (float) Math.sqrt( (nx - x[i]) * (nx - x[i]) + (ny - y[i]) * (ny - y[i]));
                    if (distancia < radio[i]) {
                        seleccion = i;
                        invalidate();
                    }
                }
            }
            if (Evento.getAction() == MotionEvent.ACTION_UP) {}

            if (Evento.getAction() == MotionEvent.ACTION_MOVE) {
                if (seleccion != -1) {
                    x[seleccion] = nx;
                    y[seleccion] = ny;
                     invalidate();
                }
            }
            return true;
        }
    }
}