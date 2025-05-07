package com.foo.Arrays_strings_Hash.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Un anagrama es una palabra creada a partir de la reordenación de las letras de otra palabra. Ej: saco - caso
 * Dado un array de strings, devuelve los anagramas agrupados. Cualquier orden es válido.
 *
 * Ejemplo:
 *  Input: words = ["saco", "arresto", "programa", "rastreo", "caso"].
 *  Output: [["saco", "caso"], ["arresto", "rastreo"], ["programa"]].
 */
public class GroupAnagramsSolution {

  public static void main(String[] args) {
    GroupAnagramsSolution solution = new GroupAnagramsSolution();

    String[] words = { "saco", "arresto", "programa", "rastreo", "caso" };
    List<List<String>> groupedAnagrams = solution.groupAnagrams(words);

    for (List<String> group : groupedAnagrams) {
      System.out.println(group);
    }

  }


  /*
   * Esta funcion tiene que devolver un String que será del Hash del Anagrama
   */
  private String getAnagramHash(String s) {
    /*
     * Aquí se crea un arreglo de enteros llamado letterCount con 26 posiciones,
     * una para cada letra del abecedario en inglés (de 'a' a 'z').
     * Cada posición del arreglo representará cuántas veces aparece una letra en la
     * palabra.
     * Por ejemplo:
     * La posición 0 representa la letra 'a'.
     * La posición 1 representa la letra 'b'.
     * Y así sucesivamente hasta la posición 25, que representa la letra 'z'
     */
    int[] letterCount = new int[26];// Array para contar las letras del abecedario Inicializa el arreglo con 26
                                    // ceros
    // tenemos que recorrer todos los caracteres de nuestra palabra:
    // !Vamos a tomar los caracteres como enteros:
    /*
    * un caracter es un entero, ejemplo en ASCII la "a = 97" ,
     * y dependiendo de nuestro charset sera un entero u otro
     * entonces rrecorremos de esta forma la palabra:
     * El método .toCharArray() convierte el String (la palabra) en un arreglo de
     * caracteres (char[]).
     * Por ejemplo:
     * Si s = "saco", entonces s.toCharArray()
     * devuelve ['s', 'a', 'c', 'o'].
     * Este es un bucle for-each que recorre cada carácter del arreglo generado por
     * toCharArray().
     * Cada carácter se almacena en la variable c durante cada iteración.
     */
    for (int c : s.toCharArray()) {
      // c - 'a' localiza la posición en el arreglo.
      // ++ incrementa el valor en esa posición, asignando el conteo de la letra.
      letterCount[c - 'a']++; // Incrementa el valor en la posición correspondiente
    }
    /*
     * convierte el arreglo de enteros en una cadena que muestra los valores del
     * arreglo
     * El arreglo letterCount ahora contiene los conteos de cada letra en la palabra
     * "saco".
     * [1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0,
     * 0]
     * 1 'a' (posición 0).
     * 1 'c' (posición 2).
     * 1 'o' (posición 14).
     * 1 's' (posición 18).
     */
    return Arrays.toString(letterCount);

  }

  /*
   * Esta función agrupa las palabras en "anagramas", para ellos vamos a utilizar
   * una tabla Hash en
   * forma de HashMap<>, esta funcion nos devolverá el Hash = Map<String> y
   * de valor la lista de palabras Map<List<String>> y va recibir nuestras
   * palabras (Strin[] words)
   */
  private Map<String, List<String>> buildAnagramMap(String[] words) {
    /* 1. se inicializa un Mapa vacio: */
    Map<String, List<String>> anagramMap = new HashMap<String, List<String>>();
    /* 2.tenemos que recorrer cada palabra */
    for (String word : words) {
      /* 3.para cada palabra calculamos su Hash */
      String hash = getAnagramHash(word);
      if (!anagramMap.containsKey(hash)) {
        anagramMap.put(hash, new ArrayList<String>());
      }

      anagramMap.get(hash).add(word);
    }

    return anagramMap;
  }

  public List<List<String>> groupAnagrams(String[] words) {
    if (words == null || words.length == 0)
      return Collections.emptyList();

    Map<String, List<String>> anagramMap = buildAnagramMap(words);
    return new ArrayList<>(anagramMap.values());
  }
}