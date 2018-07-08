package api.pruebas;

import java.util.List;

import api.controlador.DAO.Dao_Empresa;
import api.modelo.Empresa;

public class Prueba_Empresa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dao_Empresa e = new Dao_Empresa();
		List<Empresa> lista = e.obtener_empresas();
		for(int i=0; i<lista.size();i++){
			System.out.println(lista.get(i).toString());
		}
		//System.out.println(e.obtener_empresa_id(1).toString());
		//e.crearEmpresa("Pepsi", 1);
		//e.eliminarEmpresa(3);
		

	}

}
