package api.pruebas;

import java.util.List;

import api.controlador.DAO.Dao_Usuario;
import api.modelo.Usuario;

public class Prueba_usuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dao_Usuario user = new Dao_Usuario();
		//System.out.println(user.obtener_usuario("Luz").toString());
		//user.eliminarUsuario(7);
		Usuario pUsuario = new Usuario();
		pUsuario.setNombre("ernesto1sdfgd");
		pUsuario.setContrasena("nueva");
		pUsuario.setTipo("admin");
		user.crearUsuario(pUsuario);
		//List<Usuario> u = user.obtener_usuarios();
		//for(int i = 0; i<u.size(); i++){
			//System.out.println(u.get(i).toString());
		//}
		//System.out.println(user.validarUsuario(pUsuario));
		//user.crearUsuario(pUsuario);
		//user.cambiarContrasena(5, "nueva");

	}

}
