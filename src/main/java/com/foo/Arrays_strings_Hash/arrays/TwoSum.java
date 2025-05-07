package com.foo.Arrays_strings_Hash.arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * Dado un array de números enteros y un target, retorna los índices de dos
 * números para los que la suma de ambos sea igual al target.
 * Puedes asumir que hay solamente una solución.
 *
 * Ejemplo 1:
 *  Input: nums = [9,2,5,6], target = 7
 *  Output: [1,2]
 *  Explicación: nums[1] + nums[2] == 7, devolvemos [1, 2].
 *
 * Ejemplo 2:
 *  Input: nums = [9,2,5,6], target = 100
 *  Output: null
 */

public class TwoSum {
    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] nums = { 9, 2, 5, 6 };
        int target = 7;
        int[] result = ts.twoSum(nums, target);
        if (result != null) {
            System.out.println("[" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No solution found");
        }
    }
    //Input: nums = [9,2,5,6], target = 7
    //compMap [-2,5]
    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length < 2)
            return null;
        /*
         * Creamos un HashMap para almacenar los complementos de cada número.
         * Clave: el valor que falta para alcanzar el target (complemento).
         * Valor: el índice del número original en el array.
         * Esto nos permite buscar en tiempo constante si ya vimos el complemento
         * de un número que estamos procesando.
         */
        Map<Integer, Integer> compMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            /*
             * 1. Debemos comprobar si nuestro número actual está en el mapa de
             * complementos. significa que ya vimos su par complementario previamente, y juntos suman el
             * target
             */
            if (compMap.containsKey(nums[i])) {
                /*
                 * retornamos un nuevo array con los 2 indices que suman nuestro target:
                 * Guardamos el índice actual del número que estamos procesando
                 * Obtenemos el índice del complemento desde el mapa (es decir, el índice del
                 * número que ya habíamos encontrado antes y que sumado al número actual da el
                 * target)
                 */
                int index2 = compMap.get(nums[i]);
                /*
                 * Retornamos un nuevo arreglo con los dos índices que suman el valor
                 * de nuestro target y se organizan s de menor a mayor
                 * el primero es i y el segúndo se puede sacar del map de complementos=compMap<>
                 */
                return new int[] {   Math.min(i, index2), Math.max(i, index2) };
            }
            // En caso contrario tenemos que introducir el complemento del numero actual:
            // El complemento del #numero actual es ese # que sumado con el nos da target
            int complement = target - nums[i];
            compMap.put(complement, i);
        }
        return null;
    }
}
