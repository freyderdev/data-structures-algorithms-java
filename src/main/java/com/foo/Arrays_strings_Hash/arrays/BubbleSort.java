package com.foo.Arrays_strings_Hash.arrays;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        System.out.println("🔁 Ordenamiento con Bubble Sort:");
        ejecutarBubbleSort();

        System.out.println("\n⚡ Ordenamiento con Arrays.sort:");
        ejecutarSortJava();
        
    }

    private static void ejecutarBubbleSort() {
        int[] nums = { -1, 0, 1, 2, -1, -4 };

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    // Intercambiar
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(nums));
        // Resultado: [-4, -1, -1, 0, 1, 2]
    }

    // Método 2: Con Arrays.sort()
    private static void ejecutarSortJava() {
        int[] nums = { -1, 0, 1, 2, -1, -4 };

        Arrays.sort(nums); // Ordenamiento automático

        System.out.println(Arrays.toString(nums));
    }

}
