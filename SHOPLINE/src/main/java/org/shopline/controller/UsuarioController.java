package org.shopline.controller;

import org.shopline.model.Usuario;
/*import org.shopline.repository.ITipoUsuarioRepository;*/
import org.shopline.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {
/*	@Autowired
	private IUsuarioRepository repo;
	@Autowired
	private ITipoUsuarioRepository repot;
	
	@GetMapping("/cargarUsuario")
	public String cargarPag(Model model) {
		model.addAttribute("usuario", new Usuario());	
		model.addAttribute("lstTipoUsuario", repot.findAll());	
		return "crudusuario";
	}

	@PostMapping("/grabarUsuario")
	public String grabarPag(@ModelAttribute Usuario usuario, Model model) {
		repo.save(usuario);	
		model.addAttribute("lstTipoUsuario", repot.findAll());	
		return "crudusuario";
	}*/
	
	@GetMapping("/login")
	public String loginPag(Model model) {	
		return "login";
	}
	
	@GetMapping("/register")
	public String registerPag(Model model) {	
		return "register";
	}
}
