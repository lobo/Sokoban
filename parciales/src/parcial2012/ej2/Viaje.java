package parcial2012.ej2;

public class Viaje {
	private double precio;
	private String estacion;
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void setEstacion(String estacion) {
		this.estacion = estacion;
	}
	
	public Viaje(double precio, String estacion){
		this.precio = precio;
		this.estacion = estacion;
	}
	
	public Viaje(String recarga) {
		this.estacion = recarga;
	}
	
	public String toString(){
		return "Viaje desde estacion " + estacion + " (" + precio + ")";
	}
	
}
