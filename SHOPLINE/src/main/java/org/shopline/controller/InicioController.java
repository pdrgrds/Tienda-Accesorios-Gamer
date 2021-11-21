package org.shopline.controller;

import javax.servlet.http.HttpServletResponse;

//import org.shopline.model.Producto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

	@GetMapping("/")
	public void cargarPrincipal(Model model, HttpServletResponse httpResponse) throws Exception {
		httpResponse.sendRedirect("/login");
	}
	
	@GetMapping("/inicio")
	public String cargarInicio(Model model) {
		return "inicio";
	}
}
