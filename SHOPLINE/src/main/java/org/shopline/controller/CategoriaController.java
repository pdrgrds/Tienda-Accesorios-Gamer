package org.shopline.controller;

import org.shopline.model.Categorias;
import org.shopline.repository.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {
	@Autowired
	private ICategoriaRepository repo;
	
	@GetMapping("/cargarCategoria")
	public String cargarPag(Model model) {
		model.addAttribute("categorias", new Categorias());	
		return "crudcategoria";
	}

	@PostMapping("/grabarCategoria")
	public String grabarPag(@ModelAttribute Categorias categorias, Model model) {
		repo.save(categorias);
		return "crudcategoria";
	}

	@GetMapping("/listarCategoria")
	public String listaCategorias(Model model) {
		model.addAttribute("lstCategoria", repo.findAll());	
		return "listadocategoria";
	}

	@PostMapping("/editarCategoria")
	public String buscarCatg(@ModelAttribute Categorias c, Model model) {
		model.addAttribute("categorias", repo.findById(c.getIdcategoria()));	
		return "crudcategoria";
	}
}
