import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;
public class Metodos {
	
	
public void menu() {

	List<Empleado> listEmpleado = new ArrayList<>();
	int opc= 7;
	do {		
		try {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el opcion que decea realizar \n "
					+ "1. Agregar Empleado \n "
					+ "2. Eliminar empleado \n "
					+ "3. Modificar Empleado \n "
					+ "4. Listar Empleados \n "
					+ "5. Empleado de Mayor salario \n "
					+ "6. Empleado de menor salario \n "
					+ "7. Ordenar empleados por nombre \n "
					+ "8. Suma de salarios mayores 700.000 \n "
					+ "9. Numero empleados con apellido inicia con la letra a \n "
					+ "10. Los 5 primeros empleados con mayor salario \n "
					+ "11. Salir  \n"));
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
					int idE = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del empleado a modificar"));
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
						//Salario mayor
						if(opc ==5) {
							Optional<Empleado> setFiltrada = listEmpleado.stream()									
									.max(Comparator.comparing(empleado-> empleado.getSalario()));								
							JOptionPane.showMessageDialog(null, "El empleado con mayor salario es:  "
												+ "\n Id: "	+ setFiltrada.get().getId()
												+ "\n Nombre: "	+ setFiltrada.get().getNombre()
												+ "\n Apellido: "+ setFiltrada.get().getApellido() 
												+ "\n Salario: " + setFiltrada.get().getSalario(), "Mayor Salario",  1);			
						}
						else
							//Salario Menor
							if(opc ==6) {
								Optional<Empleado> setFiltrada = listEmpleado.stream()									
										.min(Comparator.comparing(empleado-> empleado.getSalario()));								
								JOptionPane.showMessageDialog(null, "El empleado con menor salario es:  "
													+ "\n Id: "	+ setFiltrada.get().getId()
													+ "\n Nombre: "	+ setFiltrada.get().getNombre()
													+ "\n Apellido: "+ setFiltrada.get().getApellido() 
													+ "\n Salario: " + setFiltrada.get().getSalario(), "Menor Salario",  1);
							}
							else
								//Ordenar Empleados
								if(opc ==7) {
									String cadena ="";
									List<Empleado> setFiltrada = listEmpleado.stream()									
											.sorted(Comparator.comparing(empleado-> empleado.getNombre()))	
											 .collect(Collectors.toList());
									
									for (Empleado empleado: setFiltrada) {
										cadena += empleado + "\n";
									}	
									JOptionPane.showMessageDialog(null,"\n" + cadena, "Lista de Empleados",  1);												
								}
								else
									//Hallar suma salarios mayor de 700.000
									if(opc ==8) {
										Integer setFiltrada = listEmpleado.stream()
																			.filter(empleado -> empleado.getSalario()>700000)																																															
																			.map(empleado -> empleado.getSalario())
																			.reduce(0,(aco,salario)-> aco + salario);																			
												
										JOptionPane.showMessageDialog(null,"La suma de los salarios superiores a 700.000 es: \n" + setFiltrada + " Pesos", "Suma de Salarios",  1);										
									}
									else
										//Numero de Empleados apellido empieza por A  
										if(opc ==9) {
											Long setFiltrada = listEmpleado.stream()									
													.filter(empleado -> empleado.getApellido().charAt(0) == 'A')
													.count();
											JOptionPane.showMessageDialog(null, "El numero de empleados cuyo apellido inicia con la letra (A) es: \n"+ setFiltrada +" Empleados" , "Numero Empleados ",  1);			
										}
										else
											//Los 5 primeros empleados de mayor salario 
											if(opc ==10) {
												String cadena ="";
												List<Empleado> setFiltrada = listEmpleado.stream()									
														.sorted(Comparator.comparing(empleado-> empleado.getSalario(), Comparator.reverseOrder()))	
														.limit(5)
														.collect(Collectors.toList());
												
												for (Empleado empleado: setFiltrada) {
													cadena += empleado + "\n";
												}	
												JOptionPane.showMessageDialog(null,"Estos son los 5 empleados con mayor salario: \n" + cadena, "Lista de Empleados ",  1);
											}
											else												
												//Salir del Sistema	
												 if (opc==11){
													JOptionPane.showMessageDialog(null, " Hasta pronto", "Saliendo de Sistema",  1);
													System.exit(0);
													
												//Si la opcion no esta en el menu	
													}else {
														JOptionPane.showMessageDialog(null, "La opción tecleada no se encuentra en el menú", "Registro Empleado",  0);
													}
	}while(opc !=11);		
	
  }

	
}



