package api.controlador.DAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import api.modelo.Categoria;
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

	public void eliminarUsuario(int id){
		this.conexion();
		try {
			CallableStatement statement = this.con.prepareCall("{call eliminar_usuario(?)}");
			statement.setInt(1, id);
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
				usuario.setId_usuario(resultado.getInt("id_usuario"));
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
}
