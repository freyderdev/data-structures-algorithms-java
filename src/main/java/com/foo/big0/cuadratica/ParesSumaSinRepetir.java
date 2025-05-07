package com.foo.big0.cuadratica;

/*
🧾 Enunciado ajustado:
Imprime todos los pares (x, y) donde x + y == target,
pero sin imprimir el mismo par en orden invertido.

👉 🧠 Clave para evitar duplicados:
Podemos evitar repeticiones asegurándonos de que solo
imprimimos el par cuando x < y.
Así:
Imprimimos (3, 4) ✅
Y evitamos imprimir (4, 3) ❌
 */

public class ParesSumaSinRepetir {

    public static void imprimirParesUnicosConSuma(int[] array, int objetivo){
        for (int i=0; i < array.length; i++){
            for (int j = i + 1; j < array.length; j++) { // 🔍 j comienza en i+1
                int x= array[i];
                int y= array[j];
                if (x + y == objetivo){
                    System.out.println(x + " + " + y + " = " + objetivo);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] numeros = {1, 3, 4, 5, 6};
        int objetivo = 7;
        imprimirParesUnicosConSuma(numeros, objetivo);
    }
}
