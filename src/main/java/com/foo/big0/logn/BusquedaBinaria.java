package com.foo.big0.logn;

public class BusquedaBinaria {
    public static int buscar(int[] array, int target) {
        int inicio = 0;
        int fin = array.length - 1;
        int paso = 1;
        // Mientras el rango de búsqueda sea válido
        while (inicio <= fin) {
            // Calculamos el índice del elemento central del rango actual
            int medio = inicio + (fin - inicio) / 2;
            // Mostrar en consola el estado del algoritmo
            System.out.println("Paso " + paso + ":");
            System.out.println("  inicio = " + inicio + ", fin = " + fin);
            System.out.println("  medio = " + medio + ", valor medio = " + array[medio]);
            // 🎯 Caso 1: si encontramos el target, lo retornamos
            if (array[medio] == target) { //➡️ ¿8 == 15? ❌ No, no son iguales, así que seguimos evaluando el siguiente else if
                System.out.println("✅ ¡Encontrado en el paso " + paso + "!");
                return medio; // ¡Lo encontramos!
            }
            else if (target < array[medio]) { //¿15 < 8? ❌ No.
                fin = medio - 1;  // 🔽 Buscar en la izquierda
            } else {
                inicio = medio + 1; // 🔼 Buscar en la derecha
            }
            paso++; // Aumentamos el paso para seguir el rastro
            System.out.println(); // Línea vacía para separar pasos
        }
        System.out.println("❌ No se encontró el valor.");
        return -1; // No se encontró
    }

    public static void main(String[] args) {
        int[] datos = {1, 3, 4, 7, 8, 10, 15, 18, 25};
        int indice = buscar(datos, 15);
        System.out.println("Índice del target: " + indice);
    }
}

