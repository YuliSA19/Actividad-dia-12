/**
 * 
 */
package com.producto.controller.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.producto.controller.CategoriaController;
import com.producto.model.Categoria;

@RunWith(SpringRunner.class)
@SpringBootTest
class CategoriaControllerTest {
	
	@Autowired
	private CategoriaController categoriaController;
	
	@Test
	@Order(1)
	void testGetAllCategoria() {
		ResponseEntity<List<Categoria>> categorias = categoriaController.getAllCategoria();
		assertEquals(HttpStatus.OK.toString(),categorias.getStatusCode().toString());
		System.out.println("Se ejecutó correctamente");
	}

	@Test
	void testGetCategoria() {
		Long id = (long) 2;
		ResponseEntity<Optional<Categoria>> categorias = categoriaController.getCategoria(id);
		assertEquals(HttpStatus.OK.toString(),categorias.getStatusCode().toString());
		System.out.println("Se ejecutó correctamente");
	}

	@Test
	void testGuardarCategoria() {
		Categoria categorias = new Categoria();
		categorias.Cat_Nombre = "Prueba";
		ResponseEntity<Categoria> categoria = categoriaController.guardarCategoria(categorias);
		assertEquals(HttpStatus.CREATED.toString(),categoria.getStatusCode().toString());
		System.out.println("Se ejecutó correctamente");
	}

	@Test
	void testUpdateCategoria() {
		Categoria categorias = new Categoria();
		categorias.Cat_Nombre = "Prueba";
		categorias.Cat_Id = 9L;
		ResponseEntity<Categoria> categoria = categoriaController.updateCategoria(categorias);
		assertEquals(HttpStatus.CREATED.toString(),categoria.getStatusCode().toString());
		System.out.println("Se ejecutó correctamente");
	}

	@Test
	void testDeleteCategoria() {
		Long id = (long) 7;
		ResponseEntity<Boolean> categorias = categoriaController.deleteCategoria(id);
		assertEquals(HttpStatus.OK.toString(),categorias.getStatusCode().toString());
		System.out.println("Se ejecutó correctamente");
	}

}
