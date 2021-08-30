package turismoentierramedia;

public class Atraccion {

	
	
	double valor=1;
	double tiempoDeUso=1;
	double usosDisponibles=1;
	String tipo = " ";
	String nombre= " ";
	
	public Atraccion(double valor, double tiempoDeUso, double usosMaximos, String tipo, String nombre) {
		
		this.valor=valor;
		this.tiempoDeUso=tiempoDeUso;
		this.usosDisponibles=usosMaximos;
		this.tipo=tipo;
		this.nombre=nombre;
		
		
	}


	public Atraccion() {
		// TODO Auto-generated constructor stub
	}


	public double getValor() {
		return this.valor;
	}

	public String getTipo() {
		return this.tipo;
	}
	
	public void setTipo(String tipo) {
		
		this.tipo=tipo;
		
	}

	public String getNombre() {
		return this.nombre;
	}

	public double getTiempoDeUso() {
		return this.tiempoDeUso;
	}

	public double getUsosDisponibles() {
		return this.usosDisponibles;

	}
	
	
	//Reescribe el toString de la superclase para poder usarlo en println
    @Override
    public String toString() {
        return nombre;
}


	public void reservarLugar(Usuario unUsuario) {
		this.usosDisponibles-=1;
		unUsuario.agregarAtraccion(this);
	}
    
}
