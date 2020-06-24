package com.example.fragmentexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=(Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                Fragment fragmentoSeleccionado = null;
                switch (pos){
                    case 0:
                        fragmentoSeleccionado = new ListaFragmeto();
                        break;
                    case 1:
                        fragmentoSeleccionado = new GridFragmento();

                }
                FragmentManager fragmentManager= getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragmento,fragmentoSeleccionado);
                transaction.commit();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}