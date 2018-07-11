package api.controlador;

import java.util.List;

import api.controlador.DAO.Dao_Marca;
import api.modelo.Marca;

public class Gestor_Marca {
	
	private Dao_Marca dao_marca;
	
	public Gestor_Marca(){
		dao_marca = new Dao_Marca();
	}
	
	public void crearMarca(String pNombre){
		dao_marca.crearMarca(pNombre);
	}
	
	public void eliminarMarca(int id){
		dao_marca.eliminarMarca(id);
	}
	
	public void editarMarca(int id,String pNombre){
		dao_marca.editarMarca(id,pNombre);
	}
	
	public Marca obtenerMarcaId(int id){
		return dao_marca.obtener_marca_id(id);
	}
	
	public List<Marca> obtenerMarcas(){
		return dao_marca.obtener_marcas();
	}

}
