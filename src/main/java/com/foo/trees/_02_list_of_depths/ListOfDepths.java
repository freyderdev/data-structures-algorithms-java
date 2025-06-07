package com.foo.trees._02_list_of_depths;

import com.foo.trees._00_binarytree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Implementa un algoritmo que devuelva una lista enlazada con los nodos de cada nivel. Si el árbol tiene
 * N niveles debes devolver N listas enlazadas.
 *
 * Ejemplo:
 *  Input:
 *        4
 *     2     7
 *   1   3  6  9
 *
 *  Output:
 *    4
 *    2->7
 *    1->3->6->9
 */
public class ListOfDepths {

  public List<LinkedList<Node>> listOfDepths(Node root) {
    //Se crea una lista result que almacenará las listas enlazadas de cada nivel del árbol.
    List<LinkedList<Node>> result = new ArrayList<>();
    //tenemos que crear una lista que lleve la cuenta de los nodos de cada nivel:
    LinkedList<Node> current = new LinkedList<>();
    //tenemos que añadir a nuestra lista enlazada la raiz
    current.add(root);//4
    //si la raiz es nula, no hay nada que procesar:   
    //hacemos el procesamiento hasta que nuestra lista esta vacia:
    while (!current.isEmpty()) {
      result.add(current); //result = [[4], [2, 7]]
      LinkedList<Node> parents = current;
      current = new LinkedList<>();  //reiniciamos la lista enlazada para el siguiente nivel
      //iteramos sobre los nodos del nivel actual:
      for (Node node : parents) {
        if (node.left != null) {
          current.add(node.left); // node = 4 → left = 2 → current = [2]
                                  // node = 2 → left = 1 → current = [1]
        }
        if (node.right != null) {
          current.add(node.right); // node = 4 → right = 7 
                                   // node = 2 → right = 3 → current = [3]
        }
        //current = [2, 7]
      }
    }
    return result;
  }

  public static void main(String[] args) {
        // Construimos el árbol de ejemplo:
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(9);

        // Llamamos al método
        ListOfDepths lod = new ListOfDepths();
        List<LinkedList<Node>> niveles = lod.listOfDepths(root);

        // Imprimimos el resultado
        int nivel = 0;
        for (LinkedList<Node> lista : niveles) {
            System.out.print("Nivel " + nivel + ": ");
            for (Node n : lista) {
                System.out.print(n.value + " ");
            }
            System.out.println();
            nivel++;
        }
    }
}
