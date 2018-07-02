package api.controlador;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import api.modelo.Producto;

@Path("/api")
public class API{
	
	@POST
	@Path("/insertarProducto")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public Producto insertarProducto(Producto pProducto){
		return pProducto;
	}
	
	
}
