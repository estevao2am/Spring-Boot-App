package com.backoff.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.backoff.models.Categoria;
import com.backoff.repositores.categoriaRepository;

@Controller
public class categoriaController {
	
	@Autowired
	private categoriaRepository repo;
	
	@GetMapping("/categoria")
	public ModelAndView categoria() {
		ModelAndView mav = new ModelAndView("funcionarios/funcionarios-dashboard");
		List<Categoria>list = repo.findAll();
		mav.addObject("categoria", list);
		return mav;
		}
	
	@GetMapping("/formCategoria")
	public String formCategoria() {
		return "funcionarios/adicionar-categoria";
	}
	@PostMapping("/newCategoria")
	public String newCategoria(@Valid Categoria Categoria) {
		repo.save(Categoria);
		return "redirect:/categoria";
	}
	
	@GetMapping("/oneCategoria")
	public ModelAndView oneCategoria() {
		ModelAndView mav = new ModelAndView("funcionarios/categoria-inside-page");
		List<Categoria>list = repo.findAll();
		mav.addObject("categoria", list);
		return mav;
		}
	
	
}
