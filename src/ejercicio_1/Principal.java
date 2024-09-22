package ejercicio_1;

import java.util.Random;
import java.util.Scanner;

public class Principal {
	
	public static void cargarPila(Pila<String> pilaPrincipal, String[] palabrasInformaticas, Random random) {
		for (int i = 0; i < 5; i++) {
			int palabra = random.nextInt(palabrasInformaticas.length);
			pilaPrincipal.push(palabrasInformaticas[palabra]);
		}
	}
	
	public static String[] cargarArray(Scanner input) {
		int numeroPalabras = Helper.validarEntero(input, "Ingrese el numero de palabras a eliminar de la pila: ");
		while (numeroPalabras > 5) {
			System.out.println("El numero de palabras excede al tamaño de la pila. Vuelva a intentarlo");
			numeroPalabras = Helper.validarEntero(input, "Ingrese el numero de palabras a eliminar de la pila: ");
		}
		String[] arrayAuxiliar = new String[numeroPalabras];
		for (int i = 0; i < numeroPalabras; i++) {
			arrayAuxiliar[i] = Helper.leerCadena(input, "Ingrese la palabra: ");
		}
		return arrayAuxiliar;
	}
	
	public static void eliminarPalabrasSeleccionadas(Pila<String> pilaPrincipal, Pila<String> pilaAuxiliar,Scanner input) {
		String[] arrayAuxiliar = cargarArray(input);
		String palabra;
		int contador = 0;
		for (String cadena : arrayAuxiliar) {
			while (!pilaPrincipal.isEmpty()) {
				palabra = pilaPrincipal.pop();
				if (palabra.equals(cadena)) {
					contador++;
					break;
				} else {
					pilaAuxiliar.push(palabra);
				}
			}
			while (!pilaAuxiliar.isEmpty()) {
				pilaPrincipal.push(pilaAuxiliar.pop());
			}
		}
		System.out.println("Se eliminaron " + contador + " palabras de la pila");
		
		while (!pilaAuxiliar.isEmpty()) {
			pilaPrincipal.push(pilaAuxiliar.pop());
		}
		
		System.out.println();
		System.out.println("Palabras que quedaron de la pila original");
		while (!pilaPrincipal.isEmpty()) {
			System.out.println(pilaPrincipal.pop());
		}
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		Scanner input = new Scanner(System.in);
		String[] palabrasInformaticas = {"algoritmo", "bit", "byte", "compilador", "memoria",
	            "procesador", "red", "servidor", "software", "hardware"};
		
		Pila<String> pilaPrincipal = new Pila();
		Pila<String> pilaAuxiliar = new Pila();
		
		cargarPila(pilaPrincipal, palabrasInformaticas, random);
		pilaPrincipal.mostrarPila();
		eliminarPalabrasSeleccionadas(pilaPrincipal, pilaAuxiliar,input);
	}
}
