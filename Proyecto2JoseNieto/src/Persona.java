
public class Persona {
	private int id;
	private String nombre;
	private String apellido;
	
	public Persona(int id, String nombre, String apellido) {
		this.id = id;
		this.nombre = nombre.toUpperCase();
		this.apellido = apellido.toUpperCase();
		
	}

	@Override
	public String toString() {
		return "Id=" + id + ", Nombre=" + nombre + ", Apellido=" + apellido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido.toUpperCase();
	}

	
	
}
