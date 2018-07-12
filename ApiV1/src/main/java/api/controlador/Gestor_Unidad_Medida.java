package api.controlador;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import api.controlador.DAO.Dao_Producto;
import api.controlador.DAO.Dao_Unidad_Medida;
import api.modelo.Producto;
import api.modelo.Unidad_Medida;

public class Gestor_Unidad_Medida {
	private Dao_Unidad_Medida db = new Dao_Unidad_Medida();
	private List<Unidad_Medida> lista_unidades_medida = new ArrayList<Unidad_Medida>(); 
	
	public List<Unidad_Medida> Obtener_unidades_medida() {
		lista_unidades_medida = db.obtener_unidades_medida();
		return lista_unidades_medida;
	}
	public Unidad_Medida obtener_unidad_medida_id(int id) {
		return db.obtener_unidad_medida_id(id);
	}
	public void crear_unidadMedida(Unidad_Medida pUnidad){
		db.crearUnidadMedida(pUnidad);
	}
	
	public void editar_unidadMedida(Unidad_Medida pUnidad){
		db.editarUnidadMedida(pUnidad);
	}
	
	public void eliminar_unidad_medida(int id){
		db.eliminarUnidadMedida(id);
	}
}
