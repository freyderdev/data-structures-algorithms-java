package com.foo.linkedlist.d_nth_node_to_last;

import com.foo.linkedlist.a_linkedlist.Node;

/*
 * Dada una lista enlazada simple y un valor N, devuelve el nodo N empezando por el final
 *
 * Ejemplo:
 *  Input: 1->2->4->6, 2
 *  Output: 4
 */
public class NthNodeToLast {
    // Versión 1: dos recorridos
    public Node nthNodeToLast(Node head, int n) {

        int length = 0;
        Node current = head; // Puntero para recorrer la lista desde el principio
        while (current != null) {
            length++; // Aumenta el contador por cada nodo
            current = current.next; // Avanza al siguiente nodo
        }
        // ⚠️ Validación: si n es inválido (mayor que la longitud o menor o igual a 0),
        // no hay solución
        if (n > length || n <= 0) {
            return null; // o lanzar excepción, según cómo quieras manejarlo
        }
        // 🎯 Calcular la posición objetivo desde el principio (0-based)
        int target = length - n;
        // 🔁 Segundo recorrido: volver al inicio y avanzar hasta el nodo deseado
        current = head; // Reiniciamos el puntero al inicio
        for (int i = 0; i < target; i++) {
            current = current.next; // Avanzamos hasta la posición objetivo
        }
        return current; // ✅ Al llegar a la posición, devolvemos el nodo correspondiente
    }

    /*
     * 2 pointers technique: 👉 Usa la técnica #2: Slow and Fast Pointers
     * Por qué?
     * Tienes un puntero fast que se adelanta n posiciones.
     * Luego ambos (fast y slow) avanzan al mismo ritmo hasta que fast llega al
     * final.
     * Esta estrategia es clásica para recorrer la lista una sola vez y ubicar un
     * nodo en una posición relativa al final.
     * 📌 Clasificación:
     * 🔹 Two Pointers – Slow and Fast
     * 🔹 También llamada técnica de "Tortuga y Liebre" (Tortoise and Hare)
     */

    /**
     * Devuelve el nodo que está en la posición N contando desde el final de la
     * lista,
     * usando la técnica de dos punteros (fast & slow) en una sola pasada.
     * <p>
     * Ejemplo: Lista: 1 → 2 → 4 → 6, n = 2 → retorna 4
     *
     * @param head Nodo cabeza de la lista enlazada
     * @param n    Posición desde el final (1-based)
     * @return Nodo que está a n posiciones desde el final, o null si n es inválido
     */
    public Node nthNodeToLastWithPointers(Node head, int n) {

        Node fast = head;
        Node slow = head;
        // Avanza el puntero 'fast' n pasos hacia adelante
        for (int i = 0; i < n; i++) {
            if (fast == null)
                return null;// n es mayor que la longitud
            fast = fast.next;
        }
        // Avanza ambos punteros hasta que 'fast' llegue al final
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // Cuando 'fast' llegue al final, 'slow' estará en el nodo deseado
        return slow;
    }

    public static void main(String[] args) {
        // Crear lista: 1 → 2 → 4 → 6
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = new Node(6);

        int n = 2;

        NthNodeToLast solver = new NthNodeToLast();
        Node result = solver.nthNodeToLast(head, n); // Versión 1: dos recorridos

        if (result != null) {
            System.out.println("(2 recorridos)El nodo número " + n + " desde el final es: " + result.value);
        } else {
            System.out.println("Valor inválido de n o lista vacía.");
        }
        Node result2 = solver.nthNodeToLastWithPointers(head, n); // Versión 2: un recorrido
        if (result2 != null) {
            System.out.println("(1 recorridos)El nodo número " + n + " desde el final es: " + result2.value);
        } else {
            System.out.println("Valor inválido de n o lista vacía.");
        }
    }
}
