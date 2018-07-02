package api.controlador;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
		System.out.println("Producto id "+pProducto.getId_producto());
		int id = pProducto.getId_producto();
		return controlador.obtener_producto_id(id);
	}
	
	
	
}
