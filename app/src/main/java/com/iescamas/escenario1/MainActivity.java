package com.iescamas.escenario1;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int btnSeleccionado = ((RadioGroup) findViewById(R.id.rg_grupo)).getCheckedRadioButtonId();
        if(btnSeleccionado!=-1){
            eligeArray(btnSeleccionado);
        }

        //Cambio de boton mediante el grupo
        ((RadioGroup) findViewById(R.id.rg_grupo)).setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) (radioGroup, i) -> {
            eligeArray(i);
        });
    }

    private void eligeArray(int i) {
        ArrayAdapter<CharSequence> adapter;
        adapter = ArrayAdapter.createFromResource(this,idBtnArray(i),android.R.layout.simple_spinner_item);
        ((Spinner) findViewById(R.id.sp_elementos)).setAdapter(adapter);
    }

    private int idBtnArray(int i) {

        int array;
        if(i == R.id.rb_opcion1){
            array = R.array.Opciones1;
        } else if (i == R.id.rb_opcion2) {
            array = R.array.Opciones2;
        }
        else{
            array = R.array.Opciones3;
        }
        return array;
    }
}