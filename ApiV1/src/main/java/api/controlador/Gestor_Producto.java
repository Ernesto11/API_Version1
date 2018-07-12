package api.controlador;


import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import api.controlador.DAO.Dao_DB;
import api.controlador.DAO.Dao_Producto;
import api.modelo.Producto;


public class Gestor_Producto {
	private Dao_Producto db = new Dao_Producto();
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
	public void insertar_producto(Producto pProducto){
		db.insertarProducto(pProducto);
	}
	
	public void editar_producto(Producto pProducto){
		db.editarProducto(pProducto);
	}
	
	public void desechar_producto(int pId_producto, int pCantidadDesecho){
		db.desecharProducto(pId_producto, pCantidadDesecho);
	}

	
}
