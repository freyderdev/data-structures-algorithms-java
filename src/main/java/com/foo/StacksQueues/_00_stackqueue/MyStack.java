package com.foo.StacksQueues._00_stackqueue;

/*
Stack(Pila) es una estructura tipo
LIFO (Last IN First Out)=Ultimo entrar primero en salir
La unica informacion que necesitamos almacenar es el TOPE de la pila
 */
public class MyStack {
  private Node top; //La unica informacion que necesitamos almacenar es el TOPE de la pila

  //Añadir un nuevo elemento al Stack
  public void push(int value) {
    Node newTop = new Node(value);
    newTop.next = top;//El siguiente Nodo del nuevo tope debe ser el tope actual
    top = newTop;
  }
  //sacar Elimina un elemento de la pila, es decir el nodo tope
  public int pop() {
    if (top == null) {
      throw new MyEmptyStackException();
    }

    int topValue = top.value;
    //actualizamos el tope ya que ese nodo se va a eliminar
    top = top.next;//Entonces el nuevo tope va ser el siguiente del nodo actual
    return topValue;//retornamos el valor del tope previo es decir el que se saco
  }
  //Retorna el elemento de la cima de la pila SIN eliminar el valor
  public int peek() {
    if (top == null) {
      throw new MyEmptyStackException();
    }

    return top.value; //retornamos el valor del tope
  }
  //retorna True si la pila esta vacia
  public boolean isEmpty() {
    return top == null;
  }
}
