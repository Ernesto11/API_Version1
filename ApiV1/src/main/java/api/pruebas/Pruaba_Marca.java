package api.pruebas;

import java.util.List;

import api.controlador.DAO.Dao_Marca;
import api.modelo.Marca;

public class Pruaba_Marca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dao_Marca m1 = new Dao_Marca();
		m1.crearMarca("Tio Pelon");
		
		Marca m2 = m1.obtener_marca_id(2);
		m2.setNombre("prueba desde");
		m1.editarMarca(m2);
		System.out.println(m2.toString());
		m1.eliminarMarca(2);
		List<Marca> lm = m1.obtener_marcas();
		for(int i=0; i< lm.size();i++ ){
			System.out.println(lm.get(i));
		}
	}

}
