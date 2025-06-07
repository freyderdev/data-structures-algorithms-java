package com.foo.trees._03_maximum_depth;

import com.foo.trees._00_binarytree.Node;

/*
 * Dada la raíz de un árbol binario, devuelve su profundidad máxima.
 *
 * Ejemplo:
 *  Input:
             4
          /     \
        2       7
      /   \
     1     3
    /
   8
 *
 *  Output: 4
 */
public class MaximumDepth {

  public int maxDepth(Node root) {
        if (root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        // Creamos el árbol manualmente
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.left.left.left = new Node(8); // nodo más profundo

        // Instanciamos la clase y llamamos al método
        MaximumDepth md = new MaximumDepth();
        int profundidad = md.maxDepth(root);

        System.out.println("Profundidad máxima: " + profundidad); // Esperado: 4
    }
}
