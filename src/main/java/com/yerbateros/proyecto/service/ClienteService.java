package com.yerbateros.proyecto.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.yerbateros.proyecto.dao.ClienteRepository;
import com.yerbateros.proyecto.entity.Cliente;
@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	
	public void grabar(Cliente bean) {
		repo.save(bean);
	}
	public void eliminar(Integer cod) {
		repo.deleteById(cod);
	}
	public Cliente buscar(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	public List<Cliente> listarTodos(){
		return repo.findAll();
	}
	//public void actualizarFoto(byte[] img,String nomAr,Integer cod) {
	//	repo.updateFoto(img, nomAr, cod);
	//}

}
