package api.controlador;

import java.util.List;

import api.modelo.Producto;


public class Controlador {
	private Gestor_Producto gp = new Gestor_Producto();
	
	public Producto obtener_producto_id (int id){
		return gp.obtener_producto_id(id);
	}
	public List<Producto> obtener_productos(){
		return gp.obtener_productos();
	}
}
