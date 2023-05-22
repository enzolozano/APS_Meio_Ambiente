package com.aps.aps.Controller;

import com.aps.aps.Helpers.FuncBasicas;
import com.aps.aps.Mappers.ParameterMapper;
import com.aps.aps.Mappers.SolutionMapper;
import com.aps.aps.Model.RespostaModel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/Particulas")
public class Particulas {

    private final FuncBasicas _funcao = new FuncBasicas();

    @RequestMapping(value = "/Informacoes/{particle}", method = RequestMethod.GET)
    public ResponseEntity<RespostaModel> Informacoes (String particle) {

        ParameterMapper map = new ParameterMapper();

        try {
            String descricao = map.ParticleToDescriptionPT(particle);

            return new ResponseEntity<RespostaModel>(_funcao.MontaModeloResposta("OK", "", particle + ": " + descricao), HttpStatus.OK);
        }
        catch (Exception ex) {

            return new ResponseEntity<RespostaModel>(_funcao.MontaModeloResposta("FALHA", ex.getMessage(), ""), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/Solucao", method = RequestMethod.GET)
    public ResponseEntity<?> Solucao(String particula) {

        SolutionMapper map = new SolutionMapper();

        try {
            String solucao = map.SolutionForParticles(particula);

            return new ResponseEntity<>(_funcao.MontaModeloResposta("OK", "", solucao), HttpStatus.OK);
        }
        catch (Exception ex) {

            return new ResponseEntity<>(_funcao.MontaModeloResposta("FALHA", ex.getMessage(), ""), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
