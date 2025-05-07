package com.foo.big0.cuadratica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
🧾Enunciado del ejercicio – versión optimizada con Set
Crea un metodo que reciba un array de enteros int[] y un número entero objetivo,
y devuelva una lista de todos los pares (x, y) tal que x + y == objetivo.
Esta vez, el metodo debe tener complejidad O(N) usando una estructura Set para
evitar bucles anidados.
El metodo debe retornar una lista de objetos Par.
Si no se encuentran pares válidos, debe retornar una lista vacía.
 */
// 👉  ✅ Versión O(N) con Set
public class ParesSumaOptimizado {

    public static List<Par> obtenerParesConSuma(int[] array, int objetivo) {
        //🔸 Creamos un Set para guardar los números que ya hemos visto mientras recorremos el array.
        Set<Integer> vistos = new HashSet<>();
        //🔸 Creamos una lista para guardar los pares válidos que encontremos.
        List<Par> resultado= new ArrayList<>();

        for (int x : array){
            //🔸 Calculamos cuánto le falta a x para llegar al objetivo.
            int complemento = objetivo - x;
            if (vistos.contains(complemento)){
                resultado.add(new Par(complemento, x));
            }
        vistos.add(x);
        }
        return resultado;
    }
    public static void main(String[] args) {
        int[] numeros = {1, 3, 4, 5, 6};
        int objetivo = 7;

        List<Par> pares = obtenerParesConSuma(numeros, objetivo);

        if (pares.isEmpty()) {
            System.out.println("❌ No se encontraron pares.");
        } else {
            System.out.println("✅ Pares encontrados:");
            for (Par par : pares) {
                System.out.println(par);
            }
        }
    }
}
