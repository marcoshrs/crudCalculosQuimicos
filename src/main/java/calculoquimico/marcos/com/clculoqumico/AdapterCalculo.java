package calculoquimico.marcos.com.clculoqumico;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterCalculo extends BaseAdapter {
    List<Calculo> calculos;
    Context contexto;

    public AdapterCalculo(Context context, List<Calculo> calculos){
        this.contexto = context;
        this.calculos = calculos;
    }


    @Override
    public int getCount() {
        return calculos.size();
    }

    @Override
    public Object getItem(int position) {
        return calculos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return calculos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewLinha = LayoutInflater.from(contexto).inflate(R.layout.linha_lista_calculo, parent, false);
        TextView textViewConcentracao = viewLinha.findViewById(R.id.textViewConcentracao);
        TextView textViewVolume = viewLinha.findViewById(R.id.textViewVolume);
        TextView textViewMassaMolar = viewLinha.findViewById(R.id.textViewMassaMolar);
        TextView textViewResultado = viewLinha.findViewById(R.id.textViewResultado);

        Calculo calculo = (Calculo) getItem(position);

        textViewConcentracao.setText("Concentração: "+String.valueOf(calculo.getConcentracao()));
        textViewVolume.setText("Volume: "+String.valueOf(calculo.getVolume()));
        textViewMassaMolar.setText("Massa Molar: "+String.valueOf(calculo.getMassaMolar()));
        textViewResultado.setText("Resultado: "+String.valueOf(calculo.getResultado()));


        return viewLinha;
    }
}
