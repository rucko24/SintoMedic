package com.example.sintomedic;

import android.os.Bundle;;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivityPaciente extends AppCompatActivity implements SintomaFragment.FragmentCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_paciente);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ;
    }

    @Override
    public void fragmentallback() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
