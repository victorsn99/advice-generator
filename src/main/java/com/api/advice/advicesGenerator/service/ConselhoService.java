package com.api.advice.advicesGenerator.service;

import com.api.advice.advicesGenerator.model.Conselho;

public interface ConselhoService {

    Conselho gerarESalvarConselho(Long usuarioId);

    Conselho salvarConselho(Long usuarioId, Long conselhoId);
}
