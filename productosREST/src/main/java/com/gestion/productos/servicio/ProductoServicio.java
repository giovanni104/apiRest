package com.gestion.productos.servicio;

import java.util.List;
import java.util.Optional;

 
import com.gestion.productos.modelo.Producto;
 
public interface ProductoServicio {

	
	public List<Producto> listarProductos();

	public void guardarProducto(Producto producto);

	public Optional<Producto> obtenerProductoPorId(Integer id);

	public void eliminarProducto(Integer id) ;
	
	
	
}
