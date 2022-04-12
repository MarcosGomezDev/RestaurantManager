package com.example.restaurantmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    Button bt_alta;
    CheckBox ch_condiciones,ch_Administrador,ch_Empleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        bt_alta = findViewById(R.id.bt_alta);
        ch_Administrador=findViewById(R.id.ch_Administrador);
        ch_Empleado=findViewById(R.id.ch_Empleado);
        ch_condiciones=findViewById(R.id.ch_condiciones);

        bt_alta.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.bt_alta:

                if (!ch_condiciones.isChecked()&&!ch_Empleado.isChecked()
                        && !ch_Administrador.isChecked()) {
                    Toast.makeText(this,
                            "Hay que aceptar las condiciones de uso ",
                            Toast.LENGTH_SHORT).show();
                }

                if (ch_Empleado.isChecked()&&ch_Administrador.isChecked()){
                    Toast.makeText(this,
                            "Solo puedes seleccionar empleado o administrador",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    //guardamos en base de datos usuario y contraseña
                }
                break;
        }

    }
}