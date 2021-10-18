package org.shopline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.shopline.model.Tusuario;
import org.shopline.repository.ITusuarioRepository;

@Controller
public class TusuarioController {
	@Autowired
	private ITusuarioRepository repo;

	@GetMapping("/cargarTusuario")
	public String cargarPag(Model model) {
	model.addAttribute("tusuario", new Tusuario());	
	return "crudtipousuario";
	}

	@PostMapping("/grabarTusuario")
	public String grabarPag(@ModelAttribute Tusuario tusuario, Model model) {
	repo.save(tusuario);	
	return "crudtipousuario";
	}
	
	@GetMapping("/listarTusuario")
	public String listaTusuario(Model model) {
		model.addAttribute("lstTusuario", repo.findAll());	
		return "listadotipousuario";
	}
	
	@PostMapping("/editarTusuario")
	public String buscarTusuario(@ModelAttribute Tusuario t, Model model) {
		model.addAttribute("tusuario", repo.findById(t.getIdtipo()));
		return "crudtipousuario";
	}
}
