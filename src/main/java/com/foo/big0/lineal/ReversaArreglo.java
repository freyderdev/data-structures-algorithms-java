package com.foo.big0.lineal;

import java.util.Arrays;

public class ReversaArreglo {

    public static void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int reversePosition = array.length - 1 - i;//intercambia los extremos

            // Mostrar en consola el intercambio
            System.out.println("Paso " + (i + 1) + ":");
            System.out.println("  i = " + i + " (valor = " + array[i] + ")");
            System.out.println("  reversePosition = " + reversePosition + " (valor = " + array[reversePosition] + ")");
            System.out.println("  → Intercambiando " + array[i] + " y " + array[reversePosition]);

            int tmpVal = array[i];
            array[i] = array[reversePosition];
            array[reversePosition] = tmpVal;
            System.out.println("  Resultado parcial: " + Arrays.toString(array));
            System.out.println("--------------------------------------------------");
        }
    }

    public static void main(String[] args) {

        int[] numeros = {15, 10, 25, 18};

        System.out.println("🔁 Array original: " + Arrays.toString(numeros));
        reverseArray(numeros);
        System.out.println("✅ Array invertido: " + Arrays.toString(numeros));
    }
}
