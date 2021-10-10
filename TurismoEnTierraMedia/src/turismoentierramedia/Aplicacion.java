package turismoentierramedia;

import java.util.ArrayList;

import java.util.Scanner;

import java.util.Comparator;
import java.util.List;

//La aplicacion se encarga del manejo y organizacion de todas las atracciones y promociones disponibles.

public class Aplicacion {

	// Todas las listas necesarias para organizar
	List<Atraccion> todasLasAtracciones = new ArrayList<Atraccion>();
	List<Atraccion> atraccionesDeAventura = new ArrayList<Atraccion>();
	List<Atraccion> atraccionesDeDegustacion = new ArrayList<Atraccion>();
	List<Atraccion> atraccionesDePaisaje = new ArrayList<Atraccion>();

	// El constructor recibe una lista de atracciones
	public Aplicacion(List<Atraccion> Atracciones) {
		super();
		this.todasLasAtracciones = Atracciones;

	}

	public void separarAtracciones() {

		for (int i = 0; i < this.todasLasAtracciones.size(); i++) {

			if (this.todasLasAtracciones.get(i).getTipo().equals("A")) {
				atraccionesDeAventura.add(todasLasAtracciones.get(i));

			} else if (this.todasLasAtracciones.get(i).getTipo().equals("P")) {
				atraccionesDePaisaje.add(todasLasAtracciones.get(i));

			} else if (this.todasLasAtracciones.get(i).getTipo().equals("D")) {
				atraccionesDeDegustacion.add(todasLasAtracciones.get(i));

			}
		}

		atraccionesDeAventura.sort(Comparator.comparing(Atraccion::getValor).reversed());
		atraccionesDePaisaje.sort(Comparator.comparing(Atraccion::getValor).reversed());
		atraccionesDeDegustacion.sort(Comparator.comparing(Atraccion::getValor).reversed());

	}

	public void ofrecerAtracciones(Usuario unUsuario) {

		if (unUsuario.getAtraccionFavorita().equals("P")) {

			for (Atraccion cadaAtraccion : this.atraccionesDePaisaje) {

				if (unUsuario.podriasIrA(cadaAtraccion) && unUsuario.todaviaNoVasA(cadaAtraccion)
						&& cadaAtraccion.getUsosDisponibles() > 0) {

					Scanner entrada = new Scanner(System.in);

					System.out.println(unUsuario.nombre + ", te gustaria ir a " + cadaAtraccion.nombre + "? ( S/N )");
					char seleccion = entrada.next().charAt(0);
					
					System.out.println("Es una " +seleccion);
					
					

					while (seleccion != 'S' && seleccion != 'N') {

						System.out.println("Error, debe ingresar solo una S o una N");
						System.out.println(unUsuario.nombre + ", te gustaria ir a " + cadaAtraccion.nombre + "? ( S/N )");
						

						
						seleccion = entrada.next().charAt(0);

					}
					
					
					
					if(seleccion == 'S') {
						
						cadaAtraccion.reservarLugar(unUsuario);					
					} else if (seleccion == 'N') {
						
						System.out.println("No vas a ir a " + cadaAtraccion.nombre);
						
					}
				}
			}
		} else if (unUsuario.getAtraccionFavorita().equals("A")) {

			for (Atraccion cadaAtraccion : this.atraccionesDeAventura) {

				if (unUsuario.podriasIrA(cadaAtraccion) && unUsuario.todaviaNoVasA(cadaAtraccion)
						&& cadaAtraccion.getUsosDisponibles() > 0) {

					Scanner entrada = new Scanner(System.in);
					System.out.println(unUsuario.nombre + ", te gustaria ir a " + cadaAtraccion.nombre + "? ( S/N )");
					char seleccion = entrada.next().charAt(0);
					
					System.out.println("Es una " +seleccion);

				
					while (seleccion != 'S' && seleccion != 'N') {

						System.out.println("Error, debe ingresar solo una S o una N");
						System.out.println(unUsuario.nombre + ", te gustaria ir a " + cadaAtraccion.nombre + "? ( S/N )");
						
					seleccion = entrada.next().charAt(0);

					}
					
					
					
					if(seleccion == 'S') {
						
						cadaAtraccion.reservarLugar(unUsuario);					
					}
				}
			}
		} else if (unUsuario.getAtraccionFavorita().equals("D")) {

			for (Atraccion cadaAtraccion : this.atraccionesDeDegustacion) {

				if (unUsuario.podriasIrA(cadaAtraccion) && unUsuario.todaviaNoVasA(cadaAtraccion)
						&& cadaAtraccion.getUsosDisponibles() > 0) {

					Scanner entrada = new Scanner(System.in);
					System.out.println(unUsuario.nombre + ", te gustaria ir a " + cadaAtraccion.nombre + "? ( S/N )");
					char seleccion = entrada.next().charAt(0);
					
					
					

					while (seleccion != 'S' && seleccion != 'N') {

						System.out.println("Error, debe ingresar solo una S o una N");
						System.out.println(unUsuario.nombre + ", te gustaria ir a " + cadaAtraccion.nombre + "? ( S/N )");
						
					seleccion = entrada.next().charAt(0);

					}
					
					
					
					if(seleccion == 'S') {
						
						cadaAtraccion.reservarLugar(unUsuario);					
					}



				}
			}
		}

	}

}
