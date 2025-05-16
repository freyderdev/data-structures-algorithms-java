package com.foo.StacksQueues._04_stack_min;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

/*
 * ¿Cómo diseñarías un Stack que además de las operaciones de push y pop también
 * contase con una operación para obtener el mínimo?
 */
public class StackMin {

  // se definen 2 pilas
  private Deque<Integer> mainStack; // mainStack: guarda todos los elementos
  private Deque<Integer> minStack; // guarda el mínimo correspondiente en cada momento

  public StackMin() {
    mainStack = new ArrayDeque<>();
    minStack = new ArrayDeque<>();
  }

  /*
   * 🎯 ¿Qué debe hacer este método?
   * Insertar data en mainStack
   * Verificar si también debe insertarse en minStack
   */
  public void push(Integer data) {
    // Siempre insertamos en mainStack
    mainStack.push(data);
    // Solo insertamos en minStack si está vacío o si data es <= mínimo actual
    if (minStack.isEmpty() || data <= minStack.peek()) {
      minStack.push(data);
    }
  }

  /*
   * 🎯 ¿Qué debe hacer este método?
   * 1- Sacar el tope de mainStack (como cualquier pop())
   * 2- Ver si ese valor también estaba en la cima de minStack
   * Si es así, también sacarlo de minStack
   * Esto asegura que siempre tengas en minStack.peek() el mínimo actual, después
   * de cada pop
   */
  public int pop() {
    if (mainStack.isEmpty()) {
      throw new NoSuchElementException("Stack is empty");
    }
    Integer removed = mainStack.pop();

    if (removed == minStack.peek()) {
      minStack.pop();
    }
    return removed;

  }
  /*
   * 🎯 ¿Qué debe hacer?
   * Retornar el valor mínimo actual
   * Y debe hacerlo en tiempo constante O(1)
   * Esto es posible porque ya lo tenemos guardado en la cima de minStack.
   */
  public int min() {
    if (minStack.isEmpty()) {
      throw new NoSuchElementException("Stack is empty");
    }
    return minStack.peek();
  }

  public static void main(String[] args) {
    StackMin stack = new StackMin();

    stack.push(5);
    System.out.println("min(): " + stack.min()); // ➡️ 5

    stack.push(3);
    System.out.println("min(): " + stack.min()); // ➡️ 3

    stack.push(7);
    System.out.println("min(): " + stack.min()); // ➡️ 3

    stack.push(3);
    System.out.println("min(): " + stack.min()); // ➡️ 3

    System.out.println("pop(): " + stack.pop()); // ➡️ 3
    System.out.println("min(): " + stack.min()); // ➡️ 3

    System.out.println("pop(): " + stack.pop()); // ➡️ 7
    System.out.println("min(): " + stack.min()); // ➡️ 3

    System.out.println("pop(): " + stack.pop()); // ➡️ 3
    System.out.println("min(): " + stack.min()); // ➡️ 5
}

}
