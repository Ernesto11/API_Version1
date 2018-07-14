package api.controlador;

import java.text.NumberFormat;
import java.util.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import org.codehaus.jettison.json.JSONArray;




import api.controlador.DTO.DTO_mensaje;
import api.modelo.Categoria;
import api.modelo.Marca;
import api.modelo.Producto;
import api.modelo.Unidad_Medida;

@Path("/api")
public class API{
	private Controlador controlador = new Controlador();	
	
	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void uploadFile(
	      @FormDataParam("file") InputStream fileInputStream,
	      @FormDataParam("file") FormDataContentDisposition fileDetail) {
		savaeToDisk(fileInputStream, fileDetail);
	}
	private void savaeToDisk(InputStream uploadedInputStream,
			FormDataContentDisposition fileDetail){
		String location = getClass().getProtectionDomain().getCodeSource().getLocation().toString().substring(6);
		String uploadedFileLocation = location +"api/controlador/archivo/"+fileDetail.getFileName();
		System.out.println(uploadedFileLocation);
		try {
			OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
			int read =0;
			byte[] bytes = new byte[1024];
			out = new FileOutputStream(new File(uploadedFileLocation));
			while((read = uploadedInputStream.read(bytes)) != -1){
				out.write(bytes,0,read);
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@GET
	@Path("/get")
	@Produces("image/png")
	public Response file(){
		String location = getClass().getProtectionDomain().getCodeSource().getLocation().toString().substring(6);
		String uploadedFileLocation = location +"api/controlador/archivo/"+"test.png";

		File f = new File(uploadedFileLocation);
		ResponseBuilder response = Response.ok((Object)f);
		response.header("Content-Disposition","attachment; filename=get-test.png");
		return response.build();
	}
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
	@POST
	@Path("/get_unidad_medida_id")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Unidad_Medida get_unidad_medida_id(Unidad_Medida um){
		return controlador.obtener_unidad_medida_id(um.getId_UnidadMedida());
	}
	@POST
	@Path("/post_unidad_medida")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public DTO_mensaje crear_unidadMedida(Unidad_Medida pUnidad){
		controlador.crear_unidadMedida(pUnidad);
		return null;
	}
	
	@POST
	@Path("/put_unidad_medida")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public DTO_mensaje editar_unidadMedida(Unidad_Medida pUnidad){
		controlador.editar_unidadMedida(pUnidad);
		return null;
	}
	@POST
	@Path("/delete_unidad_medida")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public DTO_mensaje eliminar_unidad_medida(Unidad_Medida pUnidad){
		controlador.eliminar_unidad_medida(pUnidad.getId_UnidadMedida());
		return null;
	}
	
	//Metodos Productos
	@POST
	@Path("/get_producto_id")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Producto get_product_id(Producto pProducto){
		int id = pProducto.getId_producto();
		return controlador.obtener_producto_id(id);
	}
	@POST
	@Path("/get_productos")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<Producto> get_products(){
		return controlador.obtener_productos();
	}
	@POST
	@Path("/desechar_producto")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public DTO_mensaje desechar_producto(Producto p){
		controlador.desechar_producto(p.getId_producto(), p.getCantidadDisponible());
		return null;
	}
	@POST
	@Path("/post_producto")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public DTO_mensaje post_product(Producto p){
		controlador.insertar_producto(p);
		return null;
	}
	@POST
	@Path("/delete_producto")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public DTO_mensaje delete_product(Producto p){
		
		return null;
	}
	@POST
	@Path("/put_producto")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public DTO_mensaje put_product(Producto p){
		controlador.editar_producto(p);
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
