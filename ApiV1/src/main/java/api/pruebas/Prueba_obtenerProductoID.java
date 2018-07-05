package api.pruebas;

import java.util.List;

import api.controlador.DAO.Dao_Producto;
import api.modelo.Producto;

public class Prueba_obtenerProductoID {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dao_Producto dp = new Dao_Producto();
		Producto p1 = dp.obtener_producto_id(1);
		System.out.print(p1.toString());
		
		List<Producto> p2 = dp.obtener_productos();

		for(int i =0; i<p2.size();i++){
			System.out.println(p2.get(i).toString());
		}

	}

}
