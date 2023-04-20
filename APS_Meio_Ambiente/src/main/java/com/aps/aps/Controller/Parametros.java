package com.aps.aps.Controller;

import com.aps.aps.ControllerRequest.GerenciaAPI;
import com.aps.aps.Helpers.FuncBasicas;
import com.aps.aps.Model.RespostaModel;
import com.aps.aps.ResponseModel.ParametersResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.Gson;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Parametros")
public class Parametros {

    private final FuncBasicas _funcao = new FuncBasicas();

    @RequestMapping(value = "/Informacoes", method = RequestMethod.GET)
    public ResponseEntity<?> Informacoes() throws Exception {

        RespostaModel respostaModel = new RespostaModel();

        String URI = "";

        String resposta = new GerenciaAPI().GET(URI);

        if (resposta.length() == 0){

            return new ResponseEntity<>(_funcao.MontaModeloResposta("FALHA", "Não foi possível receber resposta da requisição", null), HttpStatus.NOT_FOUND);
        }

        ParametersResponse pr = new ParametersResponse();
        ObjectMapper mapper = new ObjectMapper();



        return null;
    }
}
