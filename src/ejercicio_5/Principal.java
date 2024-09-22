package ejercicio_5;

import java.util.Random;
import java.util.Scanner;
import ejercicio_1.Helper;

public class Principal {
	
	public static void menu(Scanner input, Pila<String> pilaDeshacer, Pila<String> pilaRehacer, String[] acciones) {
		Random random = new Random();
		boolean verdad = true;
		while (verdad) {
			System.out.println("**** MENU DE OPCIONES ****");
			System.out.println("1) Acciones a realizar");
			System.out.println("2) Deshacer");
			System.out.println("3) Deshacer aleatoriamente");
			System.out.println("4) Rehacer");
			System.out.println("5) Mostrar los elemento de la pila");
			System.out.println("6) Salir");
			int opcion = Helper.validarEntero(input, "Seleccione una opcion: ");
			switch (opcion) {
				case 1:
					escribirPila(pilaDeshacer, input, acciones);
					break;
				case 2:
					deshacer(pilaDeshacer, pilaRehacer);
					break;
				case 3:
					int numeroAleatorio = random.nextInt(100)+1;
					while (numeroAleatorio > pilaDeshacer.contador()) {
						numeroAleatorio = random.nextInt(100);
					}
					deshacerPilaAleatorio(pilaDeshacer, pilaRehacer, numeroAleatorio);
					break;
				case 4:
					rehacerPilaAPeticion(pilaDeshacer, pilaRehacer, input);
					break;
				case 5:
					pilaDeshacer.mostrar();
					break;
				case 6:
					System.out.println("Fin del programa");
					verdad = false;
					break;
				default:
					System.out.println("Opcion fuera de rango");
					break;
			}
		}
		
	}
	
	public static void escribirPila(Pila pilaDeshacer, Scanner input, String[] acciones) {
		Random random = new Random();
		int posicion = random.nextInt(acciones.length);
		if (!pilaDeshacer.isFull()) {
			pilaDeshacer.push(acciones[posicion]);
		} else {
			System.out.println("Pila llena");
		}
	}
	
	public static void deshacer(Pila pilaDeshacer, Pila pilaRehacer) {
		if (!pilaDeshacer.isEmpty()) {
			pilaRehacer.push(pilaDeshacer.pop());
		} else {
			System.out.println("La pila deshacer esta vacia");
		}
	}
	
	public static void deshacerPilaAleatorio(Pila pilaDeshacer, Pila pilaRehacer,int numeroAleatorio) {
		for (int i = 0; i < numeroAleatorio; i++) {
			pilaRehacer.push(pilaDeshacer.pop());
		}
	}
	
	public static void rehacerPilaAPeticion(Pila<String> pilaDeshacer, Pila<String> pilaRehacer, Scanner input) {
		int contador = 0;
		int numero = Helper.validarEntero(input, "Ingresar la cantidad de acciones a rehacer: ");
		while (numero > pilaRehacer.contador()) {
			System.out.println("EL NUMERO EXCEDE EL RANGO DE LA PILA. VUELVA A INTENTARLO");
			numero = Helper.validarEntero(input, "Ingresar la cantidad de acciones a rehacer: ");
		}
		for (int i = 0; i < numero; i++) {
			pilaDeshacer.push(pilaRehacer.pop());
			contador++;
		}
		System.out.println("Se rehicieron " + contador + " acciones");
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int longitud = Helper.validarEntero(input, "Ingrese el tamaño de la pila: ");
		String[] acciones = {"negrita", "cursiva", "insertar tabla", "subrayado", "insertar imagen", "escribir texto", "borrar texto"};
		Pila<String> pilaDeshacer = new Pila(longitud);
		Pila<String> pilaRehacer = new Pila(longitud);
		
		menu(input,pilaDeshacer,pilaRehacer,acciones);
	}
}
