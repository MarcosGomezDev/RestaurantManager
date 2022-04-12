package com.example.restaurantmanager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Connect extends AppCompatActivity implements View.OnClickListener {

    TextView tv_conexion;
    EditText ed_nombre,ed_telelefono,ed_email,ed_fecha;
    Button bt_1,bt_2;
    String Cadena ="";
    private static final String PATH_START = "start";
    private static final String PATH_MESSAGE = "mensaje";

    private static final String PATH_dato = "datos";

    List<Datos> listadatos = new ArrayList<>();
    String date="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        tv_conexion = findViewById(R.id.tv_conexion);
        ed_nombre = findViewById(R.id.ed_nombre);
        ed_telelefono = findViewById(R.id.ed_telefono);
        ed_email = findViewById(R.id.ed_email);
        ed_fecha = findViewById(R.id.ed_fecha);
        date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        tv_conexion.setText("No hay conexion "+date);

        bt_1 = findViewById(R.id.bt_1);
        bt_2=findViewById(R.id.bt_2);

        bt_1.setOnClickListener(this);
        bt_2.setOnClickListener(this);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference reference1 = database.getReference(PATH_START).child(PATH_MESSAGE );

        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                tv_conexion.setText(snapshot.getValue(String.class)+" "+date);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Connect.this,"error al consultar",Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onClick(View view) {
        Datos dato = new Datos(ed_nombre.getText().toString().trim(),ed_email.getText().toString().trim(),ed_telelefono.getText().toString().trim(),ed_fecha.getText().toString().trim());
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference reference = database.getReference(PATH_dato);

        switch (view.getId()){
            case R.id.bt_1:
                reference.push().setValue(dato);
                ed_nombre.setText("");
                ed_email.setText("");
                ed_telelefono.setText("");
                ed_fecha.setText("");
                break;
            case R.id.bt_2:
                reference.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                        Datos dato2 = snapshot.getValue(Datos.class);

                       if (dato2.getEmail().compareTo("20/07/87")==0){
                            Cadena = dato2.getNombre()+"\n"+Cadena;
                            tv_conexion.setText(Cadena );
                        }


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
                break;


        }
    }
}