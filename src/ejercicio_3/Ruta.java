package ejercicio_3;

public class Ruta {
	
	private String origen;
	private String destino;
	private double distanciaDeLaRuta; //Este atributo se mide en kilometros
	
	public Ruta(String origen, String destino, double distanciaDeLaRuta) {
		this.origen = origen;
		this.destino = destino;
		this.distanciaDeLaRuta = distanciaDeLaRuta;
	}

	@Override
	public String toString() {
		return "Ruta [origen=" + origen + ", destino=" + destino + ", distanciaDeLaRuta=" + distanciaDeLaRuta + "]";
	}
}
