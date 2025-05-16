package com.foo.Arrays_strings_Hash.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 🔺 3Sum
 * 🎯 Enunciado:
 * Dado un array de enteros llamado nums, encuentra todas las tripletas (tres números) 
 * que suman exactamente 0.
 * 🧪 Ejemplo:
 *  Input: nums = [-1,0,1,2,-1,-4]
 *  Output: [ [-1,-1,2],
 *            [-1,0,1]
 *          ]
 *
 * 
 */

public class ThreeSum {

    // Método principal que encuentra todas las tripletas que suman cero
public List<List<Integer>> threeSum(int[] nums) {
    // Lista para almacenar las tripletas resultantes
    List<List<Integer>> result = new ArrayList<>();

    // Primero ordenamos el array para poder aplicar la técnica de dos punteros
    Arrays.sort(nums);
    // Recorremos el array desde el primer hasta el antepenúltimo elemento
    for (int i = 0; i < nums.length - 2; i++) {
        // Si el número actual es igual al anterior, lo saltamos para evitar duplicados
        if (i > 0 && nums[i] == nums[i - 1]) continue;

        // Inicializamos los punteros izquierdo y derecho
        int left = i + 1;
        int right = nums.length - 1;

        // Mientras los punteros no se crucen
        while (left < right) {
            // Calculamos la suma de los tres elementos
            int sum = nums[i] + nums[left] + nums[right];

            if (sum == 0) {
                // Si la suma es 0, encontramos una tripleta válida
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                // También imprimimos la tripleta (útil para depuración)
                System.out.println("Tripleta: " + nums[i] + ", " + nums[left] + ", " + nums[right]);

                // Movemos el puntero izquierdo si el siguiente número es igual (para evitar duplicados)
                while (left < right && nums[left] == nums[left + 1]) left++;

                // Movemos el puntero derecho si el anterior número es igual (evitar duplicados)
                while (left < right && nums[right] == nums[right - 1]) right--;

                // Finalmente, avanzamos ambos punteros
                left++;
                right--;
            } else if (sum < 0) {
                // Si la suma es menor que 0, necesitamos un número más grande → mover `left`
                left++;
            } else {
                // Si la suma es mayor que 0, necesitamos un número más pequeño → mover `right`
                right--;
            }
        }
    }

    // Retornamos la lista con todas las tripletas encontradas
    return result;
}

// Método principal para probar el algoritmo
public static void main(String[] args) {
    ThreeSum ts = new ThreeSum(); // Creamos una instancia de la clase
    int[] nums = {-1, 0, 1, 2, -1, -4}; // Array de prueba

    // Llamamos al método y guardamos el resultado
    List<List<Integer>> result = ts.threeSum(nums);

    // Imprimimos el resultado final
    System.out.println("result = " + result);
}

}
