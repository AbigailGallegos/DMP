package com.example.hilos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt1;
    Controlador control = new Controlador();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = (TextView) findViewById(R.id.txt1);
        Hilo hilo1= new Hilo(10,1000);
        Hilo hilo2= new Hilo(5,2000);
        hilo1.setName("Hilo principal");
        hilo2.setName("Hilo secundario");
        hilo1.start();
        hilo2.start();
    }

    class Controlador extends Handler{
        @Override
        public void handleMessage (Message msg){
            int entero;
            String nombreHilo;
            entero= msg.getData().getInt("contador");
            nombreHilo = msg.getData().getString("nombre");
            txt1.append(("\n" + entero + " Nombre= " + nombreHilo));
        }
    }

    class Hilo extends Thread{
        int max,tiempo;

        Hilo(int m, int t){
            max=m;
            tiempo=t;
        }

        @Override
        public void run(){
            for(int i=0; i<=max;i++) {
                try {
                    Thread.sleep(tiempo);
                } catch (InterruptedException e) {
                    ;
                }

                Message msg1 = new Message();
                Bundle b = new Bundle();
                b.putInt("contador", i);
                b.putString("nombre", getName() );
                msg1.setData(b);
                //control.sendMessage(msg1);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txt1.append("\n" + b.getInt("controlador") + "Nombre= " + b.getString("nombre"));
                    }
                });
            }
        }
    }

}