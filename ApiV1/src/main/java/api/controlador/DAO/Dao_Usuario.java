package api.controlador.DAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import api.modelo.Categoria;
import api.modelo.Marca;
import api.modelo.Usuario;

public class Dao_Usuario extends Dao_DB {
	
	public void crearUsuario(Usuario pUsuario){
		this.conexion();
		try {
			CallableStatement statement = this.con.prepareCall("{call crear_usuario(?,?,?)}");
			statement.setString(1, pUsuario.getNombre());
			statement.setString(2, pUsuario.getContrasena());
			statement.setString(3, pUsuario.getTipo());
            statement.execute();
            statement.close();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void cambiarContrasena(int id_usuario, String nvaContrasena){
		this.conexion();
		try {
			CallableStatement statement = this.con.prepareCall("{call cambiar_contrasena(?,?)}");
			statement.setInt(1, id_usuario);
			statement.setString(2, nvaContrasena);
            statement.execute();
            statement.close();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	
	public boolean validarUsuario(Usuario pUsuario){
		this.conexion();
		try {
			CallableStatement statement = this.con.prepareCall("{call validar_usuario(?,?)}");
			statement.setString(1, pUsuario.getNombre());
			statement.setString(2, pUsuario.getContrasena());
			ResultSet resultado = statement.executeQuery();
			if(resultado.next()){
				int resUsuario =resultado.getInt("usuario_valido");
				if(resUsuario==1)
					return true;
			}
			statement.close();

			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		return false;
	}

	public void eliminarUsuario(String nombreUsuario){
		this.conexion();
		try {
			CallableStatement statement = this.con.prepareCall("{call eliminar_usuario(?)}");
			statement.setString(1, nombreUsuario);
			statement.executeQuery();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public Usuario obtener_usuario(String nombreUsuario){
		this.conexion();
		Usuario usuario = new Usuario();
		try {
			CallableStatement statement = this.con.prepareCall("{call obtener_usuario(?)}");
			statement.setString(1, nombreUsuario);
			ResultSet resultado = statement.executeQuery();
			if(resultado.next()){
				usuario.setNombre(resultado.getString("nombre"));
				usuario.setContrasena(resultado.getString("contrasenna"));
				usuario.setTipo(resultado.getString("tipo"));
			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
	}
	public List<Usuario> obtener_usuarios(){
		List<Usuario> lista = new ArrayList<Usuario>(); 
		this.conexion();
		try {
			Statement estado = this.con.createStatement();
			ResultSet resultado = estado.executeQuery("call obtener_usuarios");
			
			while (resultado.next()) {
				Usuario u = new Usuario();
				u.setNombre(resultado.getString("nombreUsuario"));
				u.setContrasena(resultado.getString("contrasenna"));
				u.setTipo(resultado.getString("tipo"));
				lista.add(u);
			}
			resultado.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
}
