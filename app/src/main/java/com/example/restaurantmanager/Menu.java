package com.example.restaurantmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity implements View.OnClickListener{

    private Button bt_reserva, bt_consultas, bt_fichaje, bt_caja, bt_close;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        bt_caja = findViewById(R.id.bt_caja);
        bt_consultas = findViewById(R.id.bt_consultas);
        bt_fichaje = findViewById(R.id.bt_fichaje);
        bt_reserva = findViewById(R.id.bt_reserva);
        bt_close = findViewById(R.id.bt_close);

        bt_reserva.setOnClickListener(this);
        bt_fichaje.setOnClickListener(this);
        bt_consultas.setOnClickListener(this);
        bt_caja.setOnClickListener(this);
        bt_close.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.bt_caja:
                Intent caja = new Intent(this,Gestion_caja.class);
                startActivity(caja);
                break;
            case R.id.bt_consultas:
                Intent consultas = new Intent(this,Connect.class);
                startActivity(consultas);
                break;
            case R.id.bt_fichaje:
                Intent fichar = new Intent(this,Fichar.class);
                startActivity(fichar);
                break;
            case R.id.bt_reserva:
                Intent reserva = new Intent(this,Reservas.class);
                startActivity(reserva);
                break;
            case R.id.bt_close:
                break;
        }

    }
}