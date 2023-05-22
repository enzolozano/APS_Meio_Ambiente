package com.aps.aps.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import com.aps.aps.Interface.Relatorio;
import com.aps.aps.Mappers.SolutionMapper;
import com.aps.aps.ResponseModel.MeasurementsList;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Element;
import java.awt.Color;

import java.util.List;

public class GeraPDF implements Relatorio {

    private Document documentoPDF;
    private String caminhoRelatorio = "D:/PASTAS SIMILARES WINDOWS/Documentos/RelatorioQualidadeDoAr.pdf";
    private String caminhoImagem = "D:/PASTAS SIMILARES WINDOWS/Documentos/RelatorioQualidadeDoAr.jpeg";

    public GeraPDF() {

        this.documentoPDF = new Document(PageSize.A4, 50, 50, 50, 50);

        try {
            PdfWriter.getInstance(this.documentoPDF, new FileOutputStream(caminhoRelatorio));
            this.adicionarPaginacao();
            this.documentoPDF.open();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void gerarCabecalho() {
        this.adicionaParagrafoTitulo();
        this.pularLinha();
        this.pularLinha();
    }

    @Override
    public void gerarCorpo(List<MeasurementsList> measurementsLists) {
        this.adicionarImagem(caminhoImagem);
        this.pularLinha();
        this.adicionaLegendaGrafico(measurementsLists);
        this.pularLinha();
        this.adicionaQuebraDeSessao();
        this.pularLinha();
        this.adicionaSolucao(measurementsLists);
    }

    @Override
    public void gerarRodape() {
        this.adicionaQuebraDeSessao();
        this.pularLinha();
        this.adicionarRodaPe();
    }

    @Override
    public void imprimir() {
        if (this.documentoPDF != null && this.documentoPDF.isOpen()) {
            documentoPDF.close();
        }
    }

    private void adicionaLegendaGrafico(List<MeasurementsList> measurementLists) {

        Particulas particulas = new Particulas();

        for (MeasurementsList ml : measurementLists) {
            Chunk chunk = new Chunk();
            chunk.append(particulas.Informacoes(ml.getParameter()).getBody().Resposta.toString());
            

            Paragraph parafrago = new Paragraph();
            parafrago.add(chunk);
            this.documentoPDF.add(parafrago);
        }
    }

    private void adicionaSolucao(List<MeasurementsList> measurementsLists) {

        SolutionMapper map = new SolutionMapper();

        for (MeasurementsList ml : measurementsLists) {
            Chunk chunk = new Chunk();
            chunk.append(ml.getParameter() + " - " + map.SolutionForParticles(ml.getParameter()));
            chunk.append("\n");  
            chunk.append("\n");


            Paragraph parafrago = new Paragraph();
            parafrago.add(chunk);
            this.documentoPDF.add(parafrago);
        }

    }

    private void adicionarPaginacao() {
        HeaderFooter paginacao = new HeaderFooter(new Phrase("Pág.",new Font(Font.BOLD)), true);
        paginacao.setAlignment(Element.ALIGN_RIGHT);
        paginacao.setBorder(Rectangle.NO_BORDER);
        documentoPDF.setHeader(paginacao);
    }

    private void adicionaQuebraDeSessao() {
        Paragraph paragrafoSessao = new Paragraph("__________________________________________________________________________");
        paragrafoSessao.setAlignment(Element.ALIGN_CENTER);
        this.documentoPDF.add(paragrafoSessao);
    }

    private void adicionaParagrafoTitulo() {
        Paragraph paragrafoTitulo = new Paragraph();
        paragrafoTitulo.setAlignment(Element.ALIGN_CENTER);
        Chunk cTitulo = new Chunk("RELATÓRIO DE QUALIDADE DE AR");
        cTitulo.setFont(new Font(Font.COURIER, 24));
        cTitulo.setBackground(Color.lightGray, 2, 2, 2, 2);
        paragrafoTitulo.add(cTitulo);
        documentoPDF.add(paragrafoTitulo);
    }

    private void adicionarImagem(String caminhoImagem) {
        Image imgTitulo = null;
        try {
            imgTitulo = Image.getInstance(caminhoImagem);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "IMG Não encontrada", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
        if (imgTitulo != null) {
            imgTitulo.setAlignment(Element.ALIGN_CENTER);
            this.documentoPDF.add(imgTitulo);
        }

        File f = new File(caminhoImagem);

        if (f.exists()) {
            f.delete();
        }
    }

    private void pularLinha() {
        this.documentoPDF.add(new Paragraph(" "));
    }

    private void adicionarRodaPe() {
        Paragraph pRodape = new Paragraph();
        pRodape.setAlignment(Element.ALIGN_CENTER);
        pRodape.add(new Chunk("© 2023 - UNIP / Ciência da Computação", new Font(Font.TIMES_ROMAN, 14)));
        this.documentoPDF.add(pRodape);
    }
}
