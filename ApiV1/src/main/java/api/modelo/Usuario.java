package api.modelo;

public class Usuario {
	
	private String nombre;
	private String contrasena;
	private String tipo;
	
	
	@Override
	public String toString() {
		return "Usuario [id_usuario=" + ", nombre=" + nombre
				+ ", contrasena=" + contrasena + ", tipo=" + tipo + "]";
	}
	//GETTERS AND SETTERS

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
