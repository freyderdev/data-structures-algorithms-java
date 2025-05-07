package com.foo.Arrays_strings_Hash.arrays;

/*
🧾 PLANTEAMIENTO DEL PROBLEMA: Two Sum II – Input array is sorted
Se te da un array ordenado ascendentemente de números enteros y un número objetivo (target).
Tu tarea es encontrar los índices (1-indexed) de los dos números cuya suma es igual al target.
Se garantiza que hay una sola solución.

numbers = [2, 7, 11, 15]
Resultado: [1, 2] // porque 2 está en la posición 1 (no 0) y 7 en la 2
 */
public class TwoSumII {

    public static void main(String[] args) {
        TwoSumII ts = new TwoSumII();
        int[] numbers = { 2, 7, 11, 15 };
        int target = 9;

        int[] result = ts.twoSumII(numbers, target);
        if (result != null) {
            System.out.println("[" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No solution found");
        }
    }

    public int[] twoSumII(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;
        //👉 NO se utiliza un for ni for aninados porque el array[] viene ordenado se utilizan punteros
        while (left < right) {
            int suma = numbers[left] + numbers[right];

            if (suma == target) {
                return new int[]{left + 1, right + 1};
            } else if (suma < target) {
                left++; //🔼 Mover hacia derecha → buscar suma mayor
            } else {
                right--; // 🔽 Mover hacia izquierda → buscar suma menor
            }
        }
        return null; // ✅ Por si no se encuentra una solución (buena práctica)
    }
}
