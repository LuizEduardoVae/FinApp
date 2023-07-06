package FinApp;

public class Pontos {
    private int totalPontos;
    private Usuario usuarioLogado;

    public Pontos() {
        this.totalPontos = 0;
        this.usuarioLogado = null;
    }

    public void setUsuarioLogado(Usuario usuario) {
        this.usuarioLogado = usuario;
    }

    public void registrarOperacao(int quantidadePontos) {
        if (usuarioLogado != null) {
            usuarioLogado.adicionarPontos(quantidadePontos);
        }
    }

    public int getTotalPontos() {
        return totalPontos;
    }
}
