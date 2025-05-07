package com.foo.linkedlist.b_remove_dups;

import com.foo.linkedlist.a_linkedlist.Node;

import java.util.HashSet;

/*
 * Escribe un algoritmo para eliminar los elementos duplicados en una Lista enlazada
 *
 * Ejemplo:
 *  Input: 1->2->2->3->4->1
 *  Output: 1->2->3->4
 * Follow-up: ¿Cuál sería tu solución si no pudieras utilizar memoria adicional?
 */
public class RemoveDups {

  public void removeDups(Node head) {
    if (head == null) return;;
    HashSet<Integer> foundValues = new HashSet<>();
    Node current = head;
    /*
    el siguiente paso es añadir el primer elemento de nuestra lista a nuestro HashSet<>
    Hay que recorda q para eliminar un node debemos asignar como node siguiente el siguiente del siguiente
    por lo tanto tenemos que empezar iterando sobre el nodo siguiente como veremos a continuación:
     */
    foundValues.add(current.value);
    //tenemos que iterar mientras el nodo actual y el nodo siguiente sean distinto de Null
    // Ya que vamos a estar comprobando el valor del siguiente y en caso que haya que eliminarlo lo eliminaresmo
    // asignando al siguiente del actual el siguiente del sigueinte
    while (current != null && current.next != null){
      //.add() devuelve true si se pudo añadir el valor a la lista, false si no se pudo añadir
      // si sel valor no se pudo añadir quiere decir que ya estaba el SET por lo tantgo tenemos que eliminarlo
      if (!foundValues.add(current.next.value)){
        current.next = current.next.next;
      }
      current = current.next; // el puntero debe avanzar una posición
    }
  }
//*************probando***********************

  public static void main(String[] args) {
    // Crear la lista: 1 -> 2 -> 2 -> 3 -> 4 -> 1
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(2);
    head.next.next.next = new Node(3);
    head.next.next.next.next = new Node(4);
    head.next.next.next.next.next = new Node(1);

    System.out.println("Lista original:");
    printList(head);

    // Eliminar duplicados
    RemoveDups remover = new RemoveDups();
    remover.removeDups(head);

    System.out.println("Lista sin duplicados:");
    printList(head);
  }

  public static void printList(Node head) {
    Node current = head;
    while (current != null) {
      System.out.print(current.value + " -> ");
      current = current.next;
    }
    System.out.println("END");
  }
}
