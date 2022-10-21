package com.yerbateros.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yerbateros.proyecto.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
