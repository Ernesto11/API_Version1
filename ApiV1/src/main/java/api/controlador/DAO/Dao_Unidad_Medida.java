package api.controlador.DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import api.modelo.Producto;
import api.modelo.Unidad_Medida;

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
	public List<Unidad_Medida> obtener_unidades_medida(){
		List<Unidad_Medida> lista = new ArrayList<Unidad_Medida>(); 
		this.conexion();
		try {
			Statement estado = this.con.createStatement();
			ResultSet resultado = estado.executeQuery("select * from Unidad_Medida");
			while (resultado.next()) {
				Unidad_Medida u = new Unidad_Medida();
				u.setId_UnidadMedida(resultado.getInt("id_unidad_medida"));
				u.setNombreUnidadMedida(resultado.getString("nombre"));
				u.setSimbolo(resultado.getString("simbolo"));
				lista.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
}
