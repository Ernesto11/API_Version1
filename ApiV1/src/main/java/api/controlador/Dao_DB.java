package api.controlador;
import java.sql.*;

import api.modelo.Producto;

public class Dao_DB {

	private Connection con;
	public void conexion(){
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3333/db_erp","root","");
			System.out.println("Conexion exitosa ...");
		}catch(Exception e){
			
		}
	}
	public Producto obtener_producto_id(int id){
		Producto p = new Producto();
		p.setId_producto(1);
		p.setNombre("abc");
		p.setCosto(25);
		return p;
	}
}
