package ejercicio_1;

public class Pila<ELEMENT> {
	private ELEMENT[] arrayPalabras;
	private final int longitud;
	private int cima;
	
	public Pila() {
		this.longitud = 5;
		this.arrayPalabras = (ELEMENT []) new Object[this.longitud];
		this.cima = 0;
	}
	
	public void push(ELEMENT palabra) {
		if (isFull()) {
			throw new RuntimeException("La pila esta llena");
		}
		this.arrayPalabras[this.cima] = palabra;
		++this.cima;
	}
	
	public ELEMENT pop() {
		if (isEmpty()) {
			throw new RuntimeException("La pila esta vacia");
		}
		return this.arrayPalabras[--this.cima];
	}
	
	public ELEMENT peek() {
		if (isEmpty()) {
			throw new RuntimeException("La pila esta vacia");
		}
		return this.arrayPalabras[this.cima-1];
	}
	
	public boolean isEmpty() {
		return this.cima <= 0;
	}
	
	public boolean isFull() {
		return this.cima >= this.longitud;
	}
	
	public void mostrarPila() {
		if (isEmpty()) {
			throw new RuntimeException("La pila esta vacia");
		} else {
			for (int i = cima-1; i >= 0; i--) {
				System.out.println(this.arrayPalabras[i]);
			}
		}
	}
}
