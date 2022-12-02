package com.example.ciclodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView txt1,txt2,txt3,txt4;
    EditText edt1,edt2;

    SharedPreferences myData;
    String user,password;
    CheckBox cbox1;
    Button btnn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getApplicationContext(),"onCreate",Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_main);


        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3= (TextView) findViewById(R.id.txt3);
        txt4 = (TextView) findViewById(R.id.txt4);

        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);

        cbox1 = (CheckBox) findViewById(R.id.cbox1);

        btnn1 = (Button) findViewById(R.id.btn1);
        btnn1.setOnClickListener(this);

        myData = getSharedPreferences("preferencias",0);
        user = myData.getString("name","Nuevo Usuario");
        password = myData.getString("surname","Contraseña");


        edt1.setText(user);
        edt2.setText(password);


    }

    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(getApplicationContext(),"onStart",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(getApplicationContext(),"onResume",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause(){
        super.onPause();
       Toast.makeText(getApplicationContext(),"onPause",Toast.LENGTH_LONG).show();
        SharedPreferences.Editor miEditor = myData.edit();
        user=edt1.getText().toString();
        password=edt2.getText().toString();
        miEditor.putString("name",user);
        miEditor.putString("surname",password);
        miEditor.commit();
    }

    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(getApplicationContext(),"onSStop",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_LONG).show();
        if (cbox1.isChecked() == true){
            myData.edit().clear().commit();
            edt2.setText(" ");
        }
        super.onDestroy();
    }


    @Override
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(getApplicationContext(),"onRestart",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        txt4.setText("Bienvenido " + edt1.getText().toString() );
    }

}