package ejercicio_4;

public class SitioWeb {

	private String nombre;
	private String tipo;
	private String url;
	
	public SitioWeb(String nombre, String tipo, String url) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.url = url;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "SitioWeb [nombre=" + nombre + ", tipo=" + tipo + ", url=" + url + "]";
	}
}
