package com.api.advice.advicesGenerator.repository;

import com.api.advice.advicesGenerator.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}