package api.controlador.DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import api.modelo.Categoria;
import api.modelo.Producto;

public class Dao_Categoria extends Dao_DB {
	
	public void crearCategoria(String pNombre){
		this.conexion();
		try {
			CallableStatement statement = this.con.prepareCall("{call crear_categoria(?)}");
			statement.setString(1, pNombre);
            statement.execute();
            statement.close();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void editarCategoria(Categoria pCategoria){
		this.conexion();
		try {
			CallableStatement statement = this.con.prepareCall("{call editar_categoria(?,?)}");
			statement.setInt(1, pCategoria.getId_categoria());
			statement.setString(2, pCategoria.getNombreCategoria());
            statement.execute();
            statement.close();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	
	public void eliminarCategoria(int id){
		this.conexion();
		try {
			CallableStatement statement = this.con.prepareCall("{call eliminar_categoria(?)}");
			statement.setInt(1, id);
			statement.executeQuery();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public Categoria obtener_categoria_id(int id){
		this.conexion();
		Categoria c1 = new Categoria();
		try {
			CallableStatement statement = this.con.prepareCall("{call obtener_categoria_id(?)}");
			statement.setInt(1, id);
			ResultSet resultado = statement.executeQuery();
			if(resultado.next()){
				c1.setId_categoria(resultado.getInt("id_categoria"));
				c1.setNombreCategoria(resultado.getString("nombre"));
			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c1;
	}
	
	public List<Categoria> obtener_categorias(){
		List<Categoria> lista = new ArrayList<Categoria>(); 
		this.conexion();
		try {
			CallableStatement statement = this.con.prepareCall("{call obtener_categorias}");
			ResultSet resultado = statement.executeQuery();
			while (resultado.next()) {
				Categoria c = new Categoria();
				c.setId_categoria(resultado.getInt("id_categoria"));
				c.setNombreCategoria(resultado.getString("nombre"));
				lista.add(c);
			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
}
