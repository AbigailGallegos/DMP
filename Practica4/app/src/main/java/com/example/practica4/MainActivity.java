package com.example.practica4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView; import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout line1 = (LinearLayout) findViewById(R.id.line1);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.montserrat);
        //Parametros para la imagen 1
        LinearLayout.LayoutParams paramIm1 = new LinearLayout.LayoutParams(1080, 590);

        int textViewCount = 10;
        TextView[] textViewArray = new TextView[textViewCount];

        for (int i = 0; i < textViewCount; i++) {
            textViewArray[i] = new TextView(this);
        }

        addTxt(line1, "INSTITUTO POLITÉCNICO NACIONAL", 30, "#FFFFFFFF", "#13322B");
        addTxt(line1, "Unidad Profesional Interdisciplinaria en Ingeniería y Tecnologías Avanzadas", 14, "#FFFFFFFF", "#333333");
        addTxt(line1, "Ingeniería Telemática", 30, "#6C1C43", "#FFFFFFFF");


        LinearLayout.LayoutParams paramtv1 = new LinearLayout.LayoutParams(100, 600);
        paramtv1.height = 0;
        paramtv1.weight = 1;
        paramtv1.width = LinearLayout.LayoutParams.MATCH_PARENT;


        for (int i = 0; i < textViewCount; i++) {
            textViewArray[i].setLayoutParams(paramtv1);
            textViewArray[i].setTypeface(typeface);
            line1.addView(textViewArray[i]);
        }


        ImageView imag_tele = new ImageView(this);
        ImageView imag_upi = new ImageView(this);
        imag_tele.setImageResource(R.drawable.telematica);
        imag_upi.setImageResource(R.drawable.upiita);
        //Parámetros de la imagen 1
        paramIm1.width = LinearLayout.LayoutParams.MATCH_PARENT;
        imag_tele.setLayoutParams(paramIm1);
        line1.addView(imag_tele);
        addTxt(line1, "Programación de Dispositivos Móviles", 20, "#FFFFFFFF", "#6C1C43");
        addTxt(line1, "Bermudez Sosa Jose Alfredo", 20, "#FFFFFFFF", "#333333");
        addTxt(line1, "Grupo: 2TM19", 20, "#FFFFFFFF", "#13322B");
        addTxt(line1, "Práctica 1", 20, "#000000", "#BDB6BC");
        addTxt(line1, "Diana Abigail Gallegos Ruiz", 20, "#000000", "#F0F0F0");
        line1.addView(imag_upi);
        imag_upi.setLayoutParams(paramIm1);
    }


    public void addTxt(LinearLayout ly1, String txt1, int tam, String color,String colorback) {
        TextView tv = new TextView(this);
        tv.setText(txt1);
        tv.setTextSize(tam);
        tv.setTextColor(Color.parseColor(color));
        tv.setGravity(Gravity.CENTER);
        tv.setBackgroundColor(Color.parseColor(colorback));
        ly1.addView(tv);

    }

}

