package org.shopline.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTO")
public class Producto {
	@Id
	private int id;
	private String descripcion;
	private double precio;
	private int stock_actual;
	private int descuento;
	@Lob
	private String imagen;
	private String popular;
	private int idcategoria;
	private int proveedor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock_actual() {
		return stock_actual;
	}
	public void setStock_actual(int stock_actual) {
		this.stock_actual = stock_actual;
	}
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getPopular() {
		return popular;
	}
	public void setPopular(String popular) {
		this.popular = popular;
	}
	public int getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}
	public int getProveedor() {
		return proveedor;
	}
	public void setProveedor(int proveedor) {
		this.proveedor = proveedor;
	}
	public Producto(int id, String descripcion, double precio, int stock_actual, int descuento, String imagen,
			String popular, int idcategoria, int proveedor) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock_actual = stock_actual;
		this.descuento = descuento;
		this.imagen = imagen;
		this.popular = popular;
		this.idcategoria = idcategoria;
		this.proveedor = proveedor;
	}
	public Producto() {
		super();
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", descripcion=" + descripcion + ", precio=" + precio + ", stock_actual="
				+ stock_actual + ", descuento=" + descuento + ", imagen=" + imagen + ", popular=" + popular
				+ ", idcategoria=" + idcategoria + ", proveedor=" + proveedor + "]";
	}
	
}
