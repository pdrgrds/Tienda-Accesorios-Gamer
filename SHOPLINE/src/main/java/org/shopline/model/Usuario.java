package org.shopline.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="USUARIO")
public class Usuario {
	@Id
	private int id;
	private String nombre;
	private String apellido;
	
	@Column(name = "usr_usua")
	private String user;
	
	private String pswrd;
	private String fecha_nac;
	private int idtipo;
	private int estado;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String usr_usua) {
		this.user = usr_usua;
	}
	public String getPswrd() {
		return pswrd;
	}
	public void setPswrd(String pswrd) {
		this.pswrd = pswrd;
	}
	public String getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	public int getIdtipo() {
		return idtipo;
	}
	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public Usuario(int id, String nombre, String apellido, String user, String pswrd, String fecha_nac, int idtipo,
			int estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.user = user;
		this.pswrd = pswrd;
		this.fecha_nac = fecha_nac;
		this.idtipo = idtipo;
		this.estado = estado;
	}
	public Usuario() {
		super();
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", usr_usua=" + user
				+ ", pswrd=" + pswrd + ", fecha_nac=" + fecha_nac + ", idtipo=" + idtipo + ", estado=" + estado + "]";
	}
	

	
	

}
