package com.example.sintomedic;

import android.os.Bundle;;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

public class MainActivityPaciente extends AppCompatActivity implements SintomaFragment.FragmentCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_paciente);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.paciente_menu, menu);
        return true;
    }

    @Override
    public void fragmentallback() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
