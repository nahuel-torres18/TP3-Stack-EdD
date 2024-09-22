package ejercicio_3;

import ejercicio_1.Helper;
import java.util.Scanner;

public class Principal {
	
	public static void menu() {
		System.out.println("**** MENU DE OPCIONES ****");
		System.out.println("1) Agregar nuevas rutas");
		System.out.println("2) Deshacer ultima ruta agregada");
		System.out.println("3) Rehacer una ruta deshecha");
		System.out.println("4) Visualizar la ruta actual");
		System.out.println("5) Ver historial completo de las rutas");
		System.out.println("6) Salir");
	}
	
	public static void procesarInformacion(Scanner input, GPS gps, int opcion) {
		switch(opcion) {
			case 1:
				gps = cargarRutas(gps, input);
				break;
			case 2:
				gps.deshacerRuta();
				break;
			case 3:
				gps.rehacerRuta();
				break;
			case 4:
				gps.verRutaActual();
				break;
			case 5:
				gps.verHistorialCompleto();
				break;
			case 6:
				System.out.println("Fin del programa");
				break;
			default:
				System.out.println("Opcion invalida");
				break;
		}
	}
	
	public static GPS cargarRutas(GPS<Ruta> gps, Scanner input) {
		char respuesta = 's';
		while (respuesta == 's') {
			gps.agregarRuta(new Ruta(Helper.leerCadena(input, "Ciudad de origen: "),Helper.leerCadena(input, "Ciudad de destino: "),
							Helper.validarDouble(input, "Ingrese la distancia (en km): ")));
			respuesta = Helper.leerCadena(input, "Desea continuar ingresando? (s/n): ").charAt(0);
		}
		return gps;
	}
	
	public static void main(String[] args) {
		GPS<Ruta> gps = new GPS();
		Scanner input = new Scanner(System.in);
		int opcion;
		do {
			menu();
			opcion = Helper.validarEntero(input, "Seleccione una opcion: ");
			procesarInformacion(input, gps, opcion);
		} while(opcion != 6);
	}
}
