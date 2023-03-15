package com.gestion.productos.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.productos.modelo.Producto;
import com.gestion.productos.repositorio.ProductoRepositorio;

@Service
public class ProductoServicioImpl implements ProductoServicio{

	@Autowired
	private ProductoRepositorio repositorio;

	public List<Producto> listarProductos() {
		return repositorio.findAll();
	}

	public void guardarProducto(Producto producto) {

		repositorio.save(producto);
	}

	public Optional<Producto> obtenerProductoPorId(Integer id) {
		return repositorio.findById(id);
	}

	public void eliminarProducto(Integer id) {
		repositorio.deleteById(id);
	}

}
