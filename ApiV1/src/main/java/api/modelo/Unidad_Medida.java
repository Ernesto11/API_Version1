package api.modelo;

/**
 * 
 * @author nombreEmpresa
 * @version v1.0
 * 
 */

public class Unidad_Medida {
	
	private int id_UnidadMedida;
	private String nombreUnidadMedida;
	private String simbolo;
	private double valorUnidadMedida;
	
	
	//GETTERS AND SETTERS
	public int getId_UnidadMedida() {
		return id_UnidadMedida;
	}
	
	public void setId_UnidadMedida(int id_UnidadMedida) {
		this.id_UnidadMedida = id_UnidadMedida;
	}
	
	public String getNombreUnidadMedida() {
		return nombreUnidadMedida;
	}
	
	public void setNombreUnidadMedida(String nombreUnidadMedida) {
		this.nombreUnidadMedida = nombreUnidadMedida;
	}
	
	public String getSimbolo() {
		return simbolo;
	}
	
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	
	public double getValorUnidadMedida() {
		return valorUnidadMedida;
	}
	
	public void setValorUnidadMedida(double valorUnidadMedida) {
		this.valorUnidadMedida = valorUnidadMedida;
	}
}
