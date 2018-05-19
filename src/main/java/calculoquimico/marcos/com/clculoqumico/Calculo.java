package calculoquimico.marcos.com.clculoqumico;

public class Calculo {

    private Integer id;
    private Double concentracao;
    private Double volume;
    private Double massaMolar;
    private Double resultado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getConcentracao() {
        return concentracao;
    }

    public void setConcentracao(Double concentracao) {
        this.concentracao = concentracao;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getMassaMolar() {
        return massaMolar;
    }

    public void setMassaMolar(Double massaMolar) {
        this.massaMolar = massaMolar;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }
}
