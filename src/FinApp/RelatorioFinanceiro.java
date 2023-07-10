package FinApp;

import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;


public class RelatorioFinanceiro {
    public void gerarRelatorio(Usuario usuario) {
        DefaultPieDataset dataset = new DefaultPieDataset();

        
        for (Conta conta : usuario.getContas()) {
            
            List<Transacao> transacoes = conta.getTransacoes();

            
            for (Transacao transacao : transacoes) {
                Categoria categoria = transacao.getCategoria();
                double valor = transacao.getValor();

                String nomeCategoria = categoria.getNome(); 

               
                if (dataset.getIndex(nomeCategoria) >= 0) {
                    double valorExistente = dataset.getValue(nomeCategoria).doubleValue();
                    dataset.setValue(nomeCategoria, valorExistente + valor);
                } else {
                    dataset.setValue(nomeCategoria, valor);
                }
            }
        }

       
        JFreeChart chart = ChartFactory.createPieChart("Relatório Financeiro", dataset, true, true, false);

        
        ChartFrame frame = new ChartFrame("Relatório Financeiro", chart);
        frame.pack();
        frame.setVisible(true);
    }
}
