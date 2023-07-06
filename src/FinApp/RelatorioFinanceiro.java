package FinApp;

import java.util.Map;

public class RelatorioFinanceiro {
    private Usuario usuario;
    private Map<Categoria, Double> despesasPorCategoria;

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Map<Categoria,Double> getDespesasPorCategoria() {
        return this.despesasPorCategoria;
    }

    public void setDespesasPorCategoria(Map<Categoria,Double> despesasPorCategoria) {
        this.despesasPorCategoria = despesasPorCategoria;
    }

    public RelatorioFinanceiro(Usuario usuario, Map<Categoria, Double> despesasPorCategoria) {
        this.usuario = usuario;
        this.despesasPorCategoria = despesasPorCategoria;
    }

    public void gerarRelatorio() {
        // gerar o relatório financeiro com os gráficos
    }
}