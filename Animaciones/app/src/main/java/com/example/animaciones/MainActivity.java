package com.example.animaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvnombre;
    Button boton1;
    Button boton2;
    ImageView foto;
    int i = 0;
    int total_fotos ;
    int[] id_foto = {R.drawable.f1 , R.drawable.f2, R.drawable.f3, R.drawable.f4,R.drawable.f5,R.drawable.f6, R.drawable.f7, R.drawable.f8, R.drawable.f9,R.drawable.f10 };
    String[] nombrefoto = {"Fondo de pantalla 1", "Fondo de pantalla 2", "Fondo de pantalla 3", "Fondo de pantalla 4", "Fondo de pantalla 5" , "Fondo de pantalla 6", "Fondo de pantalla 7", "Fondo de pantalla 8" , "Fondo de pantalla 9","Fondo de pantalla 10" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Color.parseColor() method allow us to convert
        // a hexadecimal color string to an integer value (int color)
        // int[] colors = {Color.parseColor("#008000"), Color.parseColor("#ADFF2F")};

        int color = Color.parseColor("#ADFF2F");
        //create a new gradient color
        //GradientDrawable gd = new GradientDrawable(
        //        GradientDrawable.Orientation.TOP_BOTTOM, colors);

        //gd.setCornerRadius(0f);
        //apply the button background to newly created drawable gradient
        Button btn = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        //btn.setBackground(getResources().getDrawable(R.drawable.gradient));


        tvnombre = (TextView) findViewById(R.id.txtName);
        boton1 = (Button) findViewById(R.id.btn1);
        boton2 = (Button) findViewById(R.id.btn2);
        foto = (ImageView) findViewById(R.id.imageView);
        foto.setImageResource(id_foto[0]);
        tvnombre.setText(nombrefoto[0]);
        total_fotos = id_foto.length;
        boton1.setOnClickListener((View.OnClickListener) this);
        boton2.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn2) {
            i++;
            if (i == total_fotos)
                i = 0;
        }

        if (view.getId() == R.id.btn1){
            i--;
            if (i == -1)
                i = total_fotos - 1;
        }

        foto.setImageResource(id_foto[i]);
        tvnombre.setText(nombrefoto[i]);
    }
}
