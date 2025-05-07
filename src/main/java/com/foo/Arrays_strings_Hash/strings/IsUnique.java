package com.foo.Arrays_strings_Hash.strings;

import java.util.HashSet;
import java.util.Set;

public class IsUnique {

    public static void main(String[] args) {

        System.out.println("abcde"); // true
        System.out.println(isUnique("abcded")); // false
        System.out.println(isUnique(""));         // true (cadena vacía = sin caracteres repetidos)
        System.out.println(isUnique("a"));        // true (un solo carácter)
        System.out.println(isUnique("aA"));       // true (diferencia entre 'a' y 'A')
        System.out.println(isUnique("aa"));       // false (carácter repetido)
        System.out.println("¿abcde tiene caracteres únicos? " + isUnique("abcde"));
        System.out.println("¿abcde tiene caracteres únicos? " + isUnique("abcded"));

        System.out.println("¿abcde tiene caracteres únicos BF? " + isUniqueBruteForce("abcde"));    // true
        System.out.println("¿abcde tiene caracteres únicos BF? " + isUniqueBruteForce("abcded"));   // false
        System.out.println(isUniqueBruteForce(""));         // true
        System.out.println(isUniqueBruteForce("aa"));       // false
    }
    //!🧠 Complejidad: Espacio: O(1) porque no usas estructuras adicionales
    //!   (a veces eso lo valoran en entrevistas donde quieren código simple).mas+ eficiente
    private static final int NUMBER_OF_CHARS = 128; // ASCII=128
    public static boolean isUnique(String s){
        if(s.length() > NUMBER_OF_CHARS)  return false;
        //en caso contrario se realiza la implementación de la tabla hash
        // recorriendo los caracteres de nuestra String
        //Creamos un Set para guardar los caracteres que vamos viendo
        Set<Character> characters = new HashSet<>();
        for(Character c: s.toCharArray()){
            if (characters.contains(c))
                return false;
            characters.add(c);
        }
        return true;
    }

    //**
    //*otra solución con dos bucles anidados, que es menos eficiente pero más directa
    //*(y a veces útil si no puedes usar estructuras como Set o HashMap en una entrevista).
    //!🧠 Complejidad: Tiempo: O(n²) porque comparas cada par de caracteres, -eficiente
    public static boolean isUniqueBruteForce(String s) {
        if (s == null) return false;

        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
