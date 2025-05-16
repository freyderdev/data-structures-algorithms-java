package com.foo.linkedlist.f_swap_nodes_in_pairs;

import com.foo.linkedlist.a_linkedlist.Node;

/*
 * Escribe un algoritmo que intercambie parejas de nodos adyacentes sin
 * modificar el valor interno de los nodos.
 *
 * Ejemplo:
 *  Input: 1->2->4->6->8
 *  Output: 2->1->6->4->8
 * 
 * Tmp= 4->6->8
 */
public class SwapNodesInPairs {

  public Node swapNodesInPairs(Node head) {
    // 1. si el nodo que recivimos en Null o si el siguiente es Null devolvemos el
    // que recibimos
    if (head == null || head.next == null)
      return head;// sirve para el caso del Nodo 8
    // En caso contrario realizamos el procesamiento con la variable temporal tmp
    // Creamos una variable temporal que va hacer el siguiente del siguiente
    // head.next, head.next

    // Paso 1: definir los dos nodos de la pareja actual
    Node first = head; // Ej: 1
    Node second = head.next; // Ej: 2
    // Paso 2: guardar el resto de la lista antes de romper enlaces
    Node remaining = second.next; // acá el puntero se para en 4 y guarda: 4->6->8
    // El siguiente paso es establecer como el siguiente del Nodo 2 es decir el Nodo
    // 1: 2->1:

    // Paso 3: llamada recursiva al resto de la lista
    first.next = swapNodesInPairs(remaining);
    // Paso 4: enlazar el segundo con el primero
    second.next = first;
    // Paso 5: retornar el nuevo head de esta pareja, que ahora es 'second'
    return second;// nodo 2

  }

  public Node swapNodesInPairsIterative(Node head) {

    Node dummy = new Node(-1);
    dummy.next = head;
    Node prev = dummy; // puntero que apunta a Dummy para conectar con el nodo anterior despues de swap

    while (prev.next != null && prev.next.next != null) {
      // ejecutar el swap(intercambio)
      //                                                             ↓
      Node first = prev.next; // puntero auxiliar first apunta a 1 : 1->2->4->6->8       ↓
      Node second = first.next; // puntero auxiliar second apunta a 2:                1->2->4->6->8
      // Intercambiar el par (first, second)
      first.next = second.next; // 1 → 4
      second.next = first; // 2 → 1
      prev.next = second; // dummy → 2
      //                               ↓
      prev = first; // dummy → 2 → 1 → 4 → 6 → 8 (prepararse para siguiente par)
      //                               ↑
    }
    return dummy.next;
  }

  public static void main(String[] args) {
    // Crear lista: 1 → 2 → 4 → 6 → 8
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(4);
    head.next.next.next = new Node(6);
    head.next.next.next.next = new Node(8);

    // Instanciar el algoritmo
    SwapNodesInPairs solver = new SwapNodesInPairs();
    Node result = solver.swapNodesInPairs(head);

    // Imprimir resultado
    System.out.print("Lista después de intercambiar parejas: ");
    printList(result);

    // Crear nueva lista para probar la versión iterativa: 1 → 2 → 4 → 6 → 8
    Node head2 = new Node(1);
    head2.next = new Node(2);
    head2.next.next = new Node(4);
    head2.next.next.next = new Node(6);
    head2.next.next.next.next = new Node(8);

    Node resultIterative = solver.swapNodesInPairsIterative(head2);
    System.out.print("Iterativa - Lista después de intercambiar parejas: ");
    printList(resultIterative);

    // Extra: prueba extra con número impar de nodos: 1 → 2 → 3
    Node head3 = new Node(1);
    head3.next = new Node(2);
    head3.next.next = new Node(3);

    Node resultImpar = solver.swapNodesInPairsIterative(head3);
    System.out.print("Iterativa (impar) - Resultado: ");
    printList(resultImpar);
  }

  // Método para imprimir una lista enlazada
  public static void printList(Node head) {
    while (head != null) {
      System.out.print(head.value);
      if (head.next != null)
        System.out.print(" -> ");
      head = head.next;
    }
    System.out.println();
  }

}
