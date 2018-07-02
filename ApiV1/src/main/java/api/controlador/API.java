package api.controlador;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;

import api.modelo.Producto;

@Path("/api")
public class API{
	
	private Controlador controlador = new Controlador();
	
	@POST
	@Path("/insertarProducto")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Producto insertarProducto(Producto pProducto){
		return pProducto;
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
	public List<Producto> post_product(){
		return controlador.obtener_productos();
	}
	@POST
	@Path("/delete_product")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<Producto> delete_product(Producto p){
		return controlador.obtener_productos();
	}
	@POST
	@Path("/put_product")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public void put_product(Producto p){
		//return controlador.obtener_productos();
	}
	
}
