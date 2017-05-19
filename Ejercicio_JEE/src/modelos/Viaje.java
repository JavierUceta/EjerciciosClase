package modelos;


public class Viaje {
	
	private int id;
	private String destino;
	private int duracion;
	private double precio;
	
	public Viaje(){
		
	}
	
	public Viaje(int id, String destino, int duracion, double precio){
		this.id=id;
		this.destino=destino;
		this.duracion=duracion;
		this.precio=precio;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
