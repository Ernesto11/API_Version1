package api.pruebas;

import java.util.List;

import api.controlador.DAO.Dao_Unidad_Medida;
import api.modelo.Unidad_Medida;

public class Prueba_Unidad_Medida {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dao_Unidad_Medida um1= new Dao_Unidad_Medida();
		Unidad_Medida um0 = um1.obtener_unidad_medida_id(1);
		System.out.println(um0.toString());
		List<Unidad_Medida> lum = um1.obtener_unidades_medida();
		for(int i=0; i<lum.size();i++){
			System.out.println(lum.get(i));
		}
		um0.setNombreUnidadMedida("Kilolitro");
		um0.setSimbolo("KL");
		um0.setId_UnidadMedida(2);
		um1.crearUnidadMedida(um0);
		um1.editarUnidadMedida(um0);
		um1.eliminarUnidadMedida(3);

	}

}
