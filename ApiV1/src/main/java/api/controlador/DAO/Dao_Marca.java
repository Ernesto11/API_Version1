package api.controlador.DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import api.modelo.Categoria;
import api.modelo.Marca;
import api.modelo.Producto;

public class Dao_Marca extends Dao_DB {

	public void crearMarca(String pNombre){
		this.conexion();
		try {
			CallableStatement statement = this.con.prepareCall("{call crear_marca(?)}");
			statement.setString(1, pNombre);
            statement.execute();
            statement.close();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void editarMarca(int id, String pNombre){
		this.conexion();
		try {
			CallableStatement statement = this.con.prepareCall("{call editar_marca(?,?)}");
			statement.setInt(1, id);
			statement.setString(2, pNombre);
            statement.execute();
            statement.close();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	
	public void eliminarMarca(int id){
		this.conexion();
		try {
			CallableStatement statement = this.con.prepareCall("{call eliminar_marca(?)}");
			statement.setInt(1, id);
			statement.executeQuery();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public Marca obtener_marca_id(int id){
		this.conexion();
		Marca m1 = new Marca();
		try {
			CallableStatement statement = this.con.prepareCall("{call obtener_marca_id(?)}");
			statement.setInt(1, id);
			ResultSet resultado = statement.executeQuery();
			if(resultado.next()){
				m1.setId_marca(resultado.getInt("id_marca"));
				m1.setNombre(resultado.getString("nombre"));
			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m1;
	}
	public List<Marca> obtener_marcas(){
		List<Marca> lista = new ArrayList<Marca>(); 
		this.conexion();
		try {
			Statement estado = this.con.createStatement();
			ResultSet resultado = estado.executeQuery("call obtener_marcas");
			while (resultado.next()) {
				Marca m = new Marca();
				m.setId_marca(resultado.getInt("id_marca"));
				m.setNombre(resultado.getString("nombre"));
				lista.add(m);
			}
			resultado.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
}
