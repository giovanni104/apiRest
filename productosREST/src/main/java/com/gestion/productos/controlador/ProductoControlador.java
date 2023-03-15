package com.gestion.productos.controlador;

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
import org.springframework.web.bind.annotation.RestController;

import com.gestion.productos.modelo.Producto;
import com.gestion.productos.servicio.ProductoServicio;


@RestController
public class ProductoControlador {

	@Autowired
	private ProductoServicio servicio;

	@GetMapping("/productos")
	public List<Producto> listarProductos() {
		return servicio.listarProductos();
	}

	@GetMapping("/productos/{id}")
	public ResponseEntity<?> obtenerProducto(@PathVariable Integer id) {
		Optional<Producto> productoOptional = servicio.obtenerProductoPorId(id);
		return productoOptional.isPresent() ? ResponseEntity.ok(productoOptional.get())
				: ResponseEntity.notFound().build();
	}

	@PostMapping("/productos")
	public void guardarProducto(@RequestBody Producto producto) {
		servicio.guardarProducto(producto);
	}

	@PutMapping("/productos/{id}")
	public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto, @PathVariable Integer id) {

		Optional<Producto> productoExistente = servicio.obtenerProductoPorId(id);

		if (productoExistente.isPresent()) {
			
			productoExistente.get().setNombre(producto.getNombre());
			productoExistente.get().setPrecio(producto.getPrecio());		
			
			servicio.guardarProducto(productoExistente.get());
			return new ResponseEntity<Producto>(productoExistente.get(), HttpStatus.OK);

		} else {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);

		}

	}

	@DeleteMapping("/productos/{id}")
	public void eliminarProducto(@PathVariable Integer id) {
		servicio.eliminarProducto(id);
	}

}
