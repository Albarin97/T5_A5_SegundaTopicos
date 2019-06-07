package com.example.actividad5_aplicacinandroid2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner1, spinner2;
    EditText Etext1, Etext2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinner1 = findViewById(R.id.spinner_ing);
        spinner2 = findViewById(R.id.spinner_res);
        Etext1 = findViewById(R.id.Etext_ing);
        Etext2 = findViewById(R.id.Etext_res);

        String Opciones[] = {"Centigrados", "fahrenheit", "kelvin","rankine"};
        ArrayAdapter adaptador2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Opciones);
        spinner1.setAdapter(adaptador2);
        spinner2.setAdapter(adaptador2);
        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        conversion();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void conversion(){
       String spi1= spinner1.getSelectedItem().toString();
       String spi2= spinner2.getSelectedItem().toString();
       int ingresado = Integer.parseInt(Etext1.getText().toString());
       if (spinner1.equals("Centigrados")){
           if (spinner1.equals("Centigrados") && spinner2.equals("Centigrados")){
               Etext2.setText(""+ingresado);
           }else if (spinner1.equals("Centigrados") && spinner2.equals("fahrenheit")){
               Etext2.setText(""+(((ingresado* 9)/5) + 32));
           }else if (spinner1.equals("Centigrados") && spinner2.equals("kelvin")){
               Etext2.setText((ingresado+273.15)+"");
           }else if (spinner1.equals("Centigrados") && spinner2.equals("rankine")){
               Etext2.setText(""+((ingresado*9)/5 + 491.67));
           }
       }else if (spinner1.equals("fahrenheit")){
           if (spinner1.equals("fahrenheit") && spinner2.equals("fahrenheit")){
               Etext2.setText(""+ingresado);
           }else if (spinner1.equals("fahrenheit") && spinner2.equals("Centigrados")){
               Etext2.setText(""+(((ingresado-32) * 5)/9));
           }else if (spinner1.equals("fahrenheit") && spinner2.equals("kelvin")){
               Etext2.setText(""+((((ingresado-32) * 5)/9)+273.15));
           }else if (spinner1.equals("fahrenheit") && spinner2.equals("rankine")){
               Etext2.setText(""+(ingresado+ 459.67));
           }
       }else if (spinner1.equals("rankine")){
           if (spinner1.equals("rankine") && spinner2.equals("rankine")){
               Etext2.setText(""+ingresado);
           }else if (spinner1.equals("rankine") && spinner2.equals("Centigrados")){
               Etext2.setText(""+((ingresado-491.67)*5/9));
           }else if (spinner1.equals("rankine") && spinner2.equals("fahrenheit")){
               Etext2.setText(""+(ingresado-459.67));
           }else if (spinner1.equals("rankine") && spinner2.equals("kelvin")){
               Etext2.setText(""+(((5*(ingresado-491.67))/9)+273.15));
           }
       }else if (spinner1.equals("kelvin")){
           if (spinner1.equals("kelvin") && spinner2.equals("kelvin")){
               Etext2.setText(""+ingresado);
           }else if (spinner1.equals("kelvin") && spinner2.equals("Centigrados")){
               Etext2.setText(""+(ingresado- 273.15));
           }else if (spinner1.equals("kelvin") && spinner2.equals("fahrenheit")){
               Etext2.setText(""+(((ingresado-273.18)* 9/5 + 32)));
           }else if (spinner1.equals("kelvin") && spinner2.equals("rankine")){
               Etext2.setText(""+(((9*(ingresado-273.15))/9)+491.67));
           }
       }
    }
}