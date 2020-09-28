
public class Empleado extends Persona {
	
	private int salario;
	
	
	public Empleado (int id, String nombre, String apellido, int salario) {
		super(id, nombre.toUpperCase(), apellido.toLowerCase());
		this.salario = salario;
	}


	public int getSalario() {
		return salario;
	}


	public void setSalario(int salario) {
		this.salario = salario;
	}


	@Override
	public String toString() {
		return "Empleado " + super.toString() + ", Salario=" + getSalario();
	}

}
