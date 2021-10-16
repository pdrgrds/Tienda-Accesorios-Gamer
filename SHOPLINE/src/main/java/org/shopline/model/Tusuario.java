package org.shopline.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TIPO_USUARIO")
public class Tusuario {
	@Id
	private int idtipo;
	private String descripcion;
	public int getIdtipo() {
		return idtipo;
	}
	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Tusuario(int idtipo, String descripcion) {
		super();
		this.idtipo = idtipo;
		this.descripcion = descripcion;
	}
	public Tusuario() {
		super();
	}
	@Override
	public String toString() {
		return "Tusuario [idtipo=" + idtipo + ", descripcion=" + descripcion + "]";
	}
	
	

}
