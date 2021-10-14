package org.shopline.controller;

import org.shopline.repository.ICategoriaRepository;
import org.shopline.repository.IProveedorRepository;
import org.shopline.model.Producto;
import org.shopline.repository.IProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductoController {
	
	@Autowired
	private IProductoRepository repo;
	@Autowired
	private ICategoriaRepository repoc;
	@Autowired
	private IProveedorRepository repop;
	
	@GetMapping("/cargarProducto")
	public String cargarPag(Model model) {
		model.addAttribute("producto", new Producto());	
		model.addAttribute("lstCategorias", repoc.findAll());	
		model.addAttribute("lstProveedor", repop.findAll());
		return "crudproductos";
	}

	@PostMapping("/grabarProducto")
	public String grabarPag(@ModelAttribute Producto producto, Model model) {
		repo.save(producto);	
		model.addAttribute("lstCategorias", repoc.findAll());	
		model.addAttribute("lstProveedor", repop.findAll());
		return "crudproductos";
	}
	
	@GetMapping("/listarProducto")
	public String listaProducto(Model model) {
		model.addAttribute("lstProductos", repo.findAll());	
		return "listadoproductos";
	}
	
	@PostMapping("/editarProducto")
	public String buscarProd(@ModelAttribute Producto p, Model model) {
		model.addAttribute("producto", repo.findById(p.getId()));
		model.addAttribute("lstCategorias", repoc.findAll());
		model.addAttribute("lstProveedor", repop.findAll());	
		return "crudproductos";
	}
	
}
