package com.foo.Arrays_strings_Hash.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Ejemplo: Agrupar por primera letra
 */
public class GroupByFirstLetterExample {
     public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Ana", "Bob", "Brandon", "Violetta","Carlos");

        // 🔹 Versión con lambda (NO elegante)
        Map<Character, List<String>> groupedLambda = names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));

        System.out.println("Agrupado por primera letra:");
        groupedLambda.forEach((letter, group) ->
                System.out.println("Letra " + letter + ": " + group));

        // 🔹 No hay versión directa con método por referencia para charAt(0)
        System.out.println("\n⚠️ No hay forma directa de hacer método por referencia para charAt(0)");
    }
    
}
