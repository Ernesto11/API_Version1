package api.controlador.DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import api.modelo.Categoria;
import api.modelo.Producto;
import api.modelo.Unidad_Medida;

public class Dao_Unidad_Medida extends Dao_DB {

	public void crearUnidadMedida(Unidad_Medida pUnidad){
		this.conexion();
		try {
			CallableStatement statement = this.con.prepareCall("{call crear_unidad_medida(?,?)}");
			statement.setString(1, pUnidad.getNombreUnidadMedida());
			statement.setString(2,pUnidad.getSimbolo());
            statement.execute();
            statement.close();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public void editarUnidadMedida(Unidad_Medida pUnidad){
		this.conexion();
		try {
			CallableStatement statement = this.con.prepareCall("{call editar_unidad_medida(?,?,?)}");
			statement.setInt(1, pUnidad.getId_UnidadMedida());
			statement.setString(2, pUnidad.getNombreUnidadMedida());
			statement.setString(3,pUnidad.getSimbolo());
            statement.execute();
            statement.close();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	
	public void eliminarUnidadMedida(int id){
		this.conexion();
		try {
			CallableStatement statement = this.con.prepareCall("{call eliminar_unidad_medida(?)}");
			statement.setInt(1, id);
			statement.executeQuery();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public Unidad_Medida obtener_unidad_medida_id(int id){
		this.conexion();
		Unidad_Medida um = new Unidad_Medida();
		try {
			CallableStatement statement = this.con.prepareCall("{call obtener_unidad_medida_id(?)}");
			statement.setInt(1, id);
			ResultSet resultado = statement.executeQuery();
			if(resultado.next()){
				um.setId_UnidadMedida(resultado.getInt("id_unidad_medida"));
				um.setNombreUnidadMedida(resultado.getString("nombre"));
				um.setSimbolo(resultado.getString("simbolo"));
			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return um;
	}
	public List<Unidad_Medida> obtener_unidades_medida(){
		List<Unidad_Medida> lista = new ArrayList<Unidad_Medida>(); 
		this.conexion();
		try {
			CallableStatement statement = this.con.prepareCall("{call obtener_unidades_medida}");
			ResultSet resultado = statement.executeQuery();
			while (resultado.next()) {
				Unidad_Medida u = new Unidad_Medida();
				u.setId_UnidadMedida(resultado.getInt("id_unidad_medida"));
				u.setNombreUnidadMedida(resultado.getString("nombre"));
				u.setSimbolo(resultado.getString("simbolo"));
				lista.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
}
