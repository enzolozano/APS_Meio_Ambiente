package com.aps.aps.Interface;

import java.util.List;

import com.aps.aps.ResponseModel.MeasurementsList;

public interface Relatorio {
    public void gerarCabecalho();
    public void gerarCorpo(List<MeasurementsList> measurementLists);
    public void gerarRodape();
    public void imprimir();
}
