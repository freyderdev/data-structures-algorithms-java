package com.foo.StacksQueues._05_ReversePolishNotationEvaluator;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 📘 Enunciado típico (parafraseado):
	Dada una expresión en notación polaca inversa (RPN), evalúa su resultado.
	Operadores válidos: "+", "-", "*", "/"
	Cada operando puede ser un número entero.
	Divide truncando hacia cero.
📥 Ejemplo de entrada: ["2", "1", "+", "3", "*"] 
📤 Evaluación: ((2 + 1) * 3) = 9
 */
public class ReversePolishNotationEvaluator {

    public static int evalRPN(String[] tokens) {
        // Definimos la Pila
        Deque<Integer> stack = new ArrayDeque<>();
        // recorrer cada token en la expresión
        for (String token : tokens) {
            // Si el token es un número ➜ lo convertimos y lo pusheamos
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                // 💡 ¿Qué hay que hacer dentro del else?
                // 1. Sacar los dos valores del stack
                // Primero se saca el segundo operando (el último que entró), luego el primero.
                int b = stack.pop();// segundo operando
                int a = stack.pop();
                // 2. Aplicar la operación
                int result = 0;
                switch (token) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b; // divide truncando hacia cero, como pide el enunciado
                        break;
                }
                stack.push(result);
            }
        }
        return stack.pop();// se retorna lo que quedó en el stack
    }

    private static boolean isNumber(String token) {
        // Verificamos si el token es un número
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] expression1 = {"2", "1", "+", "3", "*"};
        String[] expression2 = {"4", "13", "5", "/", "+"};

        System.out.println(evalRPN(expression1)); // Output: 9
        System.out.println(evalRPN(expression2)); // Output: 6
    }

}
