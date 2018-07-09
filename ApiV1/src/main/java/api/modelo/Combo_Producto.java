package api.modelo;

import java.util.ArrayList;

/**
 * 
 * @author nombreEmpresa
 * @version v1.0
 * 
 */

public class Combo_Producto {
	
	private int id_combo;
	private String nombre;
	private ArrayList<Producto> productosCombo;
	
	public void agregarProductoCombo(Producto pProducto){
		productosCombo.add(pProducto);
	}
	
	//GETTERS AND SETTERS
	public int getId_combo() {
		return id_combo;
	}
	
	public void setId_combo(int id_combo) {
		this.id_combo = id_combo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public ArrayList<Producto> getProductosCombo() {
		return productosCombo;
	}
	
	public void setProductosCombo(ArrayList<Producto> productosCombo) {
		this.productosCombo = productosCombo;
	}

}
