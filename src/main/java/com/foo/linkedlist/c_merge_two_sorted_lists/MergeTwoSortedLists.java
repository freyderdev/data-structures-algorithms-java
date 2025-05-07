package com.foo.linkedlist.c_merge_two_sorted_lists;

import com.foo.linkedlist.a_linkedlist.Node;


/*
 * Escribe un algoritmo para combinar dos listas enlazadas simples ordenadas.
 * El resultado debe ser una única lista enlazada ordenada. Devuelve su head.
 *
 * Ejemplo:
 *  Input: 1->2->4->6, 2->3->5
 *  Output: 1->2->2->3->4->5->6
 */
public class MergeTwoSortedLists {
    public Node mergeTwoLists(Node list1, Node list2) {

        Node dummy = new Node(-1); //actúa como nodo inicial “ficticio”
        Node tail = dummy; // tail empieza apuntando al dummy

        Node p1 = list1;
        Node p2 = list2;
        //un bucle que recorra las dos listas mientras ambas tengan elementos
        while (p1 != null && p2 != null) {
            if (p1.value <= p2.value) {
                tail.next = new Node(p1.value);
                p1 = p1.next;// avanzo el puntero p1
            } else {
                tail.next = new Node(p2.value);
                p2 = p2.next; //avanzo el puntero p2
            }
            tail = tail.next;
        }
        // Conectar los elementos restantes:
        if (p1 != null) {
            tail.next = p1;
        } else if (p2 != null) {
            tail.next = p2;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        // Lista 1: 1 -> 2 -> 4 -> 6
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(4);
        list1.next.next.next = new Node(6);

        // Lista 2: 2 -> 3 -> 5
        Node list2 = new Node(2);
        list2.next = new Node(3);
        list2.next.next = new Node(5);

        // Merge
        MergeTwoSortedLists merger = new MergeTwoSortedLists();
        Node mergedHead = merger.mergeTwoLists(list1, list2);

        // Imprimir resultado
        printList(mergedHead);
    }

    private static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("END");
    }
}
