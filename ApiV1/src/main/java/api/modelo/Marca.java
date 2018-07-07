package api.modelo;

public class Marca {
	
	private int id_marca;
	private String nombre;
	
	
	@Override
	public String toString() {
		return "Marca [id_marca=" + id_marca + ", nombre=" + nombre + "]";
	}
	//GETTERS AND SETTERS
	public int getId_marca() {
		return id_marca;
	}
	public void setId_marca(int id_marca) {
		this.id_marca = id_marca;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
