package com.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.models.Servico;
import com.petshop.repository.ServicoRepository;

@Controller
public class ServicoController {
	
	@Autowired
	private ServicoRepository sr;
	
	@RequestMapping(value="/cadastrarServico", method=RequestMethod.GET)
	public String form() {
		return "servico/formServico";
	}
	
	@RequestMapping(value="/cadastrarServico", method=RequestMethod.POST)
	public String form(Servico servico) {
		
		sr.save(servico);
		
		return "redirect:/cadastrarServico";
	}
	
	@RequestMapping("/servicos")
	public ModelAndView listaServicos() {
		ModelAndView mv = new ModelAndView("servico/servico");
		Iterable<Servico> servicos = sr.findAll();
		mv.addObject("servicos", servicos);
		
		return mv;
	}
}
