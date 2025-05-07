package com.foo.Arrays_strings_Hash.strings;

/*
 * 🧾Ejercicio 1: Palindrome Check (Verificar si es un palíndromo)
 * Dada una cadena de caracteres (String), escribe una función 
 * que verifique si es un palíndromo.
 * Un palíndromo es una palabra o frase que se lee igual de
 *  izquierda a derecha que de derecha a izquierda.
 * ❗ Ignora los espacios, signos de puntuación y diferencia 
 * entre mayúsculas/minúsculas
 */
/*
 * 🧠 Ejemplos:
Entrada	                          Salida	            Explicación
"reconocer"	                      true	            Es igual al revés
"Anita lava la tina"	          true	            Es palíndromo ignorando espacios
"Hola mundo"	                  false	            No se lee igual al revés
"A man, a plan, a canal: Panama"  true	           Ignora signos y mayúsculas
 */
public class PalindromeCheck {

    public static boolean isPalindrome(String frase){
        //Eso elimina todo lo que no sea una letra minúscula (es decir, quita espacios, signos, números, etc.)
        String f = frase.toLowerCase().replaceAll("[^a-z]", "");
        int left = 0;
        int right = f.length()-1;

        while (left < right) {
            //Comparamos los caracteres de izquierda y derecha
            if (f.charAt(left) != f.charAt(right)) {
                return false; // No es un palíndromo
            }
            left++; // Mover el puntero izquierdo hacia la derecha
            right--; // Mover el puntero derecho hacia la izquierda
                   
        }
        return true; // Es un palíndromo

    }



    public static void main(String[] args) {

        String frase = "reconocer" ;
        System.out.println(isPalindrome(frase)); // true
        System.out.println(isPalindrome("Anita lava la tina")); // true
        System.out.println(isPalindrome("Hola mundo malo")); // false
        
    }
    
}
