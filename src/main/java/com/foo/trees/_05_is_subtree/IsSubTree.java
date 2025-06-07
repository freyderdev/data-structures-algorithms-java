package com.foo.trees._05_is_subtree;

import com.foo.trees._00_binarytree.Node;

/*
 * Determina si el árbol second es subárbol del árbol first.
 *
 * Ejemplo 1:
 *  Input:
 *    first:
 *         4
 *      5     7
 *    1   3
 *  8
 *
 * Ejemplo 2:
 *         4
 *      2     7
 *    1   3  5
 *
 *  Output: false
 *
 * Ejemplo 2:
 *  Input:
 *    first:
 *         4
 *      5     7
 *    1   3
 *  8
 *
 *    second:
 *         5
 *      1     3
 *    8
 *
 * 
 *	TreeFirst 4 - 5 - 1 - 8 - 3 - 7
 *		TreeSecond 5 - 1 - 8 - 3

 * Output: true
 */
public class IsSubTree {

  public boolean isSubtree(Node first, Node second) {
    // hay que utilizar StringBuilders que nos ayudaran a contruir las 2 cadenas
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();

    preOrder(first, sb1);
    preOrder(second, sb2);

    return sb1.toString().contains(sb2.toString());
  }
  //hacemos una funcion que nos haga el recorrido PRE-ORDEN de un Nodo
  //aportando también el StringBuilder para ir construyendo esta cadena TreeFirst 4 - 5 - 1 - 8 - 3 - 7
  private void preOrder(Node node, StringBuilder sb ){
    if (node == null) {
      sb.append("x"); // marcador para nodos nulos
      return;
    }
    //ahora  añadimos simplemente el valor del nodo:
    sb.append(node.value).append("-");
    //realizamos las llamadas recursivas para el recorrido PRE-ORDER
    preOrder(node.left, sb);
    preOrder(node.right, sb);
  }


  public static void main(String[] args) {
    // Construcción del árbol first
    Node first = new Node(4);
    first.left = new Node(5);
    first.right = new Node(7);
    first.left.left = new Node(1);
    first.left.right = new Node(3);
    first.left.left.left = new Node(8);

    // Construcción del árbol second
    Node second = new Node(5);
    second.left = new Node(1);
    second.right = new Node(3);
    second.left.left = new Node(8);

    IsSubTree isSubTreeChecker = new IsSubTree();

    boolean result = isSubTreeChecker.isSubtree(first, second);

    // Mostrar los recorridos preorden
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    isSubTreeChecker.preOrder(first, sb1);
    isSubTreeChecker.preOrder(second, sb2);

    System.out.println("TreeFirst PREORDER:  " + sb1.toString());
    System.out.println("TreeSecond PREORDER: " + sb2.toString());
    System.out.println("Is second a subtree of first? " + result);
  }
}
