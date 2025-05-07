package com.foo.Arrays_strings_Hash.arrays;

import java.util.Arrays;

/*
 * 🧾 Ejercicio: Remove Duplicates from Sorted Array
🎯 Enunciado:
	Dado un array [] ordenado en forma ascendente, elimina los elementos duplicados in-place, 
    de forma que cada elemento único aparezca solo una vez.
	Devuelve la nueva longitud del array que contiene los elementos únicos.
	No puedes usar estructuras adicionales (como Set, List, etc.), y debes hacerlo 
    usando solo O(1) espacio extra.
	🧪 Ejemplo:
	Input:  nums = [1,1,2,2,3,4,4]
	Output: 5 → y los primeros 5 elementos del array deben ser: [1,2,3,4,_]
	El contenido más allá del índice retornado no importa.
	✅ Restricciones:
		• El array ya está ordenado
		• Debes hacer el cambio in-place
Retornarás un int (la cantidad de elementos únicos)
 */
public class RemoveDuplicatesSortedArray {

    public static void main(String[] args) {
        RemoveDuplicatesSortedArray removeDuplicates = new RemoveDuplicatesSortedArray();
        int[] nums = {1,1,2,2,3,4,4};
        int length = removeDuplicates.remove(nums);
        System.out.println("La longitud del array sin duplicados es: " + length);
        System.out.print("Los elementos únicos son: ");
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
        
    /*
     * 🧠 Ejemplo:
     *                        i
     * Input:  nums = [ 1, 1, 2, 2, 3, 4, 4]
     *                  0  1  2  3  4  5  6
     *                     j 
     * Output: 5 → y los primeros 5 elementos del array deben ser: [1,2,3,4,_]
     * El contenido más allá del índice retornado no importa.
     */

    public int remove(int[] nums){
        /*
     * 🧠 Ejemplo paso a paso:
     * Entrada: nums = [1, 1, 2, 2, 3, 4, 4]
     Iteraciones:
     | i   | j   | nums[i] | nums[j] | Acción                           | Array modificado          |
     |-----|-----|---------|---------|--------------------------------- |---------------------------|
     | 1   | 0   | 1       | 1       | Duplicado, no hacemos nada       | [1, 1, 2, 2, 3, 4, 4]     |
     | 2   | 0   | 2       | 1       | Nuevo elemento, j++, sobrescribe | [1, 2, 2, 2, 3, 4, 4]     |
     | 3   | 1   | 2       | 2       | Duplicado, no hacemos nada       | [1, 2, 2, 2, 3, 4, 4]     |
     | 4   | 1   | 3       | 2       | Nuevo elemento, j++, sobrescribe | [1, 2, 3, 2, 3, 4, 4]     |
     | 5   | 2   | 4       | 3       | Nuevo elemento, j++, sobrescribe | [1, 2, 3, 4, 3, 4, 4]     |
     | 6   | 3   | 4       | 4       | Duplicado, no hacemos nada       | [1, 2, 3, 4, 3, 4, 4]     |
     * Salida:
     * Longitud: j + 1 = 4
     * Array modificado: [1, 2, 3, 4, _, _, _] (los valores después de j + 1 no importan).
     */
        System.out.println("Estado del array: " + Arrays.toString(nums));
        int j=0; // j marca la última posición válida sin duplicados.
        for (int i = 1; i < nums.length; i++) { //Recorremos con i desde el segundo elemento
            System.out.println("i: " + i + ", j: " + j + ", nums[i]: " + nums[i] + ", nums[j]: " + nums[j]);
            
            if (nums[i] != nums[j]) {
                j++;               // Incrementa `j` para apuntar a la siguiente posición válida.
                nums[j] = nums[i]; // Copia el nuevo elemento único en esa posición.
            }
        }
        return j + 1;
    }
    
}

