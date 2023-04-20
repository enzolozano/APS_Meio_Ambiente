package com.aps.aps.Mappers;

import java.util.HashMap;
import java.util.Map;

public class ParameterMapper {
    public String ParticleToDescriptionPT(String particle) {
        Map<String, String> particles = new HashMap<>();

        particles.put("PM10", "Matéria particulada com menos de 10 micrômetros de concentração de massa de diâmetro.");
        particles.put("PM2.5", "Matéria particulada com menos de 2.5 micrômetros de concentração de massa de diâmetro.");
        particles.put("PM1", "Matéria particulada com menos de 1 micrômetros de concentração de massa de diâmetro");
        particles.put("PM4", "Matéria particulada com menos de 4 micrômetros de concentração de massa de diâmetro");
        particles.put("O₃ mass", "Concentração de massa de ozônio");
        particles.put("CO mass", "Concentração de massa de monóxido de carbono");
        particles.put("NO₂ mass", "Concentração de massa de dióxido de nitrôgenio");
        particles.put("SO₂ mass", "Concentração de massa de dióxido de enxofre");
        particles.put("NOx mass", "Concentração de massa de dióxido de nitrôgenio");
        particles.put("NO₂", "Concentração de dióxido de nitrôgenio");
        particles.put("CO", "Concentração de monóxido de carbono");
        particles.put("SO₂", "Concentração de dióxido de enxofre");
        particles.put("O₃", "Concentração de ozônio");
        particles.put("BC", "Concentração de massa de carbono negro");
        particles.put("CO₂", "Concentração de dióxido de carbono");
        particles.put("CH₄", "Concentração de metano");
        particles.put("UFP count", "Concentração de quantidade de partículas ultrafinas");
        particles.put("NO", "Concentração de monóxido de nitrôgenio");
        particles.put("PM1 count", "Quantidade de PM1");
        particles.put("PM2.5 count", "Quantidade de PM2.5");
        particles.put("PM10 count", "Quantidade de PM10");
        particles.put("NOx", "Concentração de óxido de nitrôgenio");
        particles.put("NO mass", "Concentração de massa de monóxido de nitrôgenio");

        String description = "";

        try {

            description = particles.get(particle);
        }
        catch (Exception ex) {

            description = "Não foi possível descrever a partícula específicada";
        }
        return description;
    }
}
