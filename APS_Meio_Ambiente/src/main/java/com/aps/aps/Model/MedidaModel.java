package com.aps.aps.Model;

import com.aps.aps.ResponseModel.MeasurementsList;

import java.util.List;

public class MedidaModel {
    public String Cidade;
    public List<MeasurementsList> Medidas;

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public void setMedidas(List<MeasurementsList> Medidas) {
        this.Medidas = Medidas;
    }
}
