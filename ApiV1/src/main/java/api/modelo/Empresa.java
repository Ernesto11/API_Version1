package api.modelo;

public class Empresa {
	
	private int id_empresa;
	private String nombre;
	
	
	
	@Override
	public String toString() {
		return "Empresa [id_empresa=" + id_empresa + ", nombre=" + nombre + "]";
	}
	
	//GETTERS AND SETTERS
	public int getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
