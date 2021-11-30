package org.shopline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReporteController {
	
	@GetMapping("/mostrarReportes")
	public String cargarPag() {
		return "reporte";
	}
	
}
