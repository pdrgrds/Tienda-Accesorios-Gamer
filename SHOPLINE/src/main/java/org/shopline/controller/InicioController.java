package org.shopline.controller;

import javax.servlet.http.HttpServletResponse;

import org.shopline.repository.ICategoriaRepository;
import org.shopline.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.shopline.model.Producto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InicioController {
	
	@Autowired
	private IProductoRepository repoProd;
	
	@Autowired
	private ICategoriaRepository repoCatg;

	@GetMapping("/")
	public void cargarPrincipal(Model model, HttpServletResponse httpResponse) throws Exception {
		httpResponse.sendRedirect("/login");
	}
	
	@GetMapping("/inicio")
	public String cargarInicio(Model model) {
		model.addAttribute("listProd", repoProd.findAll());
		model.addAttribute("listCateg", repoCatg.findAll());
		return "inicio";
	}
	
	@GetMapping("/buscar")
	public String cargarBuscar(Model model, @RequestParam int id) {
		model.addAttribute("listProd", repoProd.findByIdcategoria(id));
		model.addAttribute("listCateg", repoCatg.findAll());
		return "search";
	}
}
