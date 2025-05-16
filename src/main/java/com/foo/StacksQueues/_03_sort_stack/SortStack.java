package com.foo.StacksQueues._03_sort_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Ordena un Stack de forma que los elementos más pequeños queden en el tope del Stack.
 * Puedes usar un Stack adicional, pero no está permitido copiar los elementos a otra
 * estructura de datos.
 *
 * Ejemplo:
 *  Input: (tope) 5->1->4->2
 *  Output: (tope) 1->2->4->5
 */
public class SortStack {

  public Deque<Integer> sort(Deque<Integer> stack) {
    Deque<Integer> stackAux = new ArrayDeque<>(); // pila auxiliar

    while (!stack.isEmpty()) {
      int temp = stack.pop(); // sacamos un valor del stack original

      // mientras el tope del stack auxiliar sea > temp
      // devolvemos elementos al stack original
      while (!stackAux.isEmpty() && stackAux.peek() > temp) {
        stack.push(stackAux.pop());
      }
      // ahora que hay espacio, insertamos temp en el lugar correcto
      stackAux.push(temp);
    }
    // transferimos de vuelta los valores desde stackAux a stack original
    while (!stackAux.isEmpty()) {
      stack.push(stackAux.pop());
    }
    return stack;
  }



  public static void main(String[] args) {
    Deque<Integer> stack = new ArrayDeque<>();

    // Insertamos elementos: recuerda que push inserta en la cima
    stack.push(5);
    stack.push(1);
    stack.push(4);
    stack.push(2);

    System.out.println("Stack original:");
    printStack(stack); // antes de ordenar

    // Llamamos al método sort
    SortStack sorter = new SortStack();
    Deque<Integer> sortedStack = sorter.sort(stack);

    System.out.println("\nStack ordenado (menor en la cima):");
    printStack(sortedStack); // después de ordenar
  }

  // Método auxiliar para imprimir el stack sin modificarlo
  private static void printStack(Deque<Integer> stack) {
    for (Integer num : stack) {
      System.out.print(num + " ");
    }
    System.out.println();
  }
}
