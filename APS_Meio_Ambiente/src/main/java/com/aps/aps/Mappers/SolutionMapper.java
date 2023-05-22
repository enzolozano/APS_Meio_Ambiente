package com.aps.aps.Mappers;

import java.util.HashMap;
import java.util.Map;

public class SolutionMapper {
    public String SolutionForParticles(String particle) {
        Map<String, String> particles = new HashMap<>();

        particles.put("pm25", "Materiais particulados na atmosfera com tamanho variável de 0,1 a 2,5 μm (micrómetros), pode conter diversas substâncias perigosas, como cobre, chumbo, cádmio e manganês. Uma solução válida para melhorar a situação do ar, é diminuir a queima de combustíves fósseis");
        particles.put("pm4", "Materiais particulados na atmosfera com tamanho variável de 2,5 a 4 μm (micrómetros). Uma longa exposição a essas partículas pode gerar doenças respiratórias. Uma solução válida para melhorar a situação do ar, é diminuir a queima de combustíves fósseis");
        particles.put("pm10", "Materiais particulados na atmosfera com tamanho variável de 4 a 10 μm (micrómetros). Uma longa exposição a essas partículas pode gerar doenças respiratórias e até cardíacas. Uma solução válida é monitorar essas substâncias, tomar medidas para reduzir a poluição do ar e proteger a saúde pública");
        particles.put("no", "O monóxido de nitrogênio é um gás incolor e inodoro composto por nitrôgenio e oxigênio produziado a partir da queima de combustíveis fósseis (como petróleo e carvão). Altas concentrações de NO podem levar a envenenamento por monóxido de carbono (CO). Uma solução válida para melhorar a qualidade do ar é diminutir a queima de combustíveis fósseis");
        particles.put("no2", "O dióxido de nitrôgenio é um gás marrom-avermelhado com um odor irritante formado pela oxidação de monóxido de nitrôgenio na atmosfera. Medidas como incentivar o transporte público, a bicicleta e o caminhar, podem ajudar a reduzir as emissões de NO2 e outros poluentes atmosféricos.");
        particles.put("ch4", "O gás metano é produzido pela decomposição de matéria orgânica, é abundante em aterros sanitários, lixões e reservatórios de hidelétricas, além da criação de gado e cultivo do arroz. Uma solução válida para reduzir a emissão do metano, é melhorar a dieta do gado, investir nas melhorias dos pastos e outras medidas que visam reduzir a emissão em outros locais citados anteriormente.");
        particles.put("so2", "O dióxido de enxofre é resultado da queima de combustíveis que possuem enxofre, como óleo diesel, óleo industrial e gasolina. É um dos principais formadores da chuva ácida. O uso de fontes de energia renováveis junto a redução do uso de combustíveis com enxofre podem ajudar a reduzir a emissão dessa substância.");
        particles.put("o3", "Embora benéfico para a estratosfera, o ozônio em excesso pode desencadear efeitos tóxicos nas camadas mais baixas da atmosfera, por afetar diretamente os seres vivos. Ele formado por reações químicas na atmosfera, a partir de precursores como os hidrocarbonetos e óxidos de nitrogênio emitidos por processos de combustão. Algumas formas de reduzir a emissão de ozônio na atmosfera incluem o uso de transportes alternativos, tecnologias mais limpas, melhoria da eficiência energética, controle da emissão de poluentes por veículos, educação ambiental, incentivos fiscais e monitoramento da qualidade do ar.");
        particles.put("co", "O monóxido de carbono é um gás inodoro, incolor e extremamante tóxico, liberado na atmosfera, muitas vezes, por causas naturais, como atividades vulcânicas, descargas elétricas e emissão de gás natural. Algumas formas de reduzir a emissão de monóxido de carbono na atmosfera incluem a adoção de tecnologias mais limpas, o controle da emissão de poluentes por veículos, a melhoria da eficiência energética, o uso de combustíveis alternativos e a educação ambiental");
        particles.put("bc", "O carbono negro é uma das formas mais puras do carvão, sendo constituida por partículas muito finas. Ele é obtido através da combustão parcial de compostos orgânicos, principalmente metano e acetileno. Evite automóveis movidos a diesel e tome os cuidados necessários na prevenção de incêndios florestais, evitando atitudes como soltar balões e fazer fogueiras em locais próximos a florestas. Não jogue bitucas de cigarro em lugares arborizados ou beiras de estrada e sempre dê preferência ao transporte público movido a energias renováveis, como o metrô e o trem.");
        particles.put("nox", "Óxidos de nitrogênio são compostos químicos formados por átomos de nitrogênio e oxigênio. Os principais óxidos de nitrogênio são o dióxido de nitrogênio (NO2) e o monóxido de nitrogênio (NO). Esses gases são produzidos naturalmente por processos biológicos e vulcânicos, mas também são emitidos por fontes antropogênicas, como a queima de combustíveis fósseis, a produção industrial e o transporte. Os óxidos de nitrogênio são poluentes atmosféricos que contribuem para a formação de chuva ácida, smog fotoquímico e o aquecimento global.");


        String solution = "";

        try {

            solution = particles.get(particle);
        }
        catch (Exception ex) {

            solution = "Não foi possível achar uma solução para a partícula especificada";
        }

        return solution;
    }
}
