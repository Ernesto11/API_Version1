package api.pruebas;

import java.util.List;

import api.controlador.DAO.Dao_Categoria;
import api.controlador.DAO.Dao_Producto;
import api.modelo.Categoria;
import api.modelo.Empresa;
import api.modelo.Marca;
import api.modelo.Producto;
import api.modelo.Unidad_Medida;

public class Prueba_categoria {
	public static void main(String[] args)  {
		
		Dao_Categoria c1= new Dao_Categoria();
		c1.eliminarCategoria(4);
		Categoria c2 = new Categoria();
		c2.setNombreCategoria("Arroz Precocido");
		c2.setId_categoria(6);
		List<Categoria> lista  = c1.obtener_categorias();
		for(int i=0;i<lista.size();i++){
			System.out.println(lista.get(i));
		}
		
		
	}
}
