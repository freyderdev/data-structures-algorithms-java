package com.foo.Arrays_strings_Hash.arrays;

import java.util.Arrays;

public class InvertirArreglo {
    public static void main(String[] args) {
        String[] productos = {
                "Kingston Pendrive 64GB",
                "Samsung Galaxy",
                "Disco Duro SSD Externo",
                "Asus Notebook",
                "Macbook Air",
                "Chromecast 4ta generación",
                "Bicicleta Oxford"
        };

        Arrays.sort(productos); // opcional si quieres ver ordenado antes
        System.out.println("Arreglo ordenado:");
        for (String producto : productos) {
            System.out.println(producto);
        }

        reverseArray(productos);

        System.out.println("\nArreglo invertido:");
        for (String producto : productos) {
            System.out.println(producto);
        }
    }

    public static void reverseArray(String[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int reversePosition = array.length - 1 - i;
            String tmpVal = array[i];
            array[i] = array[reversePosition];
            array[reversePosition] = tmpVal;
        }
    }
}
