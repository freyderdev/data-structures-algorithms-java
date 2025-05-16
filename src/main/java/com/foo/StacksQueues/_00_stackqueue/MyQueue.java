package com.foo.StacksQueues._00_stackqueue;

/*
Queue(Cola) es una estructura tipo
FIFO (Firs IN Firs Out)= (El primero en entrar, es el primero en salir)
La unica informacion que necesitamos almacenar es el TOPE de la pila
 */
public class MyQueue {
  private Node first;
  private Node last;

  public void add(int value) {
    Node newLast = new Node(value);
    if (last != null) {
      last.next = newLast;
    }

    last = newLast;

    if (first == null) {
      first = last;
    }
  }

  public int remove() {
    if (first == null) {
      throw new MyEmptyQueueException();
    }

    int firstValue = first.value;
    first = first.next;

    if (first == null) {
      last = null;
    }

    return firstValue;
  }

  public int peek() {
    if (first == null) {
      throw new MyEmptyQueueException();
    }

    return first.value;
  }

  public boolean isEmpty() {
    return first == null;
  }
}
