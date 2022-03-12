package com.producto.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producto.model.Producto;
import com.producto.services.ProductoServices;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/soproduc/")
public class ProductoController {
	@Autowired
	private ProductoServices productoService ;

	@Operation(summary = "Obtener todos los productos", 
			description = "Sirve para obtener todos los productos de la tabla SOPRODUC")
	@GetMapping
	public ResponseEntity<List<Producto>> getAllProducto() {
		return ResponseEntity.ok(productoService.findAll());
	}

	@Operation(summary = "Obtener un producto específico", 
			description = "Sirve para obtener un producto específico de la tabla SOPRODUC en base a su ID")
	@GetMapping("{id}")
	public ResponseEntity<Optional<Producto>> getProducto(@PathVariable("id") Long id) {
		return ResponseEntity.ok(productoService.findById(id));
	}

	@Operation(summary = "Agregar un producto", 
			description = "Sirve para agregar un producto en la tabla SOPRODUC")
	@PostMapping
	public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto) {
		try {
			Producto productoGuardado = productoService.save(producto);
			return ResponseEntity.created(new URI("/soproduc/" + productoGuardado.getPro_Id())).body(productoGuardado);
		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@Operation(summary = "Editar un producto", 
			description = "Sirve para editar un producto específico de la tabla SOPRODUC en base a su ID")
	@PutMapping("/update")
	public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto) {
		try {
			Producto productoGuardado = productoService.save(producto);
			return ResponseEntity.created(new URI("/soproduc/" + productoGuardado.getPro_Id())).body(productoGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@Operation(summary = "Eliminar un producto", 
			description = "Sirve para eliminar un producto específico de la tabla SOPRODUC en base a su ID")
	@DeleteMapping(value = "delete/{id}")
	public ResponseEntity<Boolean> deleteProducto(@PathVariable("id") Long id) {
		productoService.deleteById(id);
		return ResponseEntity.ok((productoService.findById(id) != null));
	}
}
