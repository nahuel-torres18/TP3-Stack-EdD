package ejercicio_6;

import java.util.Scanner;
import ejercicio_1.Helper;

public class Metodos {
	/*///////////////////// PARTE 1 //////////////////////////////////////////////////////*/
	public static int opcionCategoria(Scanner input) {
		System.out.println("1. Peliculas");
		System.out.println("2. Series");
		System.out.println("3. Documentales");
		int opcion = Helper.validarEntero(input, "Selecciones una opcion: ");
		return opcion;
	}
	
	public static void opcionPeliculas(Scanner input, Pila<String> pilaCategorias) {
		System.out.println("1. Accion");
		System.out.println("2. Comedia");
		System.out.println("3. Drama");
		System.out.println("4. Ciencia Ficcion");
		System.out.println("5. Terror");
		int opcion = Helper.validarEntero(input, "Seleccione una opcion: ");
		if (!pilaCategorias.isFull()) {
			switch (opcion) {
			case 1: 
				pilaCategorias.push("Accion");
				break;
			case 2:
				pilaCategorias.push("Comedia");
				break;
			case 3:
				pilaCategorias.push("Drama");
				break;
			case 4:
				pilaCategorias.push("Ciencia Ficcion");
				break;
			case 5:
				pilaCategorias.push("Terror");
				break;
			default:
				System.out.println("Opcion fuera de rango");
				break;
			}
		} else {
			System.out.println("La pila esta llena");
		}
	}
	
	public static void opcionSeries(Scanner input, Pila<String> pilaCategorias) {
		System.out.println("1. Drama");
		System.out.println("2. Comedia");
		System.out.println("3. Documental");
		System.out.println("4. Ciencia Ficcion");
		System.out.println("5. Thriller");
		int opcion = Helper.validarEntero(input, "Seleccione una opcion: ");
		if (!pilaCategorias.isFull()) {
			switch (opcion) {
			case 1: 
				pilaCategorias.push("Drama");
				break;
			case 2:
				pilaCategorias.push("Comedia");
				break;
			case 3:
				pilaCategorias.push("Documental");
				break;
			case 4:
				pilaCategorias.push("Ciencia Ficcion");
				break;
			case 5:
				pilaCategorias.push("Thriller");
				break;
			default:
				System.out.println("Opcion fuera de rango");
				break;
			}
		} else {
			System.out.println("La pila esta llena");
		}
	}
	
	public static void opcionDocumentales(Scanner input, Pila<String> pilaCategorias) {
		System.out.println("1. Naturaleza");
		System.out.println("2. Historia");
		System.out.println("3. Ciencia");
		System.out.println("4. Biografia");
		int opcion = Helper.validarEntero(input, "Seleccione una opcion: ");
		if (!pilaCategorias.isFull()) {
			switch (opcion) {
			case 1: 
				pilaCategorias.push("Naturaleza");
				break;
			case 2:
				pilaCategorias.push("Historia");
				break;
			case 3:
				pilaCategorias.push("Ciencia");
				break;
			case 4:
				pilaCategorias.push("Biografia");
				break;
			default:
				System.out.println("Opcion fuera de rango");
				break;
			}
		} else {
			System.out.println("La pila esta llena");
		}
	}
	
	public static void irACategoria(Pila<String> pilaCategoria) {
		Scanner input = new Scanner(System.in);
		int opcion;
		if (pilaCategoria.isEmpty()) {
			pilaCategoria.push("Menu principal");
			System.out.println("USTED SE ENCUENTRA EN EL MENU PRINCIPAL");
		} else if (!pilaCategoria.isFull()) {
			opcion = opcionCategoria(input);
			if (opcion == 1) {
				pilaCategoria.push("Pelicula");
				opcionPeliculas(input, pilaCategoria);
			} else if (opcion == 2) {
				pilaCategoria.push("Series");
				opcionSeries(input, pilaCategoria);
			} else if (opcion == 3) {
				pilaCategoria.push("Documentales");
				opcionDocumentales(input, pilaCategoria);
			}
		} else {
			System.out.println("La pila esta llena");
		}
	}

/*///////////////////// OPCION 2 //////////////////////////////////*/
	
