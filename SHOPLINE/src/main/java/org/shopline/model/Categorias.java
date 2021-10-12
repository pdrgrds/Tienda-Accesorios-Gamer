package org.shopline.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TIPO_PRODUCTO")
public class Categorias {
	@Id
	private int idcategoria;
	private String descripcion;
	public int getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Categorias(int idcategoria, String descripcion) {
		super();
		this.idcategoria = idcategoria;
		this.descripcion = descripcion;
	}
	public Categorias() {
		super();
	}
	@Override
	public String toString() {
		return "Categorias [idcategoria=" + idcategoria + ", descripcion=" + descripcion + "]";
	}
	
}
