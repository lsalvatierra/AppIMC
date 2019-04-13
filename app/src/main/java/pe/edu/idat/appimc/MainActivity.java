package pe.edu.idat.appimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etTalla, etPeso;
    Button btnCalcular;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPeso = findViewById(R.id.etPeso);
        etTalla = findViewById(R.id.etTalla);
        tvResultado = findViewById(R.id.tvResultado);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etPeso.getText().equals("")){
                    etPeso.setError("Ingrese su peso.");
                }else if(etTalla.getText().equals("")){
                    etTalla.setError("Ingrese su talla");
                }else{
                    Double peso, talla, tallam, imc;
                    String resultadoIMC = "";
                    peso = Double.parseDouble(etPeso.getText().toString());
                    talla = Double.parseDouble(etTalla.getText().toString());
                    tallam = talla / 100;
                    imc = peso / (tallam * tallam);

                    if(imc <= 18.5){
                        resultadoIMC = "Por debajo del peso.";
                        tvResultado.setTextColor(
                                getResources().getColor(R.color.colorIMCBajo)
                        );
                    }else if(imc <= 25){
                        resultadoIMC = "Con peso normal.";
                        tvResultado.setTextColor(
                                getResources().getColor(R.color.colorIMCNormal)
                        );
                    }else if(imc <= 30){
                        resultadoIMC = "Con Sobrepeso.";
                        tvResultado.setTextColor(
                                getResources().getColor(R.color.colorIMCSobrePeso)
                        );
                    }else if(imc <= 35){
                        resultadoIMC = "Obesidad leve.";
                        tvResultado.setTextColor(
                                getResources().getColor(R.color.colorObesidad1)
                        );
                    }else if(imc <= 39){
                        resultadoIMC = "Obesidad media.";
                        tvResultado.setTextColor(
                                getResources().getColor(R.color.colorObesidad2)
                        );
                    } else{
                        resultadoIMC = "Con obesidad mórbida.";
                        tvResultado.setTextColor(
                                getResources().getColor(R.color.colorObesidad3)
                        );
                    }

                    tvResultado.setText("Su IMC es: "+
                            imc.toString()+
                    ", ud. se encuentra: " + resultadoIMC);

                }
            }
        });



    }
}
