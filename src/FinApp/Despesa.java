package FinApp;

public class Despesa extends Transacao {
    private String tipo;

    public Despesa(double valor, String descricao, Categoria categoria, String tipo) {
        super(valor, descricao, categoria);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean isDespesa() {
        return true;
    }
}