package api.controlador;

import api.modelo.Producto;


public class Gestor_Producto {
	private Dao_DB db = new Dao_DB();
	
	public Producto obtener_producto_id(int id){
		db.conexion();
		db.obtener_producto_id(id);
		return null;
	} 
}
