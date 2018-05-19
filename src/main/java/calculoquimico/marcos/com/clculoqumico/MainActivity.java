package calculoquimico.marcos.com.clculoqumico;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import calculoquimico.marcos.com.clculoqumico.banco.DAOCalculo;

public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void efetuarCalculo(View view){
        Intent intent = new Intent(this, Calculadora.class);
        startActivity(intent);

    }


}
