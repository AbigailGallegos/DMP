package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txt1, txtDisplay;
    Button [] buttonsArray;
    ImageButton [] ibuttonsArray;
    String str,str2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDisplay = new TextView(this);
       /* buttonsArray = new Button [11];
        ibuttonsArray = new ImageButton [10];

        txtDisplay = (TextView)findViewById(R.id.txtDisplay);

        buttonsArray[0] = (Button) findViewById(R.id.btn20);
        buttonsArray[1] = (Button) findViewById(R.id.btn21);
        buttonsArray[2] = (Button) findViewById(R.id.btn22);
        buttonsArray[3] = (Button) findViewById(R.id.btn30);
        buttonsArray[4] = (Button) findViewById(R.id.btn31);
        buttonsArray[5] = (Button) findViewById(R.id.btn32);
        buttonsArray[6] = (Button) findViewById(R.id.btn40);
        buttonsArray[7] = (Button) findViewById(R.id.btn41);
        buttonsArray[8] = (Button) findViewById(R.id.btn42);
        buttonsArray[9] = (Button) findViewById(R.id.btn51);
        buttonsArray[10] = (Button) findViewById(R.id.btn52);

       /* ibuttonsArray[0] = (ImageButton) findViewById(R.id.btn03);
        ibuttonsArray[1] = (ImageButton) findViewById(R.id.btn10);
        ibuttonsArray[2] = (ImageButton) findViewById(R.id.btn11);
        ibuttonsArray[3] = (ImageButton) findViewById(R.id.btn12);
        ibuttonsArray[4] = (ImageButton) findViewById(R.id.btn13);
        ibuttonsArray[5] = (ImageButton) findViewById(R.id.btn23);
        ibuttonsArray[6] = (ImageButton) findViewById(R.id.btn33);
        ibuttonsArray[7] = (ImageButton) findViewById(R.id.btn43);
        ibuttonsArray[8] = (ImageButton) findViewById(R.id.btn50);
        ibuttonsArray[9] = (ImageButton) findViewById(R.id.btn53);]*/

        for (Button boton : buttonsArray)
            boton.setOnClickListener(this);

        //for (ImageButton boton : ibuttonsArray)
        //boton.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        str = ((TextView) view).getText().toString();
        //str2 = str2 + " " + str  ;
        txtDisplay.setText(str);


    }


}