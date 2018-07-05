package api.controlador;

import java.util.ArrayList;
import java.util.List;

import api.controlador.DAO.Dao_Producto;
import api.controlador.DAO.Dao_Unidad_Medida;
import api.modelo.Producto;
import api.modelo.Unidad_Medida;

public class Gestor_Unidad_Medida {
	private Dao_Unidad_Medida db = new Dao_Unidad_Medida();
	private List<Unidad_Medida> lista_unidades_medida = new ArrayList<Unidad_Medida>(); 
	
	
}
