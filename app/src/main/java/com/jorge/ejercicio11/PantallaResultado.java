package com.jorge.ejercicio11;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class PantallaResultado extends AppCompatActivity {

    TextView Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pantalla_resultado);

        Resultado = (TextView) findViewById(R.id.LBResultado);

        String primer_numero = getIntent().getStringExtra("Primer_numero_");
        String segundo_numero = getIntent().getStringExtra("Segundo_numero_");
        String operacion = getIntent().getStringExtra("Operacion_");

        switch (operacion){
            case "Suma":
                int Resultado_suma = Suma(primer_numero,segundo_numero);
                Resultado.setText("El resultado de la suma es: " + Resultado_suma);
                break;
            case "Resta":
                int Resultado_resta = Resta(primer_numero,segundo_numero);
                Resultado.setText("El resultado de la resta es: " + Resultado_resta);
                break;
            case "Division":
                Double Resultado_division = Division(primer_numero,segundo_numero);
                Resultado.setText("El resultado de la división es: " + Resultado_division);
                break;
            case "Multiplicacion":
                long Resultado_multiplicacion = Multiplicacion(primer_numero,segundo_numero);
                Resultado.setText("El resultado de la multiplicación es: " + Resultado_multiplicacion);
                break;
        }
    }

    private int Suma(String _Primer_numero_, String _Segundo_numero_ ){
        int n1 = Integer.parseInt(_Primer_numero_);
        int n2 = Integer.parseInt(_Segundo_numero_);
        return n1+n2;
    }
    private int Resta(String _Primer_numero_, String _Segundo_numero_ ){
        int n1 = Integer.parseInt(_Primer_numero_);
        int n2 = Integer.parseInt(_Segundo_numero_);
        return n1-n2;
    }
    private double Division(String _Primer_numero_, String _Segundo_numero_ ){
        double n1 = Double.parseDouble(_Primer_numero_);
        double n2 = Double.parseDouble(_Segundo_numero_);

        if (n2 == 0) {
            return Double.NaN;
        }
        else{
            return n1/n2;
        }
    }
    private long Multiplicacion(String _Primer_numero_, String _Segundo_numero_ ){
        long n1 = Long.parseLong(_Primer_numero_);
        long n2 = Long.parseLong(_Segundo_numero_);
        return n1*n2;
    }

}
