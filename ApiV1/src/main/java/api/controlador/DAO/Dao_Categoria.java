package api.controlador.DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import api.modelo.Categoria;
import api.modelo.Producto;

public class Dao_Categoria extends Dao_DB {

	
	public Producto obtener_producto_id(int id){
		this.conexion();
		try {
			Statement estado = this.con.createStatement();
			ResultSet resultado = estado.executeQuery("select * from producto");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Producto p = new Producto();
		p.setId_producto(1);
		p.setNombre("abc");
		p.setPrecio(25);
		return p;
	}
	public List<Categoria> obtener_categorias(){
		List<Categoria> lista = new ArrayList<Categoria>(); 
		this.conexion();
		try {
			Statement estado = this.con.createStatement();
			ResultSet resultado = estado.executeQuery("select * from categoria");
			while (resultado.next()) {
				Categoria c = new Categoria();
				c.setId_categoria(1);
				c.setNombreCategoria("prueba");
				lista.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
}
