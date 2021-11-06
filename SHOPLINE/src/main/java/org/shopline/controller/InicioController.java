package org.shopline.controller;

//import org.shopline.model.Producto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

	@GetMapping("/inicio")
	public String cargarPag(Model model) {
		//model.addAttribute("producto", new Producto());
		//model.addAttribute("lstCategorias", repoCate.findAll());
		return "inicio";
	}
}
