package com.example.restaurantmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class Fichar extends AppCompatActivity implements View.OnClickListener {

    Button bt_fichar,bt_hora,bt_horafin;
    EditText editText_dni;
    TextView tv_hora,tv_dia,tv_horafin;
    CalendarView calendario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fichar);

        bt_fichar = findViewById(R.id.bt_fichar);
        bt_horafin = findViewById(R.id.bt_horafin);
        bt_hora = findViewById(R.id.bt_hora_ini);

        editText_dni = findViewById(R.id.editText_dni);
        tv_hora = findViewById(R.id.tv_horaini);
        tv_horafin = findViewById(R.id.tv_horafin);
        tv_dia = findViewById(R.id.tv_dia);
        calendario = findViewById(R.id.calendario);

        bt_hora.setOnClickListener(this);
        bt_fichar.setOnClickListener(this);
        bt_horafin.setOnClickListener(this);
        bt_horafin.setEnabled(false);

        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String Fecha = i + "/" + (i1+1) + "/"+i2;
                tv_dia.setText(Fecha);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.bt_hora_ini:

                int hora=0;
                int minutos=0;

                TimePickerDialog time = new TimePickerDialog(Fichar.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        String horas = i + ":"+i1;
                        tv_hora.setText(horas);
                    }
                },hora,minutos,false);
                time.show();
                bt_horafin.setEnabled(true);
                bt_hora.setEnabled(false);
                break;

            case R.id.bt_horafin:
                int horaf=0;
                int minutosf=0;

                TimePickerDialog timef = new TimePickerDialog(Fichar.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        String horas = i + ":"+i1;
                        tv_horafin.setText(horas);
                    }
                },horaf,minutosf,false);
                timef.show();
                bt_horafin.setEnabled(false);
                bt_hora.setEnabled(true);
                break;
            case R.id.bt_fichar:

                break;
        }
    }
}