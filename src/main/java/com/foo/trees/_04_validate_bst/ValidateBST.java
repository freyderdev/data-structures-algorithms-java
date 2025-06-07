package com.foo.trees._04_validate_bst;

import com.foo.trees._00_binarytree.Node;

/*
 * Determina si un árbol binario es un árbol binario de búsqueda válido:
 *  - El subárbol izquierdo de un nodo contiene solamente nodos <= que él.
 *  - El subárbol derecho de un nodo contiene solamente nodos > que él.
 *  - Ambos subárboles deben ser a su vez árboles binarios de búsqueda.
 *   BST significa Binary Search Tree
 *
 * Ejemplo 1:
 *  Input:
 *         4
 *      5     7
 *    1   3
 *  8
 *
 *  Output: false
 *
 * Ejemplo 2:
 *  Input:
 *         4
 *      2     7
 *    1   3  5
 *
 *  Output: true
 */
public class ValidateBST {
  // esta funcion solo llamara a la funcion auxiliar:
  public boolean isValidBST(Node root) {
    // necesitamos una funcion auxiliar que lleve cuenta de los minimos y máximos
    return isValidBST(root, null, null);
  }

  public boolean isValidBST(Node root, Integer min, Integer max) {
    // cuales son las condiciones de parada?
    if (root == null)
      return true;
    // condicion que inclumpla los min || condicion que inclumpla los max
    if ((min != null && root.value <= min) || (max != null && root.value > max))
      return false;
    // tenemos que comprobar si el subArbol izquierdo de ese nodo y el derecho
    // también son válidos
    // hacemos las llamadas recursivas

    return isValidBST(root.left, min, root.value) && isValidBST(root.right, root.value, max);

  }




  public static void main(String[] args) {
        ValidateBST validator = new ValidateBST();

        // Ejemplo 1: Árbol inválido
        Node root1 = new Node(4);
        root1.left = new Node(5); // ❌ invalida la propiedad BST
        root1.right = new Node(7);
        root1.left.left = new Node(1);
        root1.left.right = new Node(3);
        root1.left.left.left = new Node(8);

        System.out.println("Árbol 1 es BST válido: " + validator.isValidBST(root1)); // false

        // Ejemplo 2: Árbol válido
        Node root2 = new Node(4);
        root2.left = new Node(2);
        root2.right = new Node(7);
        root2.left.left = new Node(1);
        root2.left.right = new Node(3);
        root2.right.left = new Node(5);

        System.out.println("Árbol 2 es BST válido: " + validator.isValidBST(root2)); // true
    }
}
