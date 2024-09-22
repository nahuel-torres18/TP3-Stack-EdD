package ejercicio_5;

public class Pila<ELEMENT> {
	private ELEMENT[] pilaString;
	private int contador;
	private int longitud;
	
	public Pila() {
		this(5);
	}
	
	public Pila(int longitud) {
		this.longitud = longitud;
		this.pilaString = (ELEMENT []) new Object[this.longitud];
		this.contador = 0;
	}
	
	public void push(ELEMENT accion) {
		if (isFull()) {
			throw new RuntimeException("La pila esta llena");
		}
		this.pilaString[this.contador] = accion;
		++this.contador;
	}
	
	public ELEMENT pop() {
		if (isEmpty()) {
			throw new RuntimeException("La pila esta vacia");
		}
		--this.contador;
		return this.pilaString[this.contador];
	}
	
	public ELEMENT peek() {
		if (isEmpty() ) {
			throw new RuntimeException("La pila esta vacia");
		}
		return this.pilaString[this.contador-1];
	}
	
	public int contador() {
		return this.contador;
	}
	
	public int tamaño() {
		return this.longitud;
	}
	
	public boolean isEmpty() {
		return this.contador <= 0;
	}
	
	public boolean isFull() {
		return this.contador >= this.longitud;
	}
	
	public void mostrar() {
		for (int i = this.contador-1; i >= 0; i--) {
			System.out.println(this.pilaString[i]);
		}
	}
}
