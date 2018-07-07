package api.controlador.DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import api.modelo.Producto;

public class Dao_DB {

	protected Connection con;
	
	public void conexion(){
		try{		
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_erp","root","");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3333/db_erp","root","");
		}catch(Exception e){
			
		}
	}
	
}