	public static void volver(Pila<String> pilaCategoria) {
		if (pilaCategoria.isEmpty()) {
			System.out.println("NO PUEDE REALIZAR ESTA ACCION PORQUE LA PILA ESTA VACIA");
		} else {
			String elemento = pilaCategoria.peek();
			if (elemento.equals("Menu principal")) {
				System.out.println("Usted a regresado al menu principal");
			} else {
				pilaCategoria.pop();
			}
		}
	}

/*///////////////////// OPICION 3 /////////////////////////////////////////*/

	public static void verCategoriaActual(Pila<String> pilaCategoria) {
		if (pilaCategoria.isEmpty()) {
			System.out.println("NO PUEDE REALIZAR ESTA ACCION PORQUE LA PILA ESTA VACIA");
		} else {
			if (pilaCategoria.peek().equals("Menu principal") || pilaCategoria.peek().equals("Pelicula") || pilaCategoria.peek().equals("Series") || pilaCategoria.peek().equals("Documentales")) {
				System.out.println("Usted se encuentra actualmente en la categoria " + pilaCategoria.peek());
			} else {
				System.out.println("Usted se encuentra actualmente en la subcategoria " +  pilaCategoria.peek());
			}
		}
	}
	
/*///////////////////// OPCION 4 ///////////////////////////////////////////////*/
	
	public static void verTotalNavegado(Pila<String> pilaCategoria) {
		System.out.println("Cantidad de elementos en la pila historial " + pilaCategoria.longitud());
	}
	
	/*///////////////////// OPCION 5 /////////////////////////////////////////////*/
	
	public static void buscar(Pila<String> pilaCategoria, Pila<String> pilaAuxiliar, String elemento) {
		boolean verdad = false;
		String auxiliar;
		if (pilaCategoria.isEmpty()) {
			System.out.println("NO PUEDE REALIZAR ESTA ACCION PORQUE LA PILA ESTA VACIA");
		} else {
			while (!pilaCategoria.isEmpty() && pilaCategoria.longitud() != 0) {
				auxiliar = pilaCategoria.pop();
				if (auxiliar.equals(elemento)) {
					verdad = true;
					System.out.println(auxiliar+" si se encuentra en la pila");
					pilaAuxiliar.push(auxiliar);
					break;
				} else {
					pilaAuxiliar.push(auxiliar);
				}
			}
			if (!verdad) {
				while (!pilaAuxiliar.isEmpty()) {
					pilaCategoria.push(pilaAuxiliar.pop());
				}
			} else {
				while (!pilaAuxiliar.isEmpty()) {
					pilaCategoria.push(pilaAuxiliar.pop());
				}
			}
		}
	}
	
	public static void consultaCategoria(Pila<String> pilaCategoria, Pila<String> pilaAuxiliar,Scanner input) {
		if (pilaCategoria.isEmpty()) {
			System.out.println("NO PUEDE REALIZAR ESTA ACCION PORQUE LA PILA ESTA VACIA");
		} else {
			int opcion = opcionCategoria(input);
			if (opcion == 1) {
				String categoria = Helper.leerCadena(input, "Ingrese el nombre de la categoria: ");
				buscar(pilaCategoria, pilaAuxiliar, categoria);
			} else if (opcion == 2) {
				String subCategoria = Helper.leerCadena(input, "Ingrese el nombre de la subcategoria: ");
				buscar(pilaCategoria, pilaAuxiliar, subCategoria);
			}
		}
	}
	
	/*///////////////////////////////// OPCION 6 /////////////////////////////////////////////////*/
	
	public static void borraHistorial(Pila<String> pilaCategoria) {
		while (!pilaCategoria.isEmpty()) {
			if (pilaCategoria.peek().equals("Menu principal")) {
				System.out.println("El historial ha sido vaciado. Actualmente usted se encuentra en: "+pilaCategoria.peek());
				break;
			} else {
				pilaCategoria.pop();
			}
		}
	}
}
