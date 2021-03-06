package api.controlador.DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import api.modelo.Categoria;
import api.modelo.Producto;

public class Dao_Producto extends Dao_DB {

	
	public Producto obtener_producto_id(int id){
		this.conexion();
		Producto p = new Producto();
		try {
			CallableStatement statement = this.con.prepareCall("{call obtener_producto_id(?)}");
			statement.setInt(1, id);
			ResultSet resultado = statement.executeQuery();
			if(resultado.next()){
				p.setId_producto(resultado.getInt("id_producto"));
				p.setNombre(resultado.getString("nombre"));
				p.setCosto(resultado.getDouble("costo"));
				p.setPrecio(resultado.getDouble("precio"));
				p.setImpuesto(resultado.getDouble("impuesto"));
				p.setCantidadDisponible(resultado.getInt("cantidad_disponible"));
				p.setCantidadMaxima(resultado.getInt("cantidad_maxima"));
				p.setCantidadMinima(resultado.getInt("cantidad_minima"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
	public List<Producto> obtener_productos(){
		List<Producto> lista = new ArrayList<Producto>(); 
		this.conexion();
		try {
			CallableStatement statement = this.con.prepareCall("{call obtener_productos}");
			ResultSet resultado = statement.executeQuery();
			while (resultado.next()) {
				Producto p = new Producto();
				p.setId_producto(resultado.getInt("id_producto"));
				p.setNombre(resultado.getString("nombre"));
				p.setCosto(resultado.getDouble("costo"));
				p.setPrecio(resultado.getDouble("precio"));
				p.setImpuesto(resultado.getDouble("impuesto"));
				p.setCantidadDisponible(resultado.getInt("cantidad_disponible"));
				p.setCantidadMaxima(resultado.getInt("cantidad_maxima"));
				p.setCantidadMinima(resultado.getInt("cantidad_minima"));
				Categoria c = new Categoria();
				c.setId_categoria(1);
				c.setNombreCategoria("nombre 1");
				p.setCategoriaProducto(c);
				lista.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void insertarProducto(Producto pProducto){
		this.conexion();
		try {
			CallableStatement statement = this.con.prepareCall("{call insertar_Producto(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			statement.setInt(1, pProducto.getEmpresa().getId_empresa());
			statement.setInt(2, pProducto.getCategoriaProducto().getId_categoria());
			statement.setInt(3, pProducto.getUnidadMedida().getId_UnidadMedida());
			statement.setInt(4, pProducto.getMarca().getId_marca());
			statement.setString(5, pProducto.getNombre());
			statement.setDouble(6, pProducto.getPrecio());
			statement.setDouble(7, pProducto.getCosto());
			statement.setDouble(8, pProducto.getImpuesto());
			statement.setInt(9,pProducto.getCodigoBarras());
			statement.setDouble(10, pProducto.getUnidadMedida().getValorUnidadMedida());
			statement.setInt(11,pProducto.getCantidadDisponible());
			statement.setInt(12,pProducto.getCantidadMinima());
			statement.setInt(13,pProducto.getCantidadMaxima());
			statement.setString(14, pProducto.getUrlImagen());
            statement.execute();
            statement.close();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void editarProducto(Producto pProducto){
		this.conexion();
		try {
			CallableStatement statement = this.con.prepareCall("{call editar_producto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			statement.setInt(1, pProducto.getId_producto());
			statement.setInt(2, pProducto.getEmpresa().getId_empresa());
			statement.setInt(3, pProducto.getCategoriaProducto().getId_categoria());
			statement.setInt(4, pProducto.getUnidadMedida().getId_UnidadMedida());
			statement.setInt(5, pProducto.getMarca().getId_marca());
			statement.setString(6, pProducto.getNombre());
			statement.setDouble(7, pProducto.getPrecio());
			statement.setDouble(8, pProducto.getCosto());
			statement.setDouble(9, pProducto.getImpuesto());
			statement.setInt(10,pProducto.getCodigoBarras());
			statement.setDouble(11, pProducto.getUnidadMedida().getValorUnidadMedida());
			statement.setInt(12,pProducto.getCantidadDisponible());
			statement.setInt(13,pProducto.getCantidadMinima());
			statement.setInt(14,pProducto.getCantidadMaxima());
			statement.setString(15, pProducto.getUrlImagen());
            statement.execute();
            statement.close();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
	}
	
	public void desecharProducto(int pId_producto, int pCantidadDesecho){
		this.conexion();
		try {
			CallableStatement statement = this.con.prepareCall("{call desechar_producto(?,?)}");
			statement.setInt(1, pId_producto);
			statement.setInt(2, pCantidadDesecho);
            statement.execute();
            statement.close();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
}
