package com.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.models.Funcionario;
import com.petshop.repository.FuncionarioRepository;

@Controller
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository fr;
	
	@RequestMapping(value="/cadastrarFuncionario", method=RequestMethod.GET)
	public String form() {
		return "funcionario/formFuncionario";
	}
	
	@RequestMapping(value="/cadastrarFuncionario", method=RequestMethod.POST)
	public String form(Funcionario funcionario) {
		
		fr.save(funcionario);
		
		return "redirect:/cadastrarFuncionario";
	}
	
	@RequestMapping("/funcionarios")
	public ModelAndView listaFuncionarios() {
		ModelAndView mv = new ModelAndView("funcionario/funcionario");
		Iterable<Funcionario> funcionarios = fr.findAll();
		mv.addObject("funcionarios", funcionarios);
		
		return mv;
	}
}