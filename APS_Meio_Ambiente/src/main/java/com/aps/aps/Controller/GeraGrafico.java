package com.aps.aps.Controller;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.data.general.PieDataset;

import java.awt.*;

import java.io.File;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GeraGrafico {

    public String tituloGrafico;
    public PieDataset dataSetPizza;
    public JFreeChart graficoPizza;

    public void criarGrafico() {
        this.graficoPizza = ChartFactory.createPieChart(
                tituloGrafico,
                dataSetPizza,
                false,
                false,
                false
        );
        graficoPizza.getPlot().setBackgroundPaint(Color.WHITE);
    }

    public void criaArquivoJPEG(String caminhoDoArquivo, int largura, int altura){
        File arquivoGrafico = new File(caminhoDoArquivo + ".jpeg");
        try {
            ChartUtilities.saveChartAsJPEG(arquivoGrafico, this.graficoPizza, altura, largura);
            Desktop.getDesktop().open(arquivoGrafico);
        }
        catch (IOException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
