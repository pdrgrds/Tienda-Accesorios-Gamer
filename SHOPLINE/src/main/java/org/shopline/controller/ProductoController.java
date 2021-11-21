package org.shopline.controller;

import org.shopline.repository.ICategoriaRepository;
import org.shopline.repository.IProveedorRepository;

import java.io.IOException;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.shopline.model.Producto;
import org.shopline.repository.IProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public String grabarPag(@ModelAttribute Producto producto, Model model, @RequestParam("archivoImagen") MultipartFile multipar) {
		try {
			if(!multipar.isEmpty()) {
				byte[] image = Base64.encodeBase64(multipar.getBytes());
				String result = "data:image/png;base64, " + new String(image);
				producto.setImagen(result);				
				System.out.println(result);
			}
			repo.save(producto);
		} catch (IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("lstCategorias", repoc.findAll());	
		model.addAttribute("lstProveedor", repop.findAll());
		return "crudproductos";
	}
	
	@GetMapping("/Producto")
	public String listaProducto(Model model) {
		model.addAttribute("lstProductos", repo.findAll());	
		return "listadoproductos";
	}
	
	@PostMapping("/editarProducto")
	public String buscarProd(@ModelAttribute Producto p, Model model) {
		Optional<Producto> data = repo.findById(p.getId());
		model.addAttribute("producto", data);
		model.addAttribute("stringImagen", data.get().getImagen());
		model.addAttribute("lstCategorias", repoc.findAll());
		model.addAttribute("lstProveedor", repop.findAll());	
		return "crudproductos";
	}
	
}
