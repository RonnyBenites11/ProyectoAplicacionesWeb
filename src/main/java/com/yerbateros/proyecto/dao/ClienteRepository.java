package com.yerbateros.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yerbateros.proyecto.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
