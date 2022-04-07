package com.example.restaurantmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Connect extends AppCompatActivity implements View.OnClickListener {

    TextView tv_conexion;
    EditText ed_nombre,ed_telelefono,ed_mail;
    Button bt_1;

    private static final String PATH_START = "start";
    private static final String PATH_MESSAGE = "mensaje";

    private static final String PATH_dato = "datos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        tv_conexion = findViewById(R.id.tv_conexion);
        ed_nombre = findViewById(R.id.ed_nombre);
        ed_telelefono = findViewById(R.id.ed_telefono);
        ed_mail = findViewById(R.id.ed_mail);

        bt_1 = findViewById(R.id.bt_1);

        bt_1.setOnClickListener(this);

       FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference reference1 = database.getReference(PATH_START).child(PATH_MESSAGE );

        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                tv_conexion.setText(snapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Connect.this,"error al consultar",Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_1:
                Datos dato = new Datos(ed_nombre.getText().toString().trim(),ed_telelefono.getText().toString().trim(),ed_mail.getText().toString().trim());
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                final DatabaseReference reference = database.getReference(PATH_dato);
                reference.push().setValue(dato);
                break;
        }
    }
}