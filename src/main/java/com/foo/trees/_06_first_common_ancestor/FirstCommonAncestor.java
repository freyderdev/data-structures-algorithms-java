package com.foo.trees._06_first_common_ancestor;

import com.foo.trees._00_binarytree.Node;

/*
 * Devuelve el primer ancestro común de dos nodos.
 *
 * Ejemplo:
 *  Input:
 *         4
 *      5     7
 *    1   3
 *  8
 *
 *  firstCommonAncestor(1, 7) = 4
 *  firstCommonAncestor(1, 4) = null
 *  firstCommonAncestor(1, 3) = 5
 *
 */
public class FirstCommonAncestor {

  public Node firstCommonAncestor(Node root, Node firstNode, Node secondNode) {
    if (root == null || firstNode == null || secondNode == null) {
      return null;
    }

    if (root == firstNode || root == secondNode) {
      return root;
    }

    Node left = firstCommonAncestor(root.left, firstNode, secondNode);
    Node right = firstCommonAncestor(root.right, firstNode, secondNode);

    if (left != null && right != null) {
      return root; // Found both nodes in different subtrees
    }
    
    return left != null ? left : right; // Return the non-null child  

  }
}
