package FinApp;

import java.util.HashMap;
import java.util.Map;

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

            Map<String, Double> categoriasSoma = new HashMap<>();

            for (Saida saida : conta.getSaidas()) {
                double valor = saida.getValor();
                String categoria = saida.getCategoria().getNome();

                
                if (categoriasSoma.containsKey(categoria)) {
                    double soma = categoriasSoma.get(categoria);
                    soma += valor;
                    categoriasSoma.put(categoria, soma);
                } else {
                    categoriasSoma.put(categoria, valor);
                }
            }

            for (Map.Entry<String, Double> entry : categoriasSoma.entrySet()) {
                String categoria = entry.getKey();
                double soma = entry.getValue();

                dataset.addValue(soma, "Despesas", categoria);
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

