package com.api.advice.advicesGenerator.repository;

import com.api.advice.advicesGenerator.model.Conselho;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConselhoRepository extends CrudRepository<Conselho, Long> {

}