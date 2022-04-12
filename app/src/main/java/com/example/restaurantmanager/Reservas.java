package com.example.restaurantmanager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.*;
import java.text.*;

public class Reservas extends AppCompatActivity implements View.OnClickListener {
    private static final String PATH_dato = "datos";
    FloatingActionButton fa_añadir,fa_fecha;
    TextView tv_Fecha;
    ListView lista;
    ArrayAdapter<String> adapter;
    ArrayList<Datos> mlista = new ArrayList<>();
    ArrayList<String> mlistaString = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);
        lista =(ListView) findViewById(R.id.lista);
        tv_Fecha = findViewById(R.id.textView3);
        fa_añadir = findViewById(R.id.fa_añadir);
        fa_fecha = findViewById(R.id.fa_fecha);

        fa_fecha.setOnClickListener(this);
        fa_añadir.setOnClickListener(this);


        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        tv_Fecha.setText(date);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference reference = database.getReference(PATH_dato);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1,mlistaString);
        lista.setAdapter(adapter);

        reference.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Datos dato = snapshot.getValue(Datos.class);
                mlistaString.add(dato.getNombre()+" , "+dato.getEmail()+", "+dato.getTelefono()+", "+dato.getFecha());
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fa_añadir:
                Intent annadir = new Intent(this,Connect.class);
                startActivity(annadir);
                break;
            case R.id.fa_fecha:
                //DialogFragment date = new DialogFragment();
               // date.show(getSupportFragmentManager(),"date");
                break;
        }

    }


}