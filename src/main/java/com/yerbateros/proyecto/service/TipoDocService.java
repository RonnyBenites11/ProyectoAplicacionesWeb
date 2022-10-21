package com.yerbateros.proyecto.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.yerbateros.proyecto.dao.TipoDocRepository;
import com.yerbateros.proyecto.entity.TipoDoc;

@Service
public class TipoDocService {
	@Autowired
	private TipoDocRepository repo;
	
	public void grabar(TipoDoc bean) {
		repo.save(bean);
	}
	public void eliminar(Integer cod) {
		repo.deleteById(cod);
	}
	public TipoDoc buscar(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	public List<TipoDoc> listarTodos(){
		return repo.findAll();
	}
	

}
