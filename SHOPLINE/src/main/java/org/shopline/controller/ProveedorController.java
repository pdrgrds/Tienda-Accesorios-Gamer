package org.shopline.controller;

import org.shopline.model.Proveedor;
import org.shopline.repository.IProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProveedorController {
@Autowired
private IProveedorRepository repo;

@GetMapping("/cargarProveedor")
public String cargarPag(Model model) {
	model.addAttribute("proveedor", new Proveedor());	
	return "crudproveedor";
}

@PostMapping("/grabarProveedor")
public String grabarPag(@ModelAttribute Proveedor proveedor, Model model) {
	repo.save(proveedor);	
	return "crudproveedor";
}

@GetMapping("/listarProveedor")
public String listaProveedor(Model model) {
	model.addAttribute("lstProveedor", repo.findAll());	
	return "listadoproveedor";
}

@PostMapping("/editarProveedor")
public String buscarProv(@ModelAttribute Proveedor p, Model model) {
	model.addAttribute("proveedor", repo.findById(p.getId()));	
	return "crudproveedor";
}

}
