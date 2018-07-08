package api.pruebas;

import api.controlador.DAO.Dao_Usuario;
import api.modelo.Usuario;

public class Prueba_usuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dao_Usuario user = new Dao_Usuario();
		System.out.println(user.obtener_usuario("Luz").toString());
		//user.eliminarUsuario(7);
		Usuario pUsuario = new Usuario();
		pUsuario.setNombre("ernesto");
		pUsuario.setContrasena("nueva");
		pUsuario.setTipo("admin");
		//System.out.println(user.validarUsuario(pUsuario));
		//user.crearUsuario(pUsuario);
		//user.cambiarContrasena(5, "nueva");

	}

}
