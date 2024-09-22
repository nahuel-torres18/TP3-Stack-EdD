package ejercicio_2;

import ejercicio_1.Helper;
import java.util.Scanner;

public class Principal {
	
	public static int validarNumeroCuatroCifras(Scanner input) {
		int numero = Helper.validarEntero(input, "Ingrese un numero de cuatro cifras: ");
		while (numero < 1000 || numero > 9999) {
			System.out.println("¡ERROR! El numero debe estar entre 1000 y 9999");
			numero = Helper.validarEntero(input, "Ingrese un numero de cuatro cifras: ");
		}
		return numero;
	}
	
	public static void descomponerNumero (int numero, Pila pilaNumero) {
		while (numero > 0) {
			int digito = numero % 10;
			pilaNumero.push(digito);
			numero /= 10;
		}
	}
	
	public static void mostrarNuevoNumero(Pila<Integer> pilaNumeros) {
		int acumulador = 0;
		int numero = 1;
		while (!pilaNumeros.isEmpty()) { 
 			acumulador += pilaNumeros.pop() * numero;
 			numero *= 10;
		} 
		System.out.println(acumulador);
	}
	
	public static void mostrarNumerosPares(int numero) {
		System.out.print("Numeros pares: ");
		while (numero > 0) {
			int digito = numero % 10;
			if (digito % 2 == 0) {
				System.out.print(digito + " ");
			}
			numero /= 10;
		}
	}
	
	public static void mostrarNumerosImpares(int numero) {
		System.out.println();
		System.out.print("Numeros impares: ");
		while (numero > 0) {
			int digito = numero % 10;
			if (digito % 2 != 0) {
				System.out.print(digito + " ");
			}
			numero /= 10;
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Pila<Integer> pilaNumeros = new Pila();
		
		int numero = validarNumeroCuatroCifras(input);
		descomponerNumero(numero, pilaNumeros);
		mostrarNuevoNumero(pilaNumeros);
		mostrarNumerosPares(numero);
		mostrarNumerosImpares(numero);
	}
}
