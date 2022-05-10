package com.backoff.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.backoff.models.clients;
import com.backoff.repositores.clientRepository;


@Controller
public class clientsController {
	@Autowired
	private clientRepository repo;

	//Rota de lista Clientes
	
	@GetMapping("/clientes")
	public ModelAndView clients() {
		ModelAndView mav = new ModelAndView("clientes/clientes-dashboard-mais-compras");
		List<clients>list = repo.findAll();
		mav.addObject("clients", list);
		return mav;
		}
	
	@GetMapping("/formClient")
	public String formClient() {
		return "clientes/adicionar-cliente";
	}
	
	@PostMapping("/newClient")
	public String newClient(@Valid clients Clients) {
		repo.save(Clients);
		return "redirect:/clientes";
	}
	

	
	@GetMapping("/clientProfile")
	public ModelAndView clientProfile() {
		ModelAndView mav = new ModelAndView("clientes/conta-cliente");
		List<clients>list = repo.findAll();
		mav.addObject("clients", list);
		return mav;
		}
		
		@GetMapping("/clients/{id}")
		public String buscar(@PathVariable Long id, Model model) {
			Optional<clients> clients = repo.findById(id);
			try {
			model.addAttribute("clients",clients.get());
			} catch(Exception err) {
				return "redirect:/clientes";
			}
			return "clientes/editar-cliente";
			
		
		}
		
	@PostMapping("/clients/{id}/atualizar")
	public String alterar(@PathVariable Long id, clients clients) {
		if(!repo.existsById(id)){
			return "redirect:/clientes";
		}
		repo.save(clients);
		
		return "redirect:/clientes";
	}
	
	
	
	
	
}

