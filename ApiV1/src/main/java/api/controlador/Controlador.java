package api.controlador;

import java.util.List;

import api.modelo.Categoria;
import api.modelo.Marca;
import api.modelo.Producto;
import api.modelo.Unidad_Medida;


public class Controlador {
	private Gestor_Producto gp = new Gestor_Producto();
	private Gestor_Marca gm = new Gestor_Marca();
	private Gestor_Categoria gc = new Gestor_Categoria();
	private Gestor_Unidad_Medida gu = new Gestor_Unidad_Medida();
	
	//Metodos Producto
	public Producto obtener_producto_id (int id){
		return gp.obtener_producto_id(id);
	}
	public List<Producto> obtener_productos(){
		return gp.obtener_productos();
	}
	public void insertar_producto(Producto pProducto){
		gp.insertar_producto(pProducto);
	}	
	public void editar_producto(Producto pProducto){
		gp.editar_producto(pProducto);
	}
	public void desechar_producto(int pId_producto, int pCantidadDesecho){
		gp.desechar_producto(pId_producto, pCantidadDesecho);
	}
	
	//Metodos Unidades de Medida
	public List<Unidad_Medida> obtener_unidades_medida(){
		return gu.Obtener_unidades_medida();
	}
	public Unidad_Medida obtener_unidad_medida_id(int id) {
		return gu.obtener_unidad_medida_id(id);
	}
	public void crear_unidadMedida(Unidad_Medida pUnidad){
		gu.crear_unidadMedida(pUnidad);
	}
	
	public void editar_unidadMedida(Unidad_Medida pUnidad){
		gu.editar_unidadMedida(pUnidad);
	}
	
	public void eliminar_unidad_medida(int id){
		gu.eliminar_unidad_medida(id);
	}
	//METODOS GESTOR MARCA
	public Marca obtenerMarcaId(int id){
		return gm.obtenerMarcaId(id);
	}
	
	public List<Marca> obtenerMarcas(){
		return gm.obtenerMarcas();
	}
	
	public void crearMarca(Marca pMarca){
		gm.crearMarca(pMarca);
	}
	
	public void eliminarMarca(Marca pMarca){
		gm.eliminarMarca(pMarca);
	}
	
	public void editarMarca(Marca pMarca){
		gm.editarMarca(pMarca);
	}
	//Metodos Categoria
	public List<Categoria> obtener_categorias(){return gc.obtener_categorias();}
	public Categoria obtener_categoria_id(int id){return gc.obtener_categoria_id(id);}
	public void crear_categoria(String pNombre){gc.crear_categoria(pNombre);}
	public void editar_categoria(Categoria pCategoria){gc.editar_categoria(pCategoria);}
	public void eliminar_categoria(int id){gc.eliminar_categoria(id);}
}
