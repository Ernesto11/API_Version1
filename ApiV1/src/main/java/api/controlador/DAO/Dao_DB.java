package api.controlador.DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import api.controlador.Configuracion;
import api.modelo.Producto;

public class Dao_DB {

	protected Connection con;
	
	public void conexion(){
		try{		
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:"+Configuracion.getConfiguracion().getPORT()+"/db_erp","root","");
		}catch(Exception e){
			
		}
	}
	
}
