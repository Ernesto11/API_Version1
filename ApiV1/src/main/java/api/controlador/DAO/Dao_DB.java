package api.controlador.DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
		p.setPrecio(25);
		return p;
	}
	public List<Producto> obtener_productos(){
		List<Producto> lista = new ArrayList<Producto>(); 
		Producto p1 = new Producto();
		p1.setId_producto(1);
		p1.setNombre("abc 1");
		p1.setPrecio(25);
		Producto p2 = new Producto();
		p2.setId_producto(2);
		p2.setNombre("abc 2");
		p2.setPrecio(35);
		lista.add(p1);
		lista.add(p2);
		return lista;
	}
}
