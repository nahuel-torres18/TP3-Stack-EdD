package ejercicio_6;

import java.util.Scanner;
import ejercicio_1.Helper;

public class Principal {
	
	public static void menu(Pila<String> pilaCategoria, Pila<String> pilaAuxiliar) {
		boolean verdad = true;
		Scanner input = new Scanner(System.in);
		while (verdad) {
			System.out.println("1. Ir a [Cateogoria]");
			System.out.println("2. Volver");
			System.out.println("3. Ver actual");
			System.out.println("4. Ver total navegado");
			System.out.println("5. Buscar [Categoria]");
			System.out.println("6. Vaciar historial");
			System.out.println("7. Mostrar los elementos del historial"); //Esta opcion se agrego de manera personal
			System.out.println("8. Salir");
			int opcion = Helper.validarEntero(input, "Seleccione una opcion: ");
			switch (opcion) {
				case 1:
					Metodos.irACategoria(pilaCategoria);
					break;
				case 2:
					Metodos.volver(pilaCategoria);
					break;
				case 3:
					Metodos.verCategoriaActual(pilaCategoria);
					break;
				case 4:
					Metodos.verTotalNavegado(pilaCategoria);
					break;
				case 5:
					Metodos.consultaCategoria(pilaCategoria, pilaAuxiliar, input);
					break;
				case 6:
					Metodos.borraHistorial(pilaCategoria);
					break;
				case 7:
					pilaCategoria.mostrar();
					break;
				case 8:
					System.out.println("Ultima categoria en el historial: "+pilaCategoria.peek());
					System.out.println("Fin del programa");
					verdad = false;
					break;
				default:
					System.out.println("Opcion fuera de rango");
					break;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int longitud = Helper.validarEntero(input, "Ingrese el tamaño de la pila: ");
		Pila<String> pilaCategoria = new Pila<String>(longitud);
		Pila<String> pilaAuxiliar = new Pila<String>(longitud);
		menu(pilaCategoria, pilaAuxiliar);
	}
}
