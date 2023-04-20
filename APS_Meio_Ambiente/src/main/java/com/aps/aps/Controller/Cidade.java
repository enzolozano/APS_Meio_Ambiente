package com.aps.aps.Controller;

import com.aps.aps.ControllerRequest.GerenciaAPI;
import com.aps.aps.Helpers.FuncBasicas;
import com.aps.aps.Model.MedidaModel;
import com.aps.aps.Model.RespostaModel;
import com.aps.aps.ResponseModel.CitiesResponse;
import com.aps.aps.ResponseModel.MeasurementsResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.Gson;

import kotlin.collections.ArrayDeque;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/Cidade")
public class Cidade {

    private final FuncBasicas _funcao = new FuncBasicas();

    @RequestMapping(value = "/Medidas", method = RequestMethod.GET)
    public ResponseEntity<?> Medidas(String city) {

        String URI = "/v2/measurements?country_id=BR&city="+ city +"&order_by=datetime&sort=desc";

        String resposta = new GerenciaAPI().GET(URI);

        if (resposta.length() == 0) {

            return new ResponseEntity<>(_funcao.MontaModeloResposta("FALHA", "Não foi possível receber resposta da requisição", null), HttpStatus.NOT_FOUND);
        }

        MeasurementsResponse mr = new MeasurementsResponse();
        ObjectMapper mapper = new ObjectMapper();

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        try {

            mr = new Gson().fromJson(resposta, MeasurementsResponse.class);

            if (mr.getResults().isEmpty()) {

                return new ResponseEntity<>(_funcao.MontaModeloResposta("FALHA", "Nenhum registro encontrado", null), HttpStatus.NO_CONTENT);
            }

            MedidaModel medidaModel = new MedidaModel();

            medidaModel.setCidade(mr.getResults().get(0).getCity());

            return new ResponseEntity<RespostaModel>(_funcao.MontaModeloResposta("OK", "", medidaModel), HttpStatus.OK);
        }
        catch (Exception ex) {

            return new ResponseEntity<RespostaModel>(_funcao.MontaModeloResposta("FALHA", ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/Lista", method = RequestMethod.GET)
    public ResponseEntity<?> Lista() {

        String URI = "/v2/cities?sort=asc&country_id=BR&order_by=city";

        String resposta = new GerenciaAPI().GET(URI);

        if (resposta.length() == 0) {

            return new ResponseEntity<>(_funcao.MontaModeloResposta("FALHA", "Não foi possível receber resposta da requisição", null), HttpStatus.NOT_FOUND);
        }

        CitiesResponse cr = new CitiesResponse();
        ObjectMapper mapper = new ObjectMapper();

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        try {
            cr = new Gson().fromJson(resposta, CitiesResponse.class);

            if (cr.getResults().isEmpty()) {

                return new ResponseEntity<>(_funcao.MontaModeloResposta("FALHA", "Nenhum registro encontrado", null), HttpStatus.NO_CONTENT);
            }

            List<String> cidades = new ArrayList<String>();

            cr.getResults().forEach(result -> cidades.add(result.getCity()));

            return new ResponseEntity<>(_funcao.MontaModeloResposta("OK", "", cidades), HttpStatus.OK);
        }
        catch (Exception ex) {

            return new ResponseEntity<RespostaModel>(_funcao.MontaModeloResposta("FALHA", ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
