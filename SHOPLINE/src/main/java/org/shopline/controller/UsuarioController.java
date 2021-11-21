package org.shopline.controller;

import javax.servlet.http.HttpServletResponse;

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
		repo.save(usuario);	
		model.addAttribute("lstTipoUsuario", repot.findAll());	
		return "crudusuario";	
	}
	
	@GetMapping("/login")
	public String loginPag(Model model) {	
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	@PostMapping("/validated-login")
	public String validatedLogin(@ModelAttribute Usuario usuario, Model model,  HttpServletResponse httpResponse) throws Exception {
		Usuario data = repo.findByUserAndPswrd(usuario.getUser(), usuario.getPswrd());
		if(data == null) {
			model.addAttribute("usuario", new Usuario());
			model.addAttribute("mensaje", "Usuario o Contraseña incorrecto");	
			return "login";
		} else {
			httpResponse.sendRedirect("/inicio");
			return "inicio";
		}
	}
	
	@GetMapping("/register")
	public String registerPag(Model model) {	
		model.addAttribute("usuario", new Usuario());
		return "register";
	}
	
	@PostMapping("/register-post")
	public String registerPost(@ModelAttribute Usuario usuario, Model model) {
		usuario.setEstado(1);
		usuario.setIdtipo(3);
		repo.save(usuario);
		model.addAttribute("mensaje", "Cuenta creada exitosa");
		model.addAttribute("usuario", new Usuario());
		return "register";
	}
	
	@GetMapping("/listarUsurio")
	public String listaUsuario(Model model) {
		model.addAttribute("lstUsuario", repo.findAll());	
		return "listadousuario";
	}
	
	@PostMapping("/editarUsuario")
	public String buscarUsuario(@ModelAttribute Usuario u, Model model) {
		model.addAttribute("usuario", repo.findById(u.getId()));
		model.addAttribute("lstTipoUsuario", repot.findAll());		
		return "crudusuario";
	}
}
