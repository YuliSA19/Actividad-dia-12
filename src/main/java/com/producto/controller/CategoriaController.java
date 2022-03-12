package com.producto.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.producto.model.Categoria;
import com.producto.services.CategoriaServices;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping ("/socatego/")
public class CategoriaController {
	@Autowired
	public CategoriaServices categoriaService;

	@Operation(summary = "Obtener todas las categorías", description = "Sirve para obtener todos las categorías de la tabla SOCATEGO")
	@GetMapping
	public ResponseEntity<List<Categoria>> getAllCategoria(){
		return ResponseEntity.ok(categoriaService.findAll());
	}

	@Operation(summary = "Obtener una categoría específica", description = "Sirve para obtener una categoría específica de la tabla SOCATEGO en base a su ID")
	@GetMapping ("{id}")
	public ResponseEntity<Optional<Categoria>> getCategoria(@PathVariable ("id") Long id){
		return ResponseEntity.ok(categoriaService.findById(id));
	}

	@Operation(summary = "Agregar una categoría", description = "Sirve para agregar una categoría en la tabla SOCATEGO")
	@PostMapping
	public ResponseEntity<Categoria> guardarCategoria(@RequestBody Categoria categoria){
		try {
			Categoria categoriaGuardada = categoriaService.save(categoria);
			return ResponseEntity.created(new URI("/socatego/" + categoriaGuardada.getCat_Id())).body(categoriaGuardada);
		} catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}	
	}

	@Operation(summary = "Editar una categoría", description = "Sirve para editar una categoría específica de la tabla SOCATEGO en base a su ID")
	@PutMapping ("/update")
	public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria){
		try {
			Categoria categoriaGuardada = categoriaService.save(categoria);
			return ResponseEntity.created(new URI("/socatego/" + categoriaGuardada.getCat_Id())).body(categoriaGuardada);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}	
	}

	@Operation(summary = "Eliminar una categoría", description = "Sirve para eliminar una categoría específica de la tabla SOCATEGO en base a su ID")
	@DeleteMapping (value = "delete/{id}")
	public ResponseEntity<Boolean> deleteCategoria(@PathVariable ("id") Long id){
		categoriaService.deleteById(id);
		return ResponseEntity.ok((categoriaService.findById(id)!=null));
	}
}

