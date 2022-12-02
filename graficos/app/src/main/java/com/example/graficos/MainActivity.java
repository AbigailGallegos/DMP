package com.example.graficos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        Vistagraficos graficas = new Vistagraficos(this);
        setContentView(graficas);
    }

    public class Vistagraficos extends View {

            public Vistagraficos(Context context) {
                super(context);
            }

            @Override protected void onDraw (Canvas canvas){
                super.onDraw(canvas);
                Paint pintura = new Paint();
                pintura.setColor(Color.BLACK);
                canvas.drawPaint(pintura);
                pintura.setColor(Color.BLACK);
                pintura.setTextSize(80);
                canvas.drawText("HOLA MUNDO :D",80,80,pintura);

                int ancho,alto;
                ancho=canvas.getWidth();
                alto=canvas.getHeight();
                canvas.drawText("ancho= " + ancho + "alto=" + alto,80,180,pintura);
                pintura.setColor(Color.YELLOW);
                pintura.setTextAlign(Paint.Align.CENTER);

                canvas.drawText("IPN",ancho/2,alto/2,pintura);
                pintura.setColor(Color.WHITE);
                pintura.setStrokeWidth(10);
                pintura.setStyle(Paint.Style.STROKE);
                canvas.drawCircle(ancho/2,alto/2,300,pintura);
                canvas.drawLine(50,0,50,(float) alto,pintura);

                pintura.setColor(Color.LTGRAY);
                Path trazo = new Path();
                trazo.addCircle(ancho/2,alto/2,300, Path.Direction.CW);
                canvas.drawTextOnPath("INSTITUTO POLITECNICO NACIONAL",trazo,300,-50,pintura);


            }

        }
}
