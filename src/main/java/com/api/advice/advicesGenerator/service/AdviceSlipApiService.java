package com.api.advice.advicesGenerator.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "adviceslip", url = "https://api.adviceslip.com")
public interface AdviceSlipApiService {

    @GetMapping(path = "/advice")
    public String getRandomAdvice();

    @GetMapping(path = "/advice/{slip_id}")
    public String getAdviceById(@PathVariable("slip_id") Long id);

    @GetMapping(path = "/advice/search/{query}")
    public String getAdviceByText(@PathVariable("query") String query);
}
