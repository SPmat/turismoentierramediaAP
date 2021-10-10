package turismoentierramedia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class tierraMediaTest {

	@Test
	public void lecturaDeUsuariosTest() {

		List<Usuario> todosLosUsuarios = new ArrayList<Usuario>();
		LeeArchivos lector = new LeeArchivos();
		lector.leerUsuarios("Usuarios.txt", todosLosUsuarios);

		assertEquals("sam", todosLosUsuarios.get(0).getNombre());
		// assertEquals(36, todosLosUsuarios.get(0).getMonedas(), 0.1);

	}

	@Test
	public void lecturaDeArchivoAtraccionesTest() {

		List<Atraccion> todasLasAtracciones = new ArrayList<Atraccion>();

		LeeArchivos lector = new LeeArchivos();
		lector.LeerAtracciones("Atracciones.txt", todasLasAtracciones);

		assertEquals(8, todasLasAtracciones.size());

	}

	@Test
	public void soloAventuraTest() {

		List<Atraccion> todasLasAtracciones = new ArrayList<Atraccion>();

		LeeArchivos lector = new LeeArchivos();
		lector.LeerAtracciones("Atracciones.txt", todasLasAtracciones);

		// todasLasAtracciones.get(0).setTipo("D");

		Aplicacion APP = new Aplicacion(todasLasAtracciones);
		APP.separarAtracciones();

		assertEquals(3, APP.atraccionesDeAventura.size());

	}

	@Test
	public void DegustacionMasCaraTest() {

		List<Atraccion> todasLasAtracciones = new ArrayList<Atraccion>();

		LeeArchivos lector = new LeeArchivos();
		lector.LeerAtracciones("Atracciones.txt", todasLasAtracciones);

		// todasLasAtracciones.get(0).setTipo("D");

		Aplicacion APP = new Aplicacion(todasLasAtracciones);
		APP.separarAtracciones();

		assertEquals(35, APP.atraccionesDeDegustacion.get(0).getValor(), 0.01);

	}

	@Test
	public void ArmarUnItinerarioTest() {

		List<Usuario> todosLosUsuarios = new ArrayList<Usuario>();
		List<Atraccion> todasLasAtracciones = new ArrayList<Atraccion>();
		LeeArchivos lector = new LeeArchivos();
		lector.leerUsuarios("Usuarios.txt", todosLosUsuarios);

		lector.LeerAtracciones("Atracciones.txt", todasLasAtracciones);

		// todasLasAtracciones.get(0).setTipo("D");

		Aplicacion APP = new Aplicacion(todasLasAtracciones);
		APP.separarAtracciones();

		APP.ofrecerAtracciones(todosLosUsuarios.get(0));
		
		//Solo va a tener el itinerario la atraccion 6 porque luego se queda sin monedas (36-35)

		List<Atraccion> itinerarioTest = new ArrayList<Atraccion>();
		itinerarioTest.add(todasLasAtracciones.get(6));
		assertEquals(itinerarioTest, todosLosUsuarios.get(0).getItinerario());

	}
	
	
	@Test
	public void ArmarOtroItinerarioTest() {

		List<Usuario> todosLosUsuarios = new ArrayList<Usuario>();
		List<Atraccion> todasLasAtracciones = new ArrayList<Atraccion>();
		LeeArchivos lector = new LeeArchivos();
		lector.leerUsuarios("Usuarios.txt", todosLosUsuarios);

		lector.LeerAtracciones("Atracciones.txt", todasLasAtracciones);

		// todasLasAtracciones.get(0).setTipo("D");

		Aplicacion APP = new Aplicacion(todasLasAtracciones);
		APP.separarAtracciones();

		APP.ofrecerAtracciones(todosLosUsuarios.get(1));
		
		//El itinerario va a ofrecer solo las atracciones de la posicion 4 y 1 porque luego se queda sin monedas

		List<Atraccion> itinerarioTest = new ArrayList<Atraccion>();
		itinerarioTest.add(todasLasAtracciones.get(4));
		itinerarioTest.add(todasLasAtracciones.get(1));
		assertEquals(itinerarioTest, todosLosUsuarios.get(1).getItinerario());

	}

}
