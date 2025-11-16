package com.jorge.ejercicio11;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText _Primer_numero,_Segundo_numero;

    Button _btnsuma, _btnresta, _btndivision, _btnmultiplicacion;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        _Primer_numero = (EditText) findViewById(R.id.Primer_Numero);
        _Segundo_numero = (EditText) findViewById(R.id.Segundo_Numero);
        _btnsuma = (Button) findViewById(R.id.btnsuma);
        _btnresta = (Button) findViewById(R.id.btnresta);
        _btndivision = (Button) findViewById(R.id.btndivision);
        _btnmultiplicacion = (Button) findViewById(R.id.btnmultiplicacion);

        _btnsuma.setOnClickListener(v -> MostrarResultado("Suma"));
        _btnresta.setOnClickListener(v -> MostrarResultado("Resta"));
        _btndivision.setOnClickListener(v -> MostrarResultado("Division"));
        _btnmultiplicacion.setOnClickListener(v -> MostrarResultado("Multiplicacion"));

    }

    private void MostrarResultado(String _Operacion){
        String ValNum1 = _Primer_numero.getText().toString();
        String ValNum2 = _Segundo_numero.getText().toString();

        if (TextUtils.isEmpty(ValNum1)){
            _Primer_numero.setError("Obligatorio");
            return;
        }
        if (TextUtils.isEmpty(ValNum2)){
            _Segundo_numero.setError("Obligatorio");
            return;
        }

        Intent intent = new Intent(MainActivity.this, PantallaResultado.class);

        intent.putExtra("Primer_numero_", _Primer_numero.getText().toString());
        intent.putExtra("Segundo_numero_", _Segundo_numero.getText().toString());
        intent.putExtra("Operacion_", _Operacion);

        startActivity(intent);

    }

}