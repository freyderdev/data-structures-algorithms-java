package com.foo.linkedlist.e_add_two_numbers;


/*
 * Escribe un algoritmo que realice la suma de dos listas que representan
 * dos enteros positivos. Las listas están en posición invertida.
 *
 * Ejemplo:
 *  Input: 1->2->4, 5->2->8
 *  Output: 6->4->2->7
 *  6421 + 825 = 7246
 */

import com.foo.linkedlist.a_linkedlist.Node;

public class AddTwoNumbersFoo {

    /*
     * 👉 Usa la técnica #3: Parallel Traversal (Two Pointers moving in sync)
     * ¿Por qué?
     * Tienes dos listas (list1 y list2) y cada una tiene su puntero.
     * Ambos punteros avanzan al mismo ritmo, sumando dígito a dígito.
     * No se trata de detectar ciclos ni de moverse desde extremos, sino de recorrer
     * ambas listas sincronizadamente.
     * 
     * 📌 Clasificación:
     * 🔹 Two Pointers – Parallel Traversal
     */
    public Node addTwoNumbers(Node list1, Node list2) {
        // En primer lugar vamos a crear un nodo que será el inicio de nuestro resultado:
        Node result = new Node(-1); // se inicializa con cualquier valor ya que se ira modificando
        Node current = result; // para ir creando nuestra lista resultado
        int carry = 0; // variable para el acarreo

        while (list1 != null || list2 != null) { //Mientras queden elementos en alguna de las 2 listas
            //inicializamos una variable que represente el digito resultado actual
            int digit = carry;

            if (list1 != null) {
                //tenemos que añadir a nuestro digito el valor de la lista1
                digit += list1.value;
                list1 = list1.next; //avanzamos una posicion nuestra lista1
            }
            if (list2 != null) {
                //tenemos que añadir a nuestro digito el valor de la lista2
                digit += list2.value;
                list2 = list2.next; //avanzamos una posicion nuestra lista2
            }
            //Tenemos que calcular si la suma de estas 2 cifras da lugar a un nuevo acarreo
            // y en ese caso tenerlo en cuenta para la siguiente iteracion
            // como es una divición de enteros, si nuestro digito no llega a 10 el acarreo va hacer 0
            carry = digit / 10; // carry = 12 / 10 = 1
            // un digito no puede pasar de 10, si el digito es 7 se queda en 7, si es 12
            digit = digit % 10; // digit = 12 % 10 = 2

            current.value = digit; // se asigna el valor al nodo actual

            if (list1 != null || list2 != null) {
                current.next = new Node(-1);
                current = current.next;
            }
        }
        // 🔹 Añadir nodo final si hay acarreo pendiente
        if (carry > 0) {
            current.next = new Node(carry);
        }
        return result;
    }

    public static void main(String[] args) {
        // Lista 1: 1 → 2 → 4 → 6 (6421)
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(4);
        l1.next.next.next = new Node(6);

        // Lista 2: 5 → 2 → 8 (825)
        Node l2 = new Node(5);
        l2.next = new Node(2);
        l2.next.next = new Node(8);

        // Instancia de la clase que contiene el método addTwoNumbers
        AddTwoNumbers solver = new AddTwoNumbers();
        Node result = solver.addTwoNumbers(l1, l2);

        // Imprimir resultado: debería ser 6 → 4 → 2 → 7
        System.out.print("Resultado: ");
        printList(result);
    }

    // Metodo para imprimir la lista
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value);
            if (head.next != null) System.out.print(" → ");
            head = head.next;
        }
        System.out.println();
    }

}
