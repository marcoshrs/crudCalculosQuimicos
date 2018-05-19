package calculoquimico.marcos.com.clculoqumico.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import calculoquimico.marcos.com.clculoqumico.Calculo;

public class DAOCalculo {

    SQLiteDatabase database;

    public DAOCalculo(Context context){
        database = new BDCore(context).getWritableDatabase();
    }

    public void inserir(Calculo calculo){
        Log.i("DAOCalculo", calculo.getConcentracao().toString());
        ContentValues values = new ContentValues();
        values.put("concentracao",calculo.getConcentracao().toString());
        values.put("volume",calculo.getVolume().toString());
        values.put("massaMolar",calculo.getMassaMolar().toString());
        values.put("resultado",calculo.getResultado().toString());
        database.insert("calculo", null, values);
    }

    public void excluir(Integer id){
        database.delete("calculo", "id=?",new String[]{String.valueOf(id)});
    }

    public void alterar(Calculo calculo){
        ContentValues values = new ContentValues();
        values.put("concentracao",calculo.getConcentracao());
        values.put("volume",calculo.getVolume());
        values.put("massaMolar",calculo.getMassaMolar());
        values.put("resultado",calculo.getResultado());
        database.update("calculo",values,"id="+calculo.getId(),null);
    }

    public List<Calculo> consultar(){
        List<Calculo> calculos = new ArrayList<>();
        String[] colunas = {"id", "concentracao", "volume", "massaMolar", "resultado"};
        Cursor cursor = database.query("calculo", colunas, null,null,null, null, null);
        cursor.moveToFirst();
        for(int x=0; x<cursor.getCount(); x++){
            Calculo calculo = new Calculo();
            calculo.setId(cursor.getInt(0));
            calculo.setConcentracao(cursor.getDouble(1));
            calculo.setVolume(cursor.getDouble(2));
            calculo.setMassaMolar(cursor.getDouble(3));
            calculo.setResultado(cursor.getDouble(4));
            calculos.add(calculo);
            cursor.moveToNext();
        }
            return calculos;
    }

    public Calculo buscarPorId(Integer id){
        Calculo calculo = new Calculo();
        String[] colunas = {"id", "concentracao", "volume", "massaMolar", "resultado"};
        Cursor cursor = database.query("calculo", colunas, "id="+id,null,null, null, null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            calculo.setId(cursor.getInt(0));
            calculo.setConcentracao(cursor.getDouble(1));
            calculo.setVolume(cursor.getDouble(2));
            calculo.setMassaMolar(cursor.getDouble(3));
            calculo.setResultado(cursor.getDouble(4));
        }
        return calculo;
    }
}
