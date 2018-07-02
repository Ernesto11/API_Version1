package api.controlador;


import java.util.ArrayList;
import java.util.List;

import api.controlador.DAO.Dao_DB;
import api.modelo.Producto;


public class Gestor_Producto {
	private Dao_DB db = new Dao_DB();
	private List<Producto> lista_productos = new ArrayList<Producto>(); 
	
	public Producto obtener_producto_id(int id){
		//db.conexion();
		return db.obtener_producto_id(id);
	}
	public List<Producto> obtener_productos(){
		//db.conexion();
		lista_productos=db.obtener_productos();
		return lista_productos;
	}
	
}
