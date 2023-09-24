package com.api.advice.advicesGenerator.util;

import com.api.advice.advicesGenerator.model.Conselho;
import com.api.advice.advicesGenerator.provider.conselho.ConselhosQuery;
import com.api.advice.advicesGenerator.provider.conselho.ConselhosQueryParametros;
import com.api.advice.advicesGenerator.provider.query.StatsQuerySlip;
import com.api.advice.advicesGenerator.provider.slip.Slip;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class SlipToConselhoConverter {

    public static Conselho converter(String json) {
        if (json != null) {
            Gson gson = new Gson();
            Slip slip = gson.fromJson(json, Slip.class);
            Conselho conselho = new Conselho();
            conselho.setId(slip.getAdvice().getId());
            conselho.setConselho(slip.getAdvice().getAdvice());
            return conselho;
        }
        return null;
    }

    public static ConselhosQueryParametros converterParaRetornoQuery(String json) {
        if (json != null) {
            Gson gson = new Gson();
            StatsQuerySlip slip = gson.fromJson(json, StatsQuerySlip.class);

            List<ConselhosQuery> conselhos = new ArrayList<>();
            slip.getSlips().forEach(e -> conselhos.add(new ConselhosQuery(e.getId(), e.getAdvice(), e.getDateFormatted())));

            ConselhosQueryParametros conselho = new ConselhosQueryParametros();
            conselho.setQuantidadeResultados(Integer.valueOf(slip.getTotal_results()));
            conselho.setParametroBusca(slip.getQuery());
            conselho.setConselhos(conselhos);
            return conselho;
        }
        return null;
    }
}
