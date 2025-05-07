package com.foo.big0.cuadratica;
/*
🧾 Enunciado del ejercicio:
Dado un arreglo de enteros y un número objetivo (target),
imprime todos los pares (x, y) tales que x + y == target.

int[] array = {1, 3, 4, 5, 6};
int target = 7;
🧱 Implementación base (O(N²)):
 */
public class ParesSumaObjetivo {

    public static void imprimirParesConSuma(int[] array, int objetivo) {
        for (int x : array) {
            for (int y : array) {
                if (x + y == objetivo) {
                    System.out.println(x + " + " + y + " = " + objetivo);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] numeros = {1, 3, 4, 5, 6};
        int objetivo = 7;

        imprimirParesConSuma(numeros, objetivo);
    }
}
