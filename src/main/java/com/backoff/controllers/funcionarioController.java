package com.backoff.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.backoff.models.Categoria;
import com.backoff.models.clients;
import com.backoff.models.funcionario;
import com.backoff.repositores.categoriaRepository;
import com.backoff.repositores.funcionarioRepository;

@Controller
public class funcionarioController {

	@Autowired
	private funcionarioRepository repo;
	@Autowired
	private categoriaRepository catego;

	@GetMapping("/formFuncionario")
	public ModelAndView formFuncionario() {
		ModelAndView mav = new ModelAndView("funcionarios/adicionar-funcionario");
		List<funcionario>list = repo.findAll();
		mav.addObject("funcionario", list);
		mav.addObject("listarCategoria",catego.findAll());
		return mav;
		}
	
	@PostMapping("/newFuncionario")
	public String newFuncionario(@Valid funcionario Funcionario, BindingResult result) {
		repo.save(Funcionario);
		return "redirect:/oneCategoria";
	}
}
