package com.example.listener;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int textViewCount = 6;
    int editViewCount = 6;
    TextView txt[] = new TextView[textViewCount];
    EditText edt[] = new EditText[editViewCount];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_main);



        for(int i = 0; i < textViewCount; i++) {
            txt[i] = new TextView(this);
        }

        for(int i = 0; i < editViewCount; i++) {
            edt[i] = new EditText(this);
        }

        txt[0] = (TextView) findViewById(R.id.txt1);
        txt[1] = (TextView) findViewById(R.id.txt2);
        txt[2] = (TextView) findViewById(R.id.txt3);
        txt[3] = (TextView) findViewById(R.id.txt4);
        txt[4] = (TextView) findViewById(R.id.txt5);
        txt[5] = (TextView) findViewById(R.id.txt6);

        edt[0] = (EditText) findViewById(R.id.edt1);
        edt[1] = (EditText) findViewById(R.id.edt2);
        edt[2] = (EditText) findViewById(R.id.edt3);
        edt[3] = (EditText) findViewById(R.id.edt4);
        edt[4] = (EditText) findViewById(R.id.edt5);

        edt[2].setInputType(InputType.TYPE_CLASS_NUMBER);
        edt[3].setInputType(InputType.TYPE_CLASS_DATETIME);
        edt[4].setInputType(InputType.TYPE_NUMBER_VARIATION_PASSWORD);

        Button btnn1 = (Button) findViewById(R.id.btn1);
        btnn1.setOnClickListener(this);


        edt[5].setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                    txt[6].setText("Bienvenido " + edt[0].getText().toString() + " " + edt[1].getText().toString() + " on Key ");
                    Toast.makeText(getApplicationContext(), "Desde el on Key", Toast.LENGTH_LONG).show();
                    return true;
                }

                return false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onSStop", Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onDestroy() {
        Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_LONG).show();

        super.onDestroy();
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart", Toast.LENGTH_LONG).show();
    }
}




   /* @Override
    public void onClick(View view) {
        txt3.setText("Bienvenido " + edt1.getText().toString() +  " " +edt2.getText().toString() );
        Toast.makeText(getApplicationContext(),"Desde el botón",Toast.LENGTH_LONG).show();
    }
}*/