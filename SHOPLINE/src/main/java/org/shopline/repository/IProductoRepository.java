package org.shopline.repository;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.shopline.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer>{

	ArrayList<Producto> findByIdcategoria(int id);
	ArrayList<Producto> findByDescripcion(String nombre);
}
