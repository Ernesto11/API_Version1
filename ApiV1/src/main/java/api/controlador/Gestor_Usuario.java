package api.controlador;

import java.util.List;

import api.controlador.DAO.Dao_Usuario;
import api.modelo.Usuario;

public class Gestor_Usuario {
	
	Dao_Usuario dao_usuario;
	
	public Gestor_Usuario(){
		dao_usuario = new Dao_Usuario();
	}
	
	public void crearUsuario(Usuario pUsuario){
		dao_usuario.crearUsuario(pUsuario);
	}
	
	public List<Usuario> obtenerUsuarios(){
		return dao_usuario.obtener_usuarios();
	}
	
	public void eliminar_usuario(Usuario pUsuario){
		dao_usuario.eliminarUsuario(pUsuario.getNombre());
	}

}
