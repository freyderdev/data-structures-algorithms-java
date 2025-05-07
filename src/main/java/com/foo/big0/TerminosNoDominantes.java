package com.foo.big0;

public class TerminosNoDominantes {

    public static void analizarComplejidad(int[] array){
        int sum= 0;
        int result = 0;
        //🔹 Primer bucle: O(N)
        for (int val: array){ // 🔹 O(N)
            sum += val;
        }
        //🔹 Bucle aninado: O(N^2)
        for (int x: array){         // 🔹 O(N)
            for (int y: array){     // 🔹 O(N)
                result += x*y - sum;// 🔹 Total: O(N²)
            }
        }
        /*
        ➡️ O(N) + O(N²)
        ➡️ Término no dominante: O(N) ❌
        ➡️ Término dominante: O(N²) ✅
         */
        System.out.println("Suma totla = " + sum);
        System.out.println("Resultado final = " + result);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        analizarComplejidad(array);
    }

}
