package turismoentierramedia;

import java.util.ArrayList;
import java.util.List;

public class testeoPorConsola {

	public static void main(String[] args) {

		List<Atraccion> todasLasAtracciones = new ArrayList<Atraccion>();
		List<Usuario> todosLosUsuarios = new ArrayList<Usuario>();
		List<Promocion> todasLasPromociones = new ArrayList<Promocion>();

		LeeArchivos lector = new LeeArchivos();

		lector.leerUsuarios("Usuarios.txt", todosLosUsuarios);
		lector.LeerAtracciones("Atracciones.txt", todasLasAtracciones);

		Aplicacion APP = new Aplicacion(todasLasAtracciones);

		APP.separarAtracciones();

		for (int i = 0; i < todosLosUsuarios.size(); i++) {

			APP.ofrecerAtracciones(todosLosUsuarios.get(i));

			System.out.println(todosLosUsuarios.get(i).nombre + " va a ir a:");
			todosLosUsuarios.get(i).itinerario.forEach(System.out::println);

		}

	}

}
