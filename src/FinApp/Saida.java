package FinApp;
import java.time.LocalDate;

public class Saida extends Operacao {
    private String categoria;

    public Saida(double valor, LocalDate data, String categoria) {
        super(valor, data);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}

