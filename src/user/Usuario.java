package user;

public class Usuario {

	private String Nombre;
	private int Nip;
	private int NumTarjeta;
	private int Fondos;
	
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getNip() {
		return Nip;
	}
	public void setNip(int nip) {
		Nip = nip;
	}
	public int getNumTarjeta() {
		return NumTarjeta;
	}
	public void setNumTarjeta(int numTarjeta) {
		NumTarjeta = numTarjeta;
	}
	public int getFondos() {
		return Fondos;
	}
	public void setFondos(int fondos) {
		Fondos = fondos;
	}
	
	public String toString () {
	return "Datos de la Tarjeta:" +NumTarjeta+ "\n  Nombre: \n" 
	+ Nombre + " Nip: " +Nip+  " Fondos: $" +Fondos; 
	}
	
}
