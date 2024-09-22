package ejercicio_0;

public class Stack {
	private final int capacidad = 100;
	private char[] arrayCaracteres;
	private int cuenta;
	
	public Stack() {
		this.arrayCaracteres = new char[capacidad];
		this.cuenta = 0;
	}
	
	public void Push(char caracter) {
		if (this.cuenta >= capacidad) {
			throw new RuntimeException("La pila esta llena");
		}
		this.arrayCaracteres[this.cuenta] = caracter;
		++this.cuenta;
	}
	
	public char Pop() {
		if (isEmpty()) {
			throw new RuntimeException("La pila esta vacia");
		}
		--this.cuenta;
		return this.arrayCaracteres[this.cuenta];
	}
	
	public char Peek() {
		if (isEmpty()) {
			throw new RuntimeException("La pila esta vacia");
		}
		return this.arrayCaracteres[this.cuenta-1];
	}
	
	public boolean isEmpty() {
		return this.cuenta <= 0;
	}
}
