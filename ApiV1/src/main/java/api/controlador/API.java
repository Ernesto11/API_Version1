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
import api.modelo.Producto;
import api.modelo.Unidad_Medida;

@Path("/api")
public class API{
	
	private Controlador controlador = new Controlador();
	
	@POST
	@Path("/get_marcas")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Producto get_marcas(Producto pProducto){
		int id = pProducto.getId_producto();
		return controlador.obtener_producto_id(id);
	}

	@POST
	@Path("/get_categorias")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Categoria get_categorias(){
		
		return null;
	}
	
	@POST
	@Path("/get_unidad_Medida")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Unidad_Medida get_unidad_Medida(){
		return null;
	}
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
	
}
