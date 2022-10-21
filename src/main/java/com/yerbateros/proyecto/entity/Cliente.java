package com.yerbateros.proyecto.entity;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "tb_Cliente")
public class Cliente {
	@Id
	
	@Column(name = "CodNro_Cliente")
	private Integer CodNro_Cliente ;
	@ManyToOne
	@JoinColumn(name = "Cod_TipoDoc")
	private TipoDoc tipodoc;
	@Column(name = "Nombres_Cliente")
	private String nombre;
	@Column(name = "Apellidos_Cliente")
	private String apellido;
	@ManyToOne
	@JoinColumn(name = "Cod_Usuario")
	private Usuario codusuario;
	public Integer getCodNro_Cliente() {
		return CodNro_Cliente;
	}
	public void setCodNro_Cliente(Integer codNro_Cliente) {
		CodNro_Cliente = codNro_Cliente;
	}
	public TipoDoc getTipodoc() {
		return tipodoc;
	}
	public void setTipodoc(TipoDoc tipodoc) {
		this.tipodoc = tipodoc;
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
	public Usuario getCodusuario() {
		return codusuario;
	}
	public void setCodusuario(Usuario codusuario) {
		this.codusuario = codusuario;
	}
	
}
