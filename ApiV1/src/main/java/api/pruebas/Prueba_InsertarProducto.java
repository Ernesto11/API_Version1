package api.pruebas;

import java.sql.SQLException;

import api.controlador.DAO.Dao_Producto;
import api.modelo.Categoria;
import api.modelo.Empresa;
import api.modelo.Marca;
import api.modelo.Producto;
import api.modelo.Unidad_Medida;

public class Prueba_InsertarProducto {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Producto p1 = new Producto();
		Empresa e1 = new Empresa();
		Marca m1 = new Marca();
		Categoria c1 = new Categoria();
		Unidad_Medida u1 = new Unidad_Medida();
		
		e1.setId_empresa(1);
		u1.setId_UnidadMedida(1);
		u1.setValorUnidadMedida(1);
		m1.setId_marca(1);
		c1.setId_categoria(1);
		
		p1.setEmpresa(e1);
		p1.setCategoriaProducto(c1);
		p1.setMarca(m1);
		p1.setUnidadMedida(u1);
		p1.setNombre("Prueba desde eclipse5");
		p1.setCantidadDisponible(1);
		p1.setCantidadMaxima(1);
		p1.setCantidadMinima(1);
		//p1.setCodigoBarras(12345);
		//p1.setCosto(1);
		//p1.setImpuesto(1);
		//p1.setPrecio(1);
		p1.setUrlImagen("none");
		Dao_Producto dp = new Dao_Producto();
		dp.insertarProducto(p1);
	}

}
