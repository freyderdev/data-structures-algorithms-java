package com.foo.linkedlist.a_linkedlist;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

        System.out.println("Agregando elementos:");
        list.appendToTail(4);
        list.appendToTail(3);
        list.appendToTail(1);
        list.print(); // Debería imprimir: 4 -> 3 -> 1 -> END

        System.out.println("\nEliminando el nodo con valor 3:");
        list.deleteNode(3);
        list.print(); // Debería imprimir: 4 -> 1 -> END

        System.out.println("\nEliminando el nodo con valor 4 (cabeza):");
        list.deleteNode(4);
        list.print(); // Debería imprimir: 1 -> END

        System.out.println("\nEliminando el nodo con valor 1 (último):");
        list.deleteNode(1);
        list.print(); // Debería imprimir: END

        System.out.println("\nIntentando eliminar de lista vacía:");
        list.deleteNode(99); // No debería hacer nada
        list.print(); // Debería imprimir: END
    }
}
