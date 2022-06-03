package entidades;

public class Censista {

	private String nombre;
	private String apellido;
	private Long dni;

	public Censista(String nombre, String apellido, Long dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Long getDni() {
		return dni;
	}

}
