package com.aps.aps.Controller;

import com.aps.aps.Helpers.FuncBasicas;
import com.aps.aps.Model.MedidaModel;
import com.aps.aps.ResponseModel.MeasurementsList;

import org.jfree.data.general.DefaultPieDataset;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/Relatorio")
public class Relatorio {

    private final FuncBasicas _funcao = new FuncBasicas();

    @RequestMapping(value = "/Gera", method = RequestMethod.GET)
    public ResponseEntity<?> GeraRelatorio(String city) {
        try {

            GeraGrafico grafico = new GeraGrafico();
            DefaultPieDataset dados = new DefaultPieDataset();
            Cidade cidade = new Cidade();
            String caminhoArquivo = "D:/PASTAS SIMILARES WINDOWS/Documentos/RelatorioQualidadeDoAr";

            MedidaModel medidaModel = (MedidaModel)cidade.Medidas(city).getBody().Resposta;

            for (MeasurementsList ml: medidaModel.Medidas) {
                dados.setValue(ml.getParameter() + "\n" + ml.getValue() + ml.getUnit(), ml.getValue());
            }

            grafico.tituloGrafico = "Partículas mais presentes no ar - " + city;
            grafico.dataSetPizza = dados;
            grafico.criarGrafico();

            try {
                grafico.criaArquivoJPEG(caminhoArquivo, 500, 500);
                
            }
            catch (Exception ex){

            }

            GeraPDF relatorioPdfSimples = new GeraPDF();
            relatorioPdfSimples.gerarCabecalho();
            relatorioPdfSimples.gerarCorpo(medidaModel.Medidas);
            relatorioPdfSimples.gerarRodape();
            relatorioPdfSimples.imprimir();

            return new ResponseEntity<>(_funcao.MontaModeloResposta("OK", "", caminhoArquivo + ".jpeg"), HttpStatus.OK);
        }
        catch (Exception e) {

            return new ResponseEntity<>(_funcao.MontaModeloResposta("FALHA", e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
