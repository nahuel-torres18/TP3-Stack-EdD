package ejercicio_0;

import java.util.Stack;

public class Principal {
	
	public static void main(String[] args) {
		/*Stack miPila = new Stack();
		
		miPila.Push('a');
		miPila.Push('b');
		miPila.Push('c');
		
		System.out.println(miPila.Peek());
		
		while (!miPila.isEmpty()) {
			System.out.print(miPila.Pop()+" ");
		}*/
		Stack<Integer> miPila = new Stack();
		miPila.push(20);
		miPila.push(30);
		miPila.push(40);
		for (int i : miPila) {
			System.out.println(miPila.peek());
		}
	}
}
