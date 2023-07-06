package FinApp;

public class Conta {
    private String numero;
    private String descricao;
    private Usuario usuario;
    private CartaoCredito cartaoCredito;

    public Conta(String numero, String descricao, Usuario usuario) {
        this.numero = numero;
        this.descricao = descricao;
        this.usuario = usuario;
    }

    public CartaoCredito getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(CartaoCredito cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
