package api.controlador.DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import api.modelo.Producto;

public class Dao_Unidad_Medida extends Dao_DB {

	
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
	public List<Producto> obtener_productos(){
		List<Producto> lista = new ArrayList<Producto>(); 
		this.conexion();
		try {
			Statement estado = this.con.createStatement();
			ResultSet resultado = estado.executeQuery("select * from producto");
			while (resultado.next()) {
				Producto p = new Producto();
				p.setId_producto(resultado.getInt("id_producto"));
				p.setNombre(resultado.getString("nombre"));
				p.setCosto(resultado.getDouble("costo"));
				p.setPrecio(resultado.getDouble("precio"));
				p.setImpuesto(resultado.getDouble("impuesto"));
				p.setCantidadDisponible(resultado.getInt("cantidad_disponible"));
				p.setCantidadMaxima(resultado.getInt("cantidad_maxima"));
				p.setCantidadMinima(resultado.getInt("cantidad_minima"));
				lista.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
}
