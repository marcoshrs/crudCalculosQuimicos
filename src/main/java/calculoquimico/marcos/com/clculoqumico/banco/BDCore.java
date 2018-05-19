package calculoquimico.marcos.com.clculoqumico.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDCore extends SQLiteOpenHelper {
    private final static String NOME_BANCO = "calculadora";
    private final static Integer VERSAO_BANCO = 2;

    public BDCore(Context context){
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table calculo(id integer primary key autoincrement," +
                "concentracao real," +
                "volume real," +
                "massaMolar real," +
                "resultado real);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table calculo");
        onCreate(db);
    }
}
