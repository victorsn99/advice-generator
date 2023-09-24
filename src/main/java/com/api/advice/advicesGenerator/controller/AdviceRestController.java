package com.api.advice.advicesGenerator.controller;

import com.api.advice.advicesGenerator.model.Conselho;
import com.api.advice.advicesGenerator.provider.conselho.ConselhosQueryParametros;
import com.api.advice.advicesGenerator.service.AdviceSlipApiService;
import com.api.advice.advicesGenerator.util.SlipToConselhoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("conselhos")
public class AdviceRestController {

    @Autowired
    private AdviceSlipApiService adviceSlipApiService;

    @GetMapping("/buscar/{query}")
    public ResponseEntity<ConselhosQueryParametros> retornarPorTexto(@PathVariable("query") String query) {
        return ResponseEntity.ok(SlipToConselhoConverter.converterParaRetornoQuery(adviceSlipApiService.getAdviceByText(query)));
    }
}
