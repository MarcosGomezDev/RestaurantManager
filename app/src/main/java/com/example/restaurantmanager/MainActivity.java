package com.example.restaurantmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button signInButton, registerButton;
    private EditText emailEditText, passwordEditText;
    private CheckBox recUserCheck;
    private MenuProvider menuAppBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInButton = findViewById(R.id.signInButton);
        registerButton = findViewById(R.id.registerButton);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        recUserCheck = findViewById(R.id.RecUserCheck);

        signInButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.signInToolbar);
        setSupportActionBar(toolbar);
        //toolbar.addMenuProvider(menuAppBar);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case(R.id.registerButton):
                if (recUserCheck.isChecked()) {
                    Toast.makeText(this,
                            "Sesión guardada",
                            Toast.LENGTH_SHORT).show();
                }

                // Intent provisional, hay que quitarlo
                Intent registro = new Intent(this,Registro.class);
                startActivity(registro);


                break;

            case (R.id.signInButton):
                // Se debe registrar en la base de datos con authentication.

                // Intent provisional, hay que quitarlo
                Intent inicio = new Intent(this,Menu.class);
                startActivity(inicio);



                break;
        }

    }

}