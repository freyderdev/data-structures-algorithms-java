package com.foo.StacksQueues._02_valid_parenthesis;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Dado un String que solamente contiene los caracteres '(', ')', '{', '}', '[' y ']',
 * implementa un algoritmo para determinar si es válido.
 *
 * Ejemplo 1:
 *  Input: "([]){}"
 * 
 *  *   *   *    *
 *  * ] *   *    *
 *  * [ *   *  ) *
 *  * ( *   *  ( * 
 *  *****   ******
 *  Output: true
 *
 * Ejemplo 2:   
 *  Input: "({)}"
 *  Output: false  
 * 
 *  *   *   
 *  * ) *   
 *  * { *   
 *  * ( *   
 *  *****   
 *  Output: false 
 */
public class isValidParenthesis {

  public boolean isValid(String s) {

    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i); // Obtener el caracter en la posición i
      if (c == '(' || c == '{' || c == '[') {
        stack.push(getOpposite(c));// Agregar el caracter opuesto a la pila
      } else {
        if (stack.isEmpty() || stack.pop() != c) // Si la pila está vacía o el caracter no coincide con el opuesto
          return false;
      }
    }
    // Al final, la pila debe quedar vacía
    return stack.isEmpty();
  }
  // Método para obtener el caracter opuesto
  private Character getOpposite(char c) {
    if (c == '(')
      return ')';
    if (c == '{')
      return '}';
    if (c == '[')
      return ']';

    return '0';
  }

  public static void main(String[] args) {
    isValidParenthesis solution = new isValidParenthesis();
    System.out.println(solution.isValid("([]){}")); // true
    System.out.println(solution.isValid("({)}")); // false
  }
}
