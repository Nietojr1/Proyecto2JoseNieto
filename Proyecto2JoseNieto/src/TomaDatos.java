import javax.swing.JOptionPane;

public class TomaDatos {
	private Empleado empleado;
	
public TomaDatos() {
	tomInfEmpleado();
}
	
public void tomInfEmpleado() {
		Persona infPersona = tomInfPersona ();
		int salario=0;
		do {
			
			try {
				salario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el salario del empleado"));
			}catch (NumberFormatException exception) {
				JOptionPane.showMessageDialog(null, "Debe ingresar solo valores numericos", "Error al ingresar informacion",  0);
			}
			
		}while(salario <= 0 );		
		setEmpleado(new Empleado(infPersona.getId(),infPersona.getNombre(),infPersona.getApellido(),salario));
	}
	

public Persona  tomInfPersona() {
	int id = 0;
	do {		
		try {
			id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la identificacion del empleado"));
		}catch (NumberFormatException exception) {
			JOptionPane.showMessageDialog(null, "Debe ingresar solo valores numericos", "Error al ingresar informacion",  0);
		}		
	}while(id <= 0);		
	String nombre = JOptionPane.showInputDialog("Ingrese el Nombre");
	String apellido = JOptionPane.showInputDialog("Ingrese el Apellido");
	return new Persona (id, nombre, apellido);
	}


public Empleado getEmpleado() {
	return empleado;
}


public void setEmpleado(Empleado empleado) {
	this.empleado = empleado;
}



}
