package com.petshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.petshop.models.Cliente;
import com.petshop.models.Servico;

public interface ServicoRepository extends CrudRepository<Servico, String>{
	Iterable<Servico> findByCliente(Cliente cliente);
}