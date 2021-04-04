package com.sturni.practicomoviles3sturniolo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private EditText etDolares, etEuros, etCambio, etDecimales;
    private RadioButton rbDaE;
    private Button btConvertir;
    private MainActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        inicializarVista();

        vm.getResultado().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                etCambio.setText(s);
            }
        });
    }

    private void inicializarVista() {
        etDolares = findViewById(R.id.etDolares);
        etEuros = findViewById(R.id.etEuros);
        etCambio = findViewById(R.id.etCambio);
        rbDaE = findViewById(R.id.rbDaE);
        etDecimales = findViewById(R.id.etDecimales);
        btConvertir = findViewById(R.id.btConvertir);

        btConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.convertir(rbDaE.isChecked(), etDolares.getText().toString(), etEuros.getText().toString(), etDecimales.getText().toString());
            }
        });
    }
}