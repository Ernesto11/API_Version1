package api.controlador;

import java.util.List;

import api.modelo.Categoria;
import api.modelo.Producto;
import api.modelo.Unidad_Medida;


public class Controlador {
	private Gestor_Producto gp = new Gestor_Producto();
	private Gestor_Marca gm = new Gestor_Marca();
	private Gestor_Categoria gc = new Gestor_Categoria();
	private Gestor_Unidad_Medida gu = new Gestor_Unidad_Medida();
	
	public Producto obtener_producto_id (int id){
		return gp.obtener_producto_id(id);
	}
	public List<Producto> obtener_productos(){
		return gp.obtener_productos();
	}
	public List<Categoria> obtener_categorias(){
		return gc.obtener_categorias();
	}
	public List<Unidad_Medida> obtener_unidades_medida(){
		return gu.Obtener_unidades_medida();
	}
}
