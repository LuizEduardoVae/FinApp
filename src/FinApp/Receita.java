package FinApp;
import java.util.Date;

public class Receita extends Transacao {
    private Categoria categoria;



    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Receita(int id, String descricao, double valor, Date data, Conta conta, Categoria categoria) {
        super(id, descricao, valor, data, conta);
        this.categoria = categoria;
    }
}