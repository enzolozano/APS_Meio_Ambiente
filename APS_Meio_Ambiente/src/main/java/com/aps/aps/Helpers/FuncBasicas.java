package com.aps.aps.Helpers;

import com.aps.aps.Model.RespostaModel;
public class FuncBasicas {

    public RespostaModel MontaModeloResposta(String status, String mensagem, Object resposta) {

        RespostaModel respostaModel = new RespostaModel();

        respostaModel.setStatus(status);
        respostaModel.setMensagem(mensagem);
        respostaModel.setResposta(resposta);

        return respostaModel;
    }
}
