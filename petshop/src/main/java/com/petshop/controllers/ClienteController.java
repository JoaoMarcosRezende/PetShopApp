package com.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.models.Cliente;
import com.petshop.models.Servico;
import com.petshop.repository.ClienteRepository;
import com.petshop.repository.ServicoRepository;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository cr;
	
	@Autowired
	private ServicoRepository sr;
	
	@RequestMapping(value="/cadastrarCliente", method=RequestMethod.GET)
	public String form() {
		return "cliente/formCliente";
	}
	
	@RequestMapping(value="/cadastrarCliente", method=RequestMethod.POST)
	public String form(Cliente cliente) {
		
		cr.save(cliente);
		
		return "redirect:/cadastrarCliente";
	}
	
	@RequestMapping("/clientes")
	public ModelAndView listaClientes() {
		ModelAndView mv = new ModelAndView("cliente/cliente");
		Iterable<Cliente> clientes = cr.findAll();
		mv.addObject("clientes", clientes);
		
		return mv;
	}
	
	@RequestMapping(value="/{cpf}", method=RequestMethod.GET)
	public ModelAndView servicosCliente(@PathVariable("cpf") String cpf){
		Cliente cliente = cr.findByCpf(cpf);
		ModelAndView mv = new ModelAndView("cliente/servicosCliente");
		mv.addObject("cliente", cliente);
		
		return mv;
	}
	
	@RequestMapping(value="/{cpf}", method=RequestMethod.POST)
	public String detalhesEventoPost(@PathVariable("cpf") String cpf, Servico servico){	
		Cliente cliente = cr.findByCpf(cpf);
		servico.setClient(cliente);
		sr.save(servico);
		return "redirect:/{cpf}";
	}
}
