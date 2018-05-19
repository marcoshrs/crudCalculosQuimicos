package calculoquimico.marcos.com.clculoqumico;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import calculoquimico.marcos.com.clculoqumico.banco.DAOCalculo;

public class Calculadora extends Activity {

    Calculo calculo = new Calculo();
    EditText editConcentracao;
    EditText editVolume;
    EditText editMassaMolar;
    EditText editResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        editConcentracao = (EditText) findViewById(R.id.editTextConcentracao);
        editVolume = (EditText) findViewById(R.id.editTextVolume);
        editMassaMolar = (EditText) findViewById(R.id.editTextMassaMolar);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null && bundle.containsKey("id")){
            Integer id = bundle.getInt("id");
            Log.i("Tela", ""+id);
            calculo = new DAOCalculo(this).buscarPorId(id);
            editConcentracao.setText(String.valueOf(calculo.getConcentracao()));
            editVolume.setText(String.valueOf(calculo.getVolume()));
            editMassaMolar.setText(String.valueOf(calculo.getMassaMolar()));
        }
    }

    public void lista(View view){
        Intent intent = new Intent(this, Lista.class);
        startActivity(intent);
    }

    public void calcular(View view){
        Intent intent = new Intent(this, Lista.class);
        startActivity(intent);

        editConcentracao = (EditText) findViewById(R.id.editTextConcentracao);
        editVolume = (EditText) findViewById(R.id.editTextVolume);
        editMassaMolar = (EditText) findViewById(R.id.editTextMassaMolar);

        //TextView textResultado = findViewById(R.id.textResultado);

        Double valorConcentracao = Double.parseDouble(editConcentracao.getText().toString());
        Double valorVolume = Double.parseDouble(editVolume.getText().toString());
        Double valorMassaMolar = Double.parseDouble(editMassaMolar.getText().toString());

        Double r = valorConcentracao * valorVolume * valorMassaMolar;

        calculo.setConcentracao(Double.parseDouble(editConcentracao.getText().toString()));
        calculo.setVolume(Double.parseDouble(editVolume.getText().toString()));
        calculo.setMassaMolar(Double.parseDouble(editMassaMolar.getText().toString()));

        Log.i("calculo1", String.valueOf(calculo.getConcentracao()));
        Log.i("calculo2", String.valueOf(calculo.getVolume()));
        Log.i("calculo3", String.valueOf(calculo.getMassaMolar()));



        calculo.setResultado(calculo.getConcentracao() * calculo.getVolume() * calculo.getMassaMolar());
        if(calculo.getId()==null){
            new DAOCalculo(this).inserir(calculo);
        }else{
            new DAOCalculo(this).alterar(calculo);
        }

        Toast.makeText(this,"Resultado "+r, Toast.LENGTH_LONG).show();


        finish();


    }
}
