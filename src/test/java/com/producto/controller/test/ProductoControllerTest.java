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

import com.producto.controller.ProductoController;
import com.producto.model.Producto;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductoControllerTest {
	@Autowired
	private ProductoController productoController;
	
	@Test
	@Order(1)
	public void testGetAllProducto() {
			ResponseEntity<List<Producto>> productos = productoController.getAllProducto();
			assertEquals(HttpStatus.OK.toString(),productos.getStatusCode().toString());
			System.out.println("Se ejecutó correctamente");	
	}

	@Test
	void testGetProducto() {
		Long id = (long) 2;
		ResponseEntity<Optional<Producto>> productos = productoController.getProducto(id);
		assertEquals(HttpStatus.OK.toString(),productos.getStatusCode().toString());
		System.out.println("Se ejecutó correctamente");
	}

	@Test
	void testGuardarProducto() {
		Producto producto = new Producto();
		producto.Pro_Nombre = "Prueba";
		producto.Pro_Serie = "S0008";
		producto.Pro_Catego = 5;
		ResponseEntity<Producto> productos = productoController.guardarProducto(producto);
		assertEquals(HttpStatus.CREATED.toString(),productos.getStatusCode().toString());
		System.out.println("Se ejecutó correctamente");
	}

	@Test
	void testUpdateProducto() {
		Producto producto = new Producto();
		producto.Pro_Nombre = "Prueba";
		producto.Pro_Serie = "S0006";
		producto.Pro_Catego = 5;
		producto.Pro_Id = 7L;
		ResponseEntity<Producto> productos = productoController.updateProducto(producto);
		assertEquals(HttpStatus.CREATED.toString(),productos.getStatusCode().toString());
		System.out.println("Se ejecutó correctamente");
	}

	@Test
	void testDeleteProducto() {
		Long id = (long) 7;
		ResponseEntity<Boolean> productos = productoController.deleteProducto(id);
		assertEquals(HttpStatus.OK.toString(),productos.getStatusCode().toString());
		System.out.println("Se ejecutó correctamente");
	}

}
