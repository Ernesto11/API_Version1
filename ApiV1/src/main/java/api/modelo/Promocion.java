package api.modelo;

import java.util.Date;

/**
 * 
 * @author nombreEmpresa
 * @version v1.0
 * 
 */

public class Promocion {
	
	private int id_promocion;
	private Date fecha;
	private double porcentajeDescuento;
	private Producto productoDescuento;
	
	
	//GETTERS AND SETTERS
	public int getId_promocion() {
		return id_promocion;
	}
	
	public void setId_promocion(int id_promocion) {
		this.id_promocion = id_promocion;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}
	
	public void setPorcentajeDescuento(double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
	
	public Producto getProductoDescuento() {
		return productoDescuento;
	}
	
	public void setProductoDescuento(Producto productoDescuento) {
		this.productoDescuento = productoDescuento;
	}
}
