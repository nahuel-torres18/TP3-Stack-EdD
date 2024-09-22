package ejercicio_2;

public class Pila<ELEMENT> {
	private ELEMENT[] arrayNumeros;
	private int cima;
	private final int longitud = 4;
	
	public Pila() {
		this.cima = 0;
		this.arrayNumeros = (ELEMENT []) new Object[this.longitud];
	}
	
	public void push(ELEMENT numero) {
		if (isFull()) {
			throw new RuntimeException("La pila esta llena");
		}
		this.arrayNumeros[this.cima] = numero;
		++this.cima;
	}
	
	public ELEMENT pop() {
		if (isEmpty()) {
			throw new RuntimeException("La pila esta vacia");
		}
		--this.cima;
		return this.arrayNumeros[this.cima];
	}
	
	public ELEMENT peek() {
		if (isEmpty()) {
			throw new RuntimeException("La pila esta vacia");
		}
		return this.arrayNumeros[this.cima-1];
	}
	
	public void mostrar() {
		if (isEmpty()) {
			throw new RuntimeException("La pila esta vacia");
		}
		for (int i = this.cima-1; i >= 0; i++) {
			System.out.println(this.arrayNumeros[i]);
		}
	}
	
	public boolean isEmpty() {
		return this.cima <= 0;
	}
	
	public boolean isFull() {
		return this.cima >= longitud;
	}
}
