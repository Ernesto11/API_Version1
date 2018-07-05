package api.controlador;

import java.util.ArrayList;
import java.util.List;

import api.controlador.DAO.Dao_Categoria;
import api.controlador.DAO.Dao_Producto;
import api.modelo.Categoria;
import api.modelo.Producto;

public class Gestor_Categoria {
	private Dao_Categoria db = new Dao_Categoria();
	private List<Categoria> lista_categorias = new ArrayList<Categoria>(); 
	
	public List<Categoria> obtener_categorias(){
		lista_categorias=db.obtener_categorias();
		return lista_categorias;
	}
}
