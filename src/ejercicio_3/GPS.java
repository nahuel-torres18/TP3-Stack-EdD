package ejercicio_3;

public class GPS<ELEMENT> {
	
	//Zona de atributos
	private ELEMENT[] pilaRutas;
	private ELEMENT[] pilaDeschacer;
	private final int longitud = 3;
	private int contador;
	private int contador2;
	
	//Constructor de la clase
	public GPS() {
		this.pilaRutas = (ELEMENT []) new Object[this.longitud];
		this.pilaDeschacer = (ELEMENT []) new Object[this.longitud];
		this.contador = 0;
		this.contador2 = 0;
	}
	
	public GPS(int longitud) {
		this.pilaRutas = (ELEMENT []) new Object[longitud];
		this.pilaDeschacer = (ELEMENT []) new Object[longitud];
		this.contador = 0;
		this.contador2 = 0;
	}
	
	//Metodos de la clase
	public void agregarRuta(ELEMENT ruta) {
		if (isFull()) {
			throw new RuntimeException("La pila esta llena");
		}
		this.pilaRutas[this.contador] = ruta;
		++this.contador;
	}
	
	public void deshacerRuta() {
		--this.contador;
		ELEMENT ruta = this.pilaRutas[this.contador];
		if (isFull()) {
			throw new RuntimeException("La pila esta llena");
		}
		this.pilaDeschacer[this.contador2] = ruta;
		++this.contador2;
	}
	
	public void rehacerRuta() {
		try {
			--this.contador2;
			ELEMENT ruta = this.pilaDeschacer[this.contador2];
			++this.contador;
			this.pilaRutas[this.contador] = ruta;
			System.out.println("Se volvio a agregar a la pilaRutas "+ruta);
		} catch (Exception e) {
			System.out.println("Pila deshacer esta vacia");
		}
	}
	
	public void verRutaActual() {
		System.out.println(this.pilaRutas[this.contador-1]);
	}
	
	/*public void verHistorialCompleto() {
		if (!isEmpty()) {
			for (Ruta ruta : pilaRutas) {
				System.out.println(ruta);
			}
		} else {
			System.out.println("La pila esta vacia");
		}
	}*/
	
	public void verHistorialCompleto() {
		for (int i = contador-1; i >= 0; i--) {
			System.out.println(this.pilaRutas[i]);
		}
	}
	
	public boolean isEmpty() {
		return this.contador <= 0;
	}
	
	public boolean isFull() {
		return this.contador >= this.longitud;
	}
}
