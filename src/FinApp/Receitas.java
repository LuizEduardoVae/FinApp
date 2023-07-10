package FinApp;

public class Receitas extends Transacao {
    private String tipo;

    public Receitas(double valor, String descricao, Categoria categoria, String tipo) {
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
        return false;
    }
}