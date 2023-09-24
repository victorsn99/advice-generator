package com.api.advice.advicesGenerator.service.impl;

import com.api.advice.advicesGenerator.model.Conselho;
import com.api.advice.advicesGenerator.model.Usuario;
import com.api.advice.advicesGenerator.repository.ConselhoRepository;
import com.api.advice.advicesGenerator.repository.UsuarioRepository;
import com.api.advice.advicesGenerator.service.AdviceSlipApiService;
import com.api.advice.advicesGenerator.service.ConselhoService;
import com.api.advice.advicesGenerator.service.UsuarioService;
import com.api.advice.advicesGenerator.util.SlipToConselhoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService, ConselhoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ConselhoRepository conselhoRepository;

    @Autowired
    private AdviceSlipApiService adviceSlipApiService;

    @Override
    public Iterable<Usuario> buscarTodos() {
        // Buscar todos os usuarios.
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        // Buscar usuario por ID.
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    @Override
    public void inserir(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void atualizar(Long id, Usuario usuario) {
        Optional<Usuario> usuarioBd = usuarioRepository.findById(id);
        if (usuarioBd.isPresent()){
            Usuario usuarioAtualizar = usuarioBd.get();
            usuarioAtualizar.setNome(usuario.getNome());
            usuarioRepository.save(usuarioAtualizar);
        }
    }

    @Override
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Conselho gerarESalvarConselho(Long usuarioId) {
        Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
        if (usuario.isPresent()) {
            Usuario usuarioAtualizar = usuario.get();
            String retorno = adviceSlipApiService.getRandomAdvice();
            if (retorno != null) {
                List<Conselho> conselhosUsuario = usuarioAtualizar.getConselhos();

                Conselho conselhoAdicionar = SlipToConselhoConverter.converter(retorno);
                conselhoAdicionar.setUsuario(usuarioAtualizar);

                conselhosUsuario.add(conselhoAdicionar);
                usuarioAtualizar.setConselhos(conselhosUsuario);

                usuarioRepository.save(usuarioAtualizar);
                return conselhoAdicionar;
            }
        }
        return null;
    }

    @Override
    public Conselho salvarConselho(Long usuarioId, Long conselhoId) {
        Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
        if (usuario.isPresent()) {
            Usuario usuarioAtualizar = usuario.get();
            String retorno = adviceSlipApiService.getAdviceById(conselhoId);
            if (retorno != null) {
                List<Conselho> conselhosUsuario = usuarioAtualizar.getConselhos();

                Conselho conselhoAdicionar = SlipToConselhoConverter.converter(retorno);
                conselhoAdicionar.setUsuario(usuarioAtualizar);

                conselhosUsuario.add(conselhoAdicionar);
                usuarioAtualizar.setConselhos(conselhosUsuario);

                usuarioRepository.save(usuarioAtualizar);
                return conselhoAdicionar;
            }
        }
        return null;
    }
}