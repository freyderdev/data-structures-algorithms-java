package com.foo.trees._01_invert_binary_tree;

import com.foo.trees._00_binarytree.Node;

/*
 * Dada la raíz de un árbol binario, devuelve el árbol binario invertido.
 *
 * Ejemplo:
 *  Input:
 *        4
 *     2     7
 *   1   3  6  9
 *
 *  *  Output:
 *        4
 *     7     2
 *   9   6  3  1
 *
 */

public class InvertBinaryTree {

    // Función recursiva para invertir un árbol binario
    public static Node invertBinaryTree(Node root) {
        if (root == null) return null; // Caso base: Si el nodo es nulo, retornamos

        // Intercambiamos los hijos izquierdo y derecho
        Node temp = root.left;  // Guardamos el subárbol izquierdo en una variable temporal
        root.left = root.right; // Asignamos el subárbol derecho al izquierdo
        root.right = temp; // Asignamos el original izquierdo al derecho

        // Llamamos recursivamente la función en los nuevos subárboles izquierdo y derecho
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);

        return root; // Retornamos la raíz ya invertida
    }

    // Función para imprimir el árbol en preorden (Nodo → Izquierda → Derecha)
    public static void imprimirArbol(Node root) {
        if (root == null) return; // Si es nulo, no hacemos nada
        System.out.println(root.value); // Imprimimos el valor del nodo actual
        imprimirArbol(root.left); // Recorremos el subárbol izquierdo
        imprimirArbol(root.right); // Recorremos el subárbol derecho
    }

    public static void main(String[] args) {
        // Creación de un árbol de ejemplo
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(9);

        // Imprimimos el árbol original
        System.out.println("Árbol Original:");
        imprimirArbol(root);

        // Invertimos el árbol
        root = invertBinaryTree(root);

        // Imprimimos el árbol ya invertido
        System.out.println("Árbol Invertido:");
        imprimirArbol(root);
    }
}










// public class InvertBinaryTree {

//   public static Node invertTree(Node root) {
//     if (root == null) return null;

//     Node temp = root.left; //variable temporal que guarda el subArbol izquierdo
//     //Asignamos al subArbol-izq el subArbol-derecho invertido y para eso se hace la llamada recursiva:
//     root.left = invertTree(root.right);
//     //Asignamos al subArbol-derecho el subArbol-izquierdo invertido y para eso se hace la llamada recursiva:
//     // para eso se asigna en una variable temporal para que no se sobreescriba
//     root.right = invertTree(temp);

//     //Una vez finalizado devolvemos el nodo raiz con sus subArboles invertidos
//     return root;
//   }
// }
