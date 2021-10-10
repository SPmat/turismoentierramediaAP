package turismoentierramedia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class LeeArchivos {




	// Metodo que llamo en caso de que llegue una lista de Usuarios
	public void leerUsuarios(String nombre, List<Usuario> todosLosUsuarios) {
		
		
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File(nombre);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null) {

				String[] valores = linea.split(",");

				Usuario aux = new Usuario (valores[0], Double.parseDouble(valores[1]), Double.parseDouble(valores[2]), valores[3]);

				todosLosUsuarios.add(aux);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	// Metodo que llamo en caso de que llegue una lista de Atracciones
	public void LeerAtracciones(String nombre, List<Atraccion> todasLasAtracciones) {
		
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File(nombre);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null) {

				String[] valores = linea.split(",");

				Atraccion aux = new Atraccion(Double.parseDouble(valores[0]), Double.parseDouble(valores[1]),
						Double.parseDouble(valores[2]), valores[3], valores[4]);

				todasLasAtracciones.add(aux);

			}

		} catch (Exception e) {
			//e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	
	
	
	
	
	
	
}
