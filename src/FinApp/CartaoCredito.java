package FinApp;


public class CartaoCredito {
    private String numero;
    private double limiteCredito;

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getLimiteCredito() {
        return this.limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public CartaoCredito(String numero, double limiteCredito) {
        this.numero = numero;
        this.limiteCredito = limiteCredito;
    }

}