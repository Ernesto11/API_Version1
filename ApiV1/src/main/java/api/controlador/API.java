package api.controlador;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;

import api.controlador.DTO.DTO_mensaje;
import api.modelo.Categoria;
import api.modelo.Marca;
import api.modelo.Producto;
import api.modelo.Unidad_Medida;

@Path("/api")
public class API{
	private Controlador controlador = new Controlador();	
	//Metodos Categorias
	@POST
	@Path("/get_categorias")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<Categoria> get_categorias(){
		return controlador.obtener_categorias();
	}
	@POST
	@Path("/get_categoria_id")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Categoria get_categoria_id(Categoria c){
		return controlador.obtener_categoria_id(c.getId_categoria());
	}
	@POST
	@Path("/post_categoria")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public DTO_mensaje post_categoria(Categoria c){
		controlador.crear_categoria(c.getNombreCategoria());
		return null;
	}
	@POST
	@Path("/put_categoria")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public DTO_mensaje put_categoria(Categoria c){
		controlador.editar_categoria(c);
		return null;
	}
	@POST
	@Path("/delete_categoria")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public DTO_mensaje delete_categoria(Categoria c){
		controlador.eliminar_categoria(c.getId_categoria());
		return null;
	}
	//Metodos Unidades medidas
	@POST
	@Path("/get_unidades_medida")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<Unidad_Medida> get_unidades_medida(){
		return controlador.obtener_unidades_medida();
	}
	
	//Metodos Productos
	@POST
	@Path("/get_product_id")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Producto get_product_id(Producto pProducto){
		int id = pProducto.getId_producto();
		return controlador.obtener_producto_id(id);
	}
	@POST
	@Path("/get_products")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<Producto> get_products(){
		return controlador.obtener_productos();
	}
	@POST
	@Path("/post_product")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public DTO_mensaje post_product(Producto p){
		return null;
	}
	
	@POST
	@Path("/delete_product")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public DTO_mensaje delete_product(Producto p){
		return null;
	}

	@POST
	@Path("/put_product")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public DTO_mensaje put_product(Producto p){
		return null;
	}
	
	//METODOS CLASE MARCA
	@POST
	@Path("/get_marca_id")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Marca getMarcaId(Marca pMarca){
		return controlador.obtenerMarcaId(pMarca.getId_marca());
	}
	
	@POST
	@Path("/put_marca")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public DTO_mensaje putMarca(Marca pNvaMarca){
		controlador.crearMarca(pNvaMarca);
		return null;
	}
	
	@POST
	@Path("/delete_marca")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public DTO_mensaje deleteMarca(Marca pMarca){
		controlador.eliminarMarca(pMarca);
		return null;
	}
	
	@POST
	@Path("/edit_marca")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public DTO_mensaje editMarca(Marca pMarca){
		controlador.editarMarca(pMarca);
		return null;
	}
	
	@POST
	@Path("/get_marcas")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<Marca> getMarcas(){
		return controlador.obtenerMarcas();
	}
	
	
	
	

	
	
}
