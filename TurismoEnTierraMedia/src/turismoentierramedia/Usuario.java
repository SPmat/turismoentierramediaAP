package turismoentierramedia;

import java.util.ArrayList;

import java.util.List;

public class Usuario {

	List<Atraccion> itinerario = new ArrayList<Atraccion>();

	// int indice = 0;
	
	
	
	// Monedas y tiempo libre iniciales?? o hacer un acumulado
	double monedas=0;
	double tiempoLibre=0;
	String atraccionFavorita=" ";
	String nombre=" ";
	
	
	public Usuario(String nombre, double monedas, double tiempoLibre, String atraccionFavorita) {
		super();
		this.monedas = monedas;
		this.tiempoLibre = tiempoLibre;
		this.atraccionFavorita = atraccionFavorita;
		this.nombre=nombre;
	}


	public double getMonedas() {
		return monedas;
	}

	public List<Atraccion> getItinerario() {
		return itinerario;
	}

	public double getTiempoLibre() {
		return tiempoLibre;
	}

	public String getNombre() {
		return nombre;
	}


	public String getAtraccionFavorita() {
		return atraccionFavorita;
	}
	
	public void agregarAtraccion(Atraccion unaAtraccion) {
		this.itinerario.add(unaAtraccion);
		this.monedas-=unaAtraccion.valor;
		this.tiempoLibre-=unaAtraccion.tiempoDeUso;
	}
	
	/*
	
	public void agregarAtraccion(Promocion promo) {
		this.itinerario.add(unaAtraccion);
		this.monedas-=unaAtraccion.valor;
		this.tiempoLibre-=unaAtraccion.tiempoDeUso;
	}
	
	*/


	//Responde verdadero si tiene las monedas y el tiempo suficiente ----> Verdadero, tengo dinero y tiempo para ir a...
	public boolean podriasIrA(Atraccion unaAtraccion) {
		
		if(this.monedas>=unaAtraccion.getValor() && this.tiempoLibre>=unaAtraccion.getTiempoDeUso()) {
			return true;
		}
		return false;
	}
	
	
	//Si todavia no tiene en el itinerario la atraccion que le pasan como parametro, da true --> Verdad, todavia no voy a .....
	public boolean todaviaNoVasA(Atraccion unaAtraccion) {
		
		for(Atraccion misAtracciones: itinerario) {
			if(misAtracciones.getNombre().equals(unaAtraccion.getNombre())) {
				return false;
			}
		
		}
		return true;
	}

}
