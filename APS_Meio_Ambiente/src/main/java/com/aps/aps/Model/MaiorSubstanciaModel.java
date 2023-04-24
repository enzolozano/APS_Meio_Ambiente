package com.aps.aps.Model;

import com.aps.aps.ResponseModel.MeasurementsList;

public class MaiorSubstanciaModel {
    public String Cidade;
    public MeasurementsList Medida;

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public void setMedida(MeasurementsList Medida) {
        this.Medida = Medida;
    }
}
