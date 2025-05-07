package com.foo.Arrays_strings_Hash.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagramsJava8 {

    public List<List<String>> groupAnagrams(String[] words) {
        // 1. Convertimos el array a un Stream para usar programación funcional
        Map<String, List<String>> anagramMap = Arrays.stream(words)
                /*
                 * Agrupar las palabras por su "clave" de anagrama:
                 * Collectors.groupingBy: Agrupa los elementos del Stream en un Map, donde:
                 * La clave es el resultado del metodo getSortedWord (una versión ordenada de la
                 * palabra).
                 * El valor es una lista de palabras que comparten esa clave (es decir, son
                 * anagramas entre sí).
                 * this::getSortedWord: Es una referencia al metodo getSortedWord, que genera la
                 * clave para agrupar las palabras.
                 * Ejemplo:
                 * Para las palabras ["saco", "caso", "arresto", "rastreo", "programa"]:
                 * "saco" y "caso" tienen la misma clave "acos".
                 * "arresto" y "rastreo" tienen la misma clave "aorrst".
                 * "programa" tiene la clave "aagmoprr".
                 * El mapa resultante (anagramMap) sería algo como:
                 * {
                 * "acos" -> ["saco", "caso"],
                 * "aorrst" -> ["arresto", "rastreo"],
                 * "aagmoprr" -> ["programa"]
                 * }
                 */
                // .collect(Collectors.groupingBy(word -> this.getSortedWord(word)));
                .collect(Collectors.groupingBy(this::getSortedWord)); // version mas elegante
        // 🧠 Imprimir el mapa para ver cómo agrupa los anagramas
        System.out.println("🔍 Mapa agrupado (clave -> palabras):");
        anagramMap.forEach((key, value) -> System.out.println("Clave: " + key + " => " + value));

        // 3. Obtenemos solo los grupos (valores) del mapa
        return anagramMap.values()
                // 4. Convertir los valores a una lista de listas:
                .stream()
                // 5. Finalmente los recogemos en una List<List<String>>
                .collect(Collectors.toList());
    }

    private String getSortedWord(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars); // esto será la "clave" para agrupar anagramas
    }

    public static void main(String[] args) {
        GroupAnagramsJava8 solution = new GroupAnagramsJava8();

        String[] words = { "saco", "arresto", "programa", "rastreo", "caso" };

        List<List<String>> grouped = solution.groupAnagrams(words);
        grouped.forEach(System.out::println);
    }

}
