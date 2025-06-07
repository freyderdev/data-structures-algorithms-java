package com.foo.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.foo.trees._02_list_of_depths.ListOfDepths;
import com.foo.trees._00_binarytree.Node;

public class ListOfDepthsTest {
    @Test
    void testListOfDepths() {
        // Construimos el árbol de prueba
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(9);

        // Instanciamos la clase y ejecutamos el método
        ListOfDepths listOfDepths = new ListOfDepths();
        List<LinkedList<Node>> result = listOfDepths.listOfDepths(root);

        // Validamos la cantidad de niveles
        assertEquals(3, result.size());

        // Validamos los valores por nivel
        assertEquals(List.of(4), extractValues(result.get(0)));
        assertEquals(List.of(2, 7), extractValues(result.get(1)));
        assertEquals(List.of(1, 3, 6, 9), extractValues(result.get(2)));
    }

    private List<Integer> extractValues(LinkedList<Node> list) {
        List<Integer> values = new LinkedList<>();
        for (Node node : list) {
            values.add(node.value);
        }
        return values;
    }

    
}
