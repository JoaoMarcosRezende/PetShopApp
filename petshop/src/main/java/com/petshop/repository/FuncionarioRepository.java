package com.petshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.petshop.models.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, String>{
	
}
