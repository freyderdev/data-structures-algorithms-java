package com.foo.StacksQueues._01_queue_with_stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * ✅ Simula una cola FIFO (First-In-First-Out) usando dos pilas (stacks) LIFO.
 * 
 * Internamente se utilizan:
 * - stackIn: para almacenar los elementos que se encolan (entrada)
 * - stackOut: para controlar la salida en orden FIFO cuando se hace dequeue
 * 
 * Esta implementación permite:
 * - enqueue(x): insertar un elemento al final de la cola
 * - dequeue(): remover y retornar el primer elemento insertado
 * - peek(): ver el primer elemento sin removerlo
 * - isEmpty(): saber si la cola está vacía
 */
public class QueueWithStacks {
  // Pila para manejar la entrada de elementos
  Deque<Integer> stackIn = new ArrayDeque<>();
  // Pila para manejar la salida (simulando el orden FIFO)
  Deque<Integer> stackOut = new ArrayDeque<>();

  /**
   * Inserta un elemento al final de la cola.
   * 
   * @param x el valor a encolar
   */
  public void enqueue(int x) {
    stackIn.push(x);
  }

  /**
   * Elimina y retorna el primer elemento que fue encolado.
   * Si stackOut está vacío, transfiere todos los elementos desde stackIn.
   * 
   * @return el valor desencolado
   * @throws NoSuchElementException si la cola está vacía
   */
  public int dequeue() {
    if (stackOut.isEmpty()) {
      while (!stackIn.isEmpty()) {
        stackOut.push(stackIn.pop());
      }
    }
    if (stackOut.isEmpty()) {
      throw new NoSuchElementException("Queue is empty");
    }
    return stackOut.pop();
  }

  /**
   * Retorna el primer elemento en la cola sin eliminarlo.
   * 
   * @return el primer valor de la cola
   * @throws NoSuchElementException si la cola está vacía
   */
  public int peek() {
    if (stackOut.isEmpty()) {
      while (!stackIn.isEmpty()) {
        stackOut.push(stackIn.pop());
      }
    }

    if (stackOut.isEmpty()) {
      throw new NoSuchElementException("Queue is empty");
    }
    return stackOut.peek();
  }

  /**
   * Verifica si la cola está vacía.
   * 
   * @return true si no hay elementos, false en caso contrario
   */
  public boolean isEmpty() {
    return stackIn.isEmpty() && stackOut.isEmpty();
  }

}
