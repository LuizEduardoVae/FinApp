package FinApp;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class Relatorio {
    private Conta conta;

    public Relatorio(Conta conta) {
        this.conta = conta;
    }

    public void gerarRelatorioDespesasPorCategoria() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Saida saida : conta.getSaidas()) {
            double valor = saida.getValor();
            String categoria = saida.getCategoria().getNome();

            dataset.addValue(valor, "Despesas", categoria);
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Gráfico de Despesas por Categoria",
                "Categoria",
                "Valor",
                dataset
        );

        ChartFrame frame = new ChartFrame("Relatório", chart);
        frame.pack();
        frame.setVisible(true);
    }
}
