package com.foo.big0.cuadratica;

import java.util.ArrayList;
import java.util.List;

/*
// retorna pares como lista
🎯 Enunciado:
Modifica el metodo imprimirParesUnicosConSuma para que ya no
imprima los pares en consola, sino que los retorne en una lista de
objetos Pair o String, para que puedan usarse en pruebas unitarias.
 */
public class ParesSumaRetornando {

    public static List<Par> obtenerParesConSuma(int[] array, int objetivo){
        List<Par> resultado= new ArrayList<>();
        for (int i = 0; i <array.length ; i++) {
            for(int j= i+1; j<array.length; j++){
                int x = array[i];
                int y = array[j];
                resultado.add(new Par(x,y));
            }
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


