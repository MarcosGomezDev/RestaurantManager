package com.example.restaurantmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button bt_incio, bt_registro;
    private MenuProvider menuAppBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_incio= findViewById(R.id.bt_inicio);
        bt_registro=findViewById(R.id.bt_registro);

        bt_incio.setOnClickListener(this);
        bt_registro.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.signInToolbar);
        setSupportActionBar(toolbar);
        //toolbar.addMenuProvider(menuAppBar);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case(R.id.bt_registro):
                Intent registro = new Intent(this,Registro.class);
                startActivity(registro);
                break;
            case (R.id.bt_inicio):
                Intent inicio = new Intent(this,Menu.class);
                startActivity(inicio);
                break;
        }

    }

}