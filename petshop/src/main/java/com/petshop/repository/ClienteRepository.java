package com.petshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.petshop.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, String>{
	Cliente findByCpf(String cpf);
}
