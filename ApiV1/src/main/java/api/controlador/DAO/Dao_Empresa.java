package api.controlador.DAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import api.modelo.Categoria;
import api.modelo.Empresa;

public class Dao_Empresa extends Dao_DB {
	
	public void crearEmpresa(String nombreEmpresa, int id_usuario){
		this.conexion();
		try {
			CallableStatement statement = this.con.prepareCall("{call crear_empresa(?,?)}");
			statement.setInt(1, id_usuario);
			statement.setString(2, nombreEmpresa);
            statement.execute();
            statement.close();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void eliminarEmpresa(int id){
		this.conexion();
		try {
			CallableStatement statement = this.con.prepareCall("{call eliminar_empresa(?)}");
			statement.setInt(1, id);
			statement.executeQuery();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void editarEmpresa(String nombreEmpresa,int id){
		this.conexion();
		try {
			CallableStatement statement = this.con.prepareCall("{call editar_empresa(?,?)}");
			statement.setInt(1, id);
			statement.setString(2, nombreEmpresa);
            statement.execute();
            statement.close();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	
	public Empresa obtener_empresa_id(int id){
		this.conexion();
		Empresa e1 = new Empresa();
		try {
			CallableStatement statement = this.con.prepareCall("{call obtener_empresa_id(?)}");
			statement.setInt(1, id);
			ResultSet resultado = statement.executeQuery();
			if(resultado.next()){
				e1.setId_empresa(resultado.getInt("id_empresa"));
				e1.setNombre(resultado.getString("nombre"));
			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return e1;
	}
	
	public List<Empresa> obtener_empresas(){
		List<Empresa> lista = new ArrayList<Empresa>(); 
		this.conexion();
		try {
			CallableStatement statement = this.con.prepareCall("{call obtener_empresas}");
			ResultSet resultado = statement.executeQuery();
			while (resultado.next()) {
				Empresa e = new Empresa();
				e.setId_empresa(resultado.getInt("id_empresa"));
				e.setNombre(resultado.getString("nombre"));
				lista.add(e);
			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	


}
