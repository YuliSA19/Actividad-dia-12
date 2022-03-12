package com.producto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.producto.model.Categoria;

public interface CategoriaRepository  extends JpaRepository<Categoria, Long>{

}
