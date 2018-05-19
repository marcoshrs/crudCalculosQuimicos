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

public class Lista extends Activity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listView = findViewById(R.id.listaCalculos);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

    public void novoCalculo(View view){
        Intent intent = new Intent(this, Calculadora.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        List<Calculo> listaCalculos = new DAOCalculo(this).consultar();
        AdapterCalculo adapterCalculo = new AdapterCalculo(this, listaCalculos);
        listView.setAdapter(adapterCalculo);
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, Calculadora.class);
        intent.putExtra("id",Integer.parseInt(String.valueOf(id)));
        startActivity(intent);
    }

    private void atualizarLista(){
        List<Calculo> listaCalculos = new DAOCalculo(this).consultar();
        AdapterCalculo adapterCalculo = new AdapterCalculo(this, listaCalculos);
        listView.setAdapter(adapterCalculo);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        final DAOCalculo daoCalculo = new DAOCalculo(this);
        final long idExcluir = id;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseja Excluir o Registro??")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        daoCalculo.excluir(Integer.parseInt(String.valueOf(idExcluir)));
                        atualizarLista();
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        builder.show();

        return true;
    }


}
