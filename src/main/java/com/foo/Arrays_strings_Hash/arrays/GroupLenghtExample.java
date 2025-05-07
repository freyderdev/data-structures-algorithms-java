package com.foo.Arrays_strings_Hash.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Agrupar por longitud de palabra
 * 🧠 ¿Qué estamos agrupando aquí? Agrupamos las palabras por la cantidad de letras que tienen.
 * Propósito de la clase
*   El objetivo de esta clase es agrupar palabras en función de la cantidad de letras que tienen. 
*Por ejemplo:
*   Palabras con 2 letras: ["AI", "Go"].
*   Palabras con 3 letras: ["Map"].
*   Palabras con 4 letras: ["Java", "Code", "Stram"].
*/
public class GroupLenghtExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "Code", "AI", "Stram", "Map", "Go", "Violetta");

        // 🔹 Versión NO elegante (lambda)
        Map<Integer, List<String>> groupedLambda = words.stream()
                
                .collect(Collectors.groupingBy(word -> word.length()));
                /*
                 * Collectors.groupingBy: 
                 Agrupa los elementos del Stream en un Map, donde:
                 La clave es la longitud de la palabra (word.length()).
                 El valor es una lista de palabras que tienen esa longitud.
                 Ejemplo:
                
                 Para la lista ["Java", "Code", "AI", "Stram", "Map", "Go"]:
                 "Java" tiene longitud 4.
                 "AI" tiene longitud 2.
                 "Map" tiene longitud 3.
                 El mapa resultante sería:
                 {
                    * 2 -> ["AI", "Go"], // Clave: 2, Valor: ["AI", "Go"]
                    * 3 -> ["Map"], // Clave: 3, Valor: ["Map"]
                    * 4 -> ["Java", "Code", "Stram"] // Clave: 4, Valor: ["Java", "Code", "Stram"]
                    * 8 -> ["Violetta"]
                 }
                 Resumen:
                    Clave: La longitud de la palabra (4 para "Java").
                    Valor: Una lista de palabras con esa longitud (["Java", "Code", "Stram"]).
                 */

        System.out.println("Versión con lambda:");
        /*Imprimir el resultado */
        groupedLambda.forEach((length, group) -> System.out.println("Longitud " + length + ": " + group));

        // 🔹 Versión elegante (método por referencia)
        Map<Integer, List<String>> groupedElegant = words.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println("\nVersión con método por referencia:");
        groupedElegant.forEach((length, group) -> System.out.println("Longitud " + length + ": " + group));
    }

}
