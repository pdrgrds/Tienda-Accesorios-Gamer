package org.shopline.controller;

import org.shopline.model.Usuario;
import org.shopline.repository.ITusuarioRepository;
import org.shopline.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {
	@Autowired
	private IUsuarioRepository repo;
	@Autowired
	private ITusuarioRepository repot;
	
	@GetMapping("/cargarUsuario")
	public String cargarPag(Model model) {
		model.addAttribute("usuario", new Usuario());	
		model.addAttribute("lstTipoUsuario", repot.findAll());	
		return "crudusuario";
	}

	@PostMapping("/grabarUsuario")
	public String grabarPag(@ModelAttribute Usuario usuario, Model model) {
		/*Usuario xd= new Usuario(12,"Nombre","Ape","L","1234567","2021-10-10",1,1);
		
		System.out.println(xd);
		System.out.println("Grabo exitoso");*/
		repo.save(usuario);	
		model.addAttribute("lstTipoUsuario", repot.findAll());	
		return "crudusuario";
	}
}
