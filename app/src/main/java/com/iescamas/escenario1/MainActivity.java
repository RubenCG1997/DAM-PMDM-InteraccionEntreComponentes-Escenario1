package com.iescamas.escenario1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg_opciones;
    Spinner sp;
    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg_opciones = findViewById(R.id.rg_grupo);
        sp = findViewById(R.id.sp_elementos);

        //Arracamos el spinner con las opciones de fútbol
        adapter = ArrayAdapter.createFromResource(this,R.array.Opciones1,android.R.layout.simple_spinner_item);
        //Se especifica el layout con el que empieza
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Se asigna el adaptador al spinner
        sp.setAdapter(adapter);

        //Cambio de boton mediante el grupo
        rg_opciones.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.rb_opcion1){

                    adapter = ArrayAdapter.createFromResource(MainActivity.this,R.array.Opciones1,android.R.layout.simple_spinner_item);

                } else if (i == R.id.rb_opcion2) {

                    adapter = ArrayAdapter.createFromResource(MainActivity.this,R.array.Opciones2,android.R.layout.simple_spinner_item);
                }
                else{

                    adapter = ArrayAdapter.createFromResource(MainActivity.this,R.array.Opciones3,android.R.layout.simple_spinner_item);
                }
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp.setAdapter(adapter);
            }
        });

    }
}