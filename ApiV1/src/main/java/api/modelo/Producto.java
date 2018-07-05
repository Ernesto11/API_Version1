package api.modelo;

import java.io.File;

/**
 * 
 * @author NombreEmpresa
 * @version v1.0
 * 
 */

public class Producto {
	
	private int id_producto;
	private Empresa empresa;
	private Categoria categoriaProducto;
	private Unidad_Medida unidadMedida;
	private Marca marca; 
	private String nombre;
	private double precio;
	private double costo;
	private double impuesto;
	private int codigoBarras;
	private int cantidadDisponible;
	private int cantidadMinima;
	private int cantidadMaxima;
	private String urlImagen;
	private String detalle;
	
	
	
	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", empresa=" + empresa
				+ ", categoriaProducto=" + categoriaProducto
				+ ", unidadMedida=" + unidadMedida + ", marca=" + marca
				+ ", nombre=" + nombre + ", precio=" + precio + ", costo="
				+ costo + ", impuesto=" + impuesto + ", codigoBarras="
				+ codigoBarras + ", cantidadDisponible=" + cantidadDisponible
				+ ", cantidadMinima=" + cantidadMinima + ", cantidadMaxima="
				+ cantidadMaxima + ", urlImagen=" + urlImagen + ", detalle="
				+ detalle + "]";
	}

	//GETTERS AND SETTERS	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public double getCosto() {
		return costo;
	}
	
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	public double getImpuesto() {
		return impuesto;
	}
	
	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}
	
	public int getCantidadDisponible() {
		return cantidadDisponible;
	}
	
	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}
	
	public int getCantidadMinima() {
		return cantidadMinima;
	}
	
	public void setCantidadMinima(int cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}
	
	public int getCantidadMaxima() {
		return cantidadMaxima;
	}
	
	public void setCantidadMaxima(int cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
	}
	
	public Unidad_Medida getUnidadMedida() {
		return unidadMedida;
	}
	
	public void setUnidadMedida(Unidad_Medida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	
	public Categoria getCategoriaProducto() {
		return categoriaProducto;
	}
	
	public void setCategoriaProducto(Categoria categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}
	
	public String getUrlImagen() {
		return urlImagen;
	}
	
	public void setUrlImagen(String imagen) {
		this.urlImagen = imagen;
	}
	
	public Marca getMarca() {
		return marca;
	}
	
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	public int getCodigoBarras() {
		return codigoBarras;
	}
	
	public void setCodigoBarras(int codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	
	public String getDetalle() {
		return detalle;
	}
	
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
}
