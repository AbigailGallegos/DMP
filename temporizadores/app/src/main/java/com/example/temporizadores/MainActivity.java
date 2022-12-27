package com.example.temporizadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    TextView txt1, txt2;
    int contador1=0, contador2=0,contador ;
    Timer temporizador1, temporizador2;
    Tarea tarea1, tarea2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        temporizador1 = new Timer("temp1");
        temporizador2 = new Timer("temp2");
        tarea1 = new Tarea(txt1);
        tarea2 = new Tarea(txt2);

        temporizador1.scheduleAtFixedRate(tarea1,0,1000);
        temporizador2.scheduleAtFixedRate(tarea2,5000,500);

    }

    class Tarea extends TimerTask{
        TextView tv;

        public Tarea(TextView textView){
            tv = textView;
        }
        @Override
        public void run (){
            Programa miPrograma = new Programa(tv);
            tv.post(miPrograma);
        }
    }

    class Programa implements Runnable{
        TextView tv;

        public Programa (TextView textView){
            tv = textView;
        }

        @Override
        public void run (){
            if (tv.getId() == R.id.txt1){
                contador1++;
                contador=contador1;
            }
            if (tv.getId() == R.id.txt2){
                contador2++;
                contador=contador2;
            }
            tv.setText("Contador= " + contador);
            if (contador1 == 20)
                temporizador1.cancel();
            if (contador2 == 50)
                temporizador2.cancel();
        }
    }

}