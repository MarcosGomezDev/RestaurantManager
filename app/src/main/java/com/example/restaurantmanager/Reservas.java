package com.example.restaurantmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Reservas extends AppCompatActivity {

    Button bt_1;
    TextView tv_Fecha;
    ListView lista;
    List<String> mlista = new ArrayList<>();
    ArrayAdapter<String> madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);
       lista = findViewById(R.id.lista);
        mlista.add("Sergio");
        mlista.add("Marcos");
        mlista.add("Mario");
        mlista.add("Pedro");
        mlista.add("Sergio");
        mlista.add("Marcos");
        mlista.add("Mario");
        mlista.add("Pedro");
        mlista.add("Sergio");
        mlista.add("Marcos");
        mlista.add("Mario");
        mlista.add("Pedro");
        mlista.add("Sergio");
        mlista.add("Marcos");
        mlista.add("Mario");
        mlista.add("Pedro");
        mlista.add("Sergio");
        mlista.add("Marcos");
        mlista.add("Mario");
        mlista.add("Pedro");

        madapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mlista);
        lista.setAdapter(madapter);

    }
}