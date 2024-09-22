package ejercicio_4;

public class Pila<ELEMENT> {
	
	private ELEMENT[] pilaSitioWeb;
	private int capcidad;
	private int contador;
	
	public Pila() {
		this(3);
	}
	
	public Pila(int capacidad) {
		this.pilaSitioWeb = (ELEMENT []) new Object[capacidad];
		this.capcidad = capacidad;
		this.contador = 0;
	}
	
	public void push(ELEMENT sitioWeb) {
		if (isFull()) {
			throw new RuntimeException("La pila esta vacia");
		}
		this.pilaSitioWeb[this.contador] = sitioWeb;
		++this.contador;
	}
	
	public ELEMENT pop() {
		if (isEmpty()) {
			throw new RuntimeException("La pila esta vacia");
		}
		--this.contador;
		return this.pilaSitioWeb[this.contador];
	}
	
	public ELEMENT peek() {
		if (isEmpty()) {
			throw new RuntimeException("La pila esta llena");
		}
		return this.pilaSitioWeb[this.contador - 1];
	}
	
	public boolean isEmpty() {
		return this.contador <= 0;
	}
	
	public boolean isFull() {
		return this.contador >= this.capcidad;
	}
	
	public int contador() {
		return this.contador-1;
	}
}
