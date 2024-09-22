package ejercicio_6;

public class Pila<ELEMENT> {
	private ELEMENT[] pilaArray;
	private int contador;
	private int tamaño;
	
	public Pila() {
		this(5);
	}
	
	public Pila(int tamaño) {
		this.tamaño = tamaño;
		this.pilaArray = (ELEMENT []) new Object[this.tamaño];
		this.contador = 0;
	}
	
	public void push(ELEMENT cadena) {
		if (isFull()) {
			throw new RuntimeException("La pila esta llena");
		}
		this.pilaArray[this.contador] = cadena;
		++this.contador;
	}
	
	public ELEMENT pop() {
		if (isEmpty()) {
			throw new RuntimeException("La pila esta vacia");
		}
		--this.contador;
		return this.pilaArray[this.contador];
	}
	
	public ELEMENT peek() {
		if (isEmpty()) {
			throw new RuntimeException("La pila esta vacia");
		}
		return this.pilaArray[this.contador - 1];
	}
	
	public int longitud() {
		return this.contador;
	}
	
	public boolean isEmpty() {
		return this.contador <= 0;
	}
	
	public boolean isFull() {
		return this.contador >= this.tamaño;
	}
	
	public void mostrar() {
		for (int i = this.contador-1; i >= 0; i--) {
			System.out.println(this.pilaArray[i]);
		}
	}
}
