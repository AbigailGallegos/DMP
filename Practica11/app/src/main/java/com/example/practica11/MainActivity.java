package com.example.practica11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout ly1 = (LinearLayout) findViewById(R.id.ly1);
        TextView txt1 = (TextView) findViewById(R.id.txt1);

        Rect rectangulo = new Rect();
        ly1.getWindowVisibleDisplayFrame(rectangulo);
        int ancho, alto;
        ancho = rectangulo.width();
        alto = rectangulo.height();
        int color [] =  { Color.parseColor("#638475"),Color.parseColor("#90E39A"),Color.parseColor("#DDF093"),Color.parseColor("#F6D0B1"),Color.parseColor("#CE4760")};
        String texto  []= {"IPN" ,"Telemática", "Dispositivos Móviles Programables","Diana Gallegos", "Grupo 2TM19"};
        txt1.append("\nUPIITA");

        VistaGrafico vista [] = new VistaGrafico[6];
        LinearLayout.LayoutParams parametros= new LinearLayout.LayoutParams(ancho, 300);


        for (int i=0;i<5 ;i++){
            vista[i] = new VistaGrafico(this, color[i],texto[i],80,i);
            vista[i].setLayoutParams(parametros);
            ly1.addView(vista[i]);
        }

    }

    public class VistaGrafico extends View {
        int color;
        String texto;
        int x, y,tam;

        public VistaGrafico(Context context, int color, String texto, int tam, int x) {
            super(context);
            this.color = color;

            this.texto = texto;
            this.x = 150 + 50*x;
            this.y = 100 + 55*x;
            this.tam = tam;
        }

        @Override protected void onDraw(Canvas canvas){
            super.onDraw(canvas);

            canvas.drawColor(color);
            Paint pintura = new Paint();
            pintura.setTextSize(tam);
            pintura.setColor(Color.WHITE);

            if (texto.contains("\n")){
                String[] txt = texto.split("\n");
                for (String lineas:txt){
                    canvas.drawText(lineas, x, y, pintura);
                    y += pintura.getTextSize();
                }
            }else{
                canvas.drawText(texto, x, y, pintura);
            }

        }
    }
}