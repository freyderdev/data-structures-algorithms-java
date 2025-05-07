package com.foo.big0;

public class Constante {
    // Complejidad O(1) - siempre hace lo mismo sin importar el tamaño
    public static int obtenerPrimerElemento(int[] array){
        return array[0];// acceso directo a un índice
    }

    public static void main(String[] args) {
        int[] numeros = {10,20,30,40,50};

        int primero= obtenerPrimerElemento(numeros);
        System.out.println("El primer número es = " + primero);
    }

}
