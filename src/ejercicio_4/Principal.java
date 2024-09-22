package ejercicio_4;

import java.util.Scanner;
import ejercicio_1.Helper;

public class Principal {
	
	public static void almacenarSitioWeb(Pila<SitioWeb> sitioWeb, Scanner input) {
		while (!sitioWeb.isFull()) {
			sitioWeb.push(new SitioWeb(Helper.leerCadena(input, "Nombre del sitio web: "), 
						  Helper.leerCadena(input, "Tipo de sitio web (educativo,entretenimiento, noticias o comercio electrónico): "), 
						  Helper.leerCadena(input, "Ingrese la URL del sitio web: ")));
		}
	}
	
	public static boolean menuOpciones(Scanner input) {
		System.out.println("MENU DE OPCIONES");
		System.out.println("1) Buscar sitio web por nombre");
		System.out.println("2) Buscar sitio web por URL");
		int opcion = Helper.validarEntero(input, "Seleccione una opcion: ");
		if (opcion == 1) {
			return true;
		}
		return false;
	}
	
	public static void cantidadDeSitiosVisitados(int contadorTotal, int contador1, int contador2, int contador3, int contador4) {
		System.out.println("Cantidad total de sitios web visitados: "+contadorTotal);
		System.out.println("Cantidad de sitios webs educativos: "+contador1);
		System.out.println("Cantidad de sitios webs de entretenimiento: "+contador2);
		System.out.println("Cantidad de sitios webs de noticias: "+contador3);
		System.out.println("Cantidad de sitios webs de comercio electronico: "+contador4);
	}
	
	public static void recorrerHistorial(Pila<SitioWeb> pilaSitioWeb, Pila<SitioWeb> pilaAuxiliar, Scanner input) {
		SitioWeb auxiliar;
		int contadorTotal = 0, contador1 = 0, contador2 = 0, contador3 = 0, contador4 = 0;
		if (menuOpciones(input)) {
			String nombre = Helper.leerCadena(input, "Ingrese el nombre del sitio: ");
			while (!pilaSitioWeb.isEmpty()) {
				auxiliar = pilaSitioWeb.pop();
				if (auxiliar.getNombre().equals(nombre)) {
					contadorTotal++;
				} else {
					pilaAuxiliar.push(auxiliar);
				}
				if (auxiliar.getTipo().equals("educativo")) {
					contador1++;
				} else if (auxiliar.getTipo().equals("entretenimiento")) {
					contador2++;
				} else if (auxiliar.getTipo().equals("noticias")) {
					contador3++;
				} else if (auxiliar.getTipo().equals("comercio electronico")) {
					contador4++;
				}
				
			}
		} else {
			String url = Helper.leerCadena(input, "Ingrese la URL del sitio a buscar: ");
			while (!pilaSitioWeb.isEmpty()) {
				auxiliar = pilaSitioWeb.pop();
				if (auxiliar.getUrl().equals(url)) {
					contadorTotal++;
				} else {
					pilaAuxiliar.push(auxiliar);
				}
				if (auxiliar.getTipo().equals("educativo")) {
					contador1++;
				} else if (auxiliar.getTipo().equals("entretenimiento")) {
					contador2++;
				} else if (auxiliar.getTipo().equals("noticias")) {
					contador3++;
				} else if (auxiliar.getTipo().equals("comercio electronico")) {
					contador4++;
				}
			}
		}
		while (!pilaAuxiliar.isEmpty()) {
			pilaSitioWeb.push(pilaAuxiliar.pop());
		}
		cantidadDeSitiosVisitados(contadorTotal, contador1, contador2, contador3, contador4);
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Pila<SitioWeb> pilaSitioWeb = new Pila(4);
		Pila<SitioWeb> pilaAuxiliar = new Pila(4);
		
		almacenarSitioWeb(pilaSitioWeb, input);
		recorrerHistorial(pilaSitioWeb, pilaAuxiliar, input);
	}
}
