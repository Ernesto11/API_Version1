package api.controlador;

import java.util.List;

import api.controlador.DAO.Dao_Marca;
import api.modelo.Marca;

public class Gestor_Marca {
	
	private Dao_Marca dao_marca;
	
	public Gestor_Marca(){
		dao_marca = new Dao_Marca();
	}
	
	public void crearMarca(Marca pMarca){
		dao_marca.crearMarca(pMarca);
	}
	
	public void eliminarMarca(Marca pMarca){
		dao_marca.eliminarMarca(pMarca);
	}
	
	public void editarMarca(Marca pMarca){
		dao_marca.editarMarca(pMarca);
	}
	
	public Marca obtenerMarcaId(int id){
		return dao_marca.obtener_marca_id(id);
	}
	
	public List<Marca> obtenerMarcas(){
		return dao_marca.obtener_marcas();
	}

}
