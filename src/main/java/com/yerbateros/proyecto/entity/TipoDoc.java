package com.yerbateros.proyecto.entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "tb_TipoDoc")

public class TipoDoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Cod_TipoDoc")
	private Integer codDoc;
	@Column(name = "Descripcion_TipoDoc")
	private String descripcion;
	@OneToMany(mappedBy = "tipodoc")
	private List<Cliente> listaClientes;
	public Integer getCodDoc() {
		return codDoc;
	}
	public void setCodDoc(Integer codDoc) {
		this.codDoc = codDoc;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
}
