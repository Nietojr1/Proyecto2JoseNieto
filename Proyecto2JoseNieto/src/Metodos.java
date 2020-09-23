import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class Metodos extends TomaDatos {
	
	
public void menu() {

	List<Empleado> listEmpleado = new ArrayList<>();
	int opc= 1;
	do {		
		try {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el opcion que decea realizar \n 1. Agregar Empleado \n 2. Eliminar empleado \n 3. Modificar Empleado \n 4. Listar Empleados \n 5. Salir"));
		}catch (NumberFormatException exception) {
			JOptionPane.showMessageDialog(null, "Debe ingresar solo valores numéricos", "Error al ingresar información",  0);
		}
		//Ingresar Empleados
		if(opc ==1 ) {
			boolean encontrado = false;
			int i = 0;
			TomaDatos dat = new TomaDatos();
			int idE = dat.getEmpleado().getId();
			while (encontrado == false && i< listEmpleado.size()) {
				if (listEmpleado.get(i).getId()== idE ) {
					encontrado = true;
				}else {
					i++;
				}
			}
			if (encontrado) {
				JOptionPane.showMessageDialog(null, "Ya existe un empleado con ese Id, se llama: \n"+ "Nombre: " +listEmpleado.get(i).getNombre() + "\nApellido: "+ listEmpleado.get(i).getApellido()+ "\nSalario: "+ listEmpleado.get(i).getSalario(), "Busqueda Exitosa",  1);
				
			}else {
				listEmpleado.add(dat.getEmpleado());
				JOptionPane.showMessageDialog(null, "El Empleado ha sido registrado", "Registro Exitoso",  1);	
			}			
		}else
			//Eliminar Empleados
			if (opc==2) {
				boolean encontrado = false;
				int i = 0;
				int idE = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del empleado a eliminar"));
				while (encontrado == false && i< listEmpleado.size()) {
					if (listEmpleado.get(i).getId()== idE ) {
						encontrado = true;
					}else {
						i++;
					}
				}
				if (encontrado) {
					JOptionPane.showMessageDialog(null, "El empleado a eliminar es: \n"+ "Nombre: " +listEmpleado.get(i).getNombre() + "\nApellido: "+ listEmpleado.get(i).getApellido()+ "\nSalario: "+ listEmpleado.get(i).getSalario()  , "Busqueda Exitosa",  1);
					listEmpleado.remove(i);
				}else {
					JOptionPane.showMessageDialog(null, "No existe un empleado con ese Id", "Busqueda completada",  2);
				}
								
			}else 
				//Modificar Empleado
				if (opc ==3) {
					boolean encontrado = false;
					int i = 0;
					int idE = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del empleado a eliminar"));
					while (encontrado == false && i< listEmpleado.size()) {
						if (listEmpleado.get(i).getId()== idE ) {
							encontrado = true;
						}else {
							i++;
						}
					}
					if (encontrado) {
						int salario=0;	
						JOptionPane.showMessageDialog(null, "El empleado a modificar es: \n"+ "Nombre: " +listEmpleado.get(i).getNombre() + "\nApellido: "+ listEmpleado.get(i).getApellido()+ "\nSalario: "+ listEmpleado.get(i).getSalario(), "Busqueda Exitosa",  1);
						String nombre = JOptionPane.showInputDialog("Ingrese el  nuevo Nombre");
						String apellido = JOptionPane.showInputDialog("Ingrese el nuevo Apellido");
						do {	
							try {
								salario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo Salario"));
							}catch (NumberFormatException exception) {
								JOptionPane.showMessageDialog(null, "Debe ingresar solo valores numéricos", "Error al ingresar información",  0);
							}
						}while(salario <= 0 );
						
						listEmpleado.get(i).setNombre(nombre);
						listEmpleado.get(i).setApellido(apellido);
						listEmpleado.get(i).setSalario(salario);
					}else {
						JOptionPane.showMessageDialog(null, "No existe un empleado con ese Id", "Busqueda completada",  2);
					}
				}
				else 
					//Listar Empleados
					if(opc ==4) {
						String cadena ="";
						for (Empleado empleado: listEmpleado) {
							cadena += empleado + "\n";
						}	
						JOptionPane.showMessageDialog(null,"\n" + cadena, "Lista de Empleados",  1);
					}
					else
					//Salir del Sistema	
					 if (opc==5){
						JOptionPane.showMessageDialog(null, " Hasta pronto", "Saliendo de Sistema",  1);
						System.exit(0);
					//Si la opcion no esta en el menu	
					}else {
						JOptionPane.showMessageDialog(null, "La opción tecleada no se encuentra en el menú", "Registro Empleado",  0);
					}

	}while(opc !=5);		
	
  }

	
}



