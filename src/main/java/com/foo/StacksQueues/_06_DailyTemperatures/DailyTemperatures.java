package com.foo.StacksQueues._06_DailyTemperatures;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 💡 Enunciado resumido – Daily Temperatures
Dado un arreglo[ ] de temperaturas, debes devolver un nuevo 
arreglo[ ] result, donde result[i] indica cuántos días hay 
que esperar después del día i para encontrar una temperatura mayor.
Si no hay una temperatura mayor en el futuro, colocas 0.
🧠 Ejemplo
 dias    0    1   2   3   4   5   6   7
Input:  [73, 74, 75, 71, 69, 72, 76, 73]
Output: [1, 1, 4, 2, 1, 1, 0, 0]
Por ejemplo:
	• Día 0: 73 → al día siguiente hay 74 → espera = 1
	• Día 1: 74 → 75 llega en 1 día → espera = 1
	• Día 2: 75 → 76 llega en 4 días → espera = 4
 */
public class DailyTemperatures {
    public static int[] getTemperatures(int[] temp){
        int[] result = new int[temp.length];// inicializamos el arreglo de resultados con ceros
        Deque<Integer> stackDays = new ArrayDeque<>();//pila almacena los indices de los dias

        for (int i = 0; i < temp.length; i++) {
            while (!stackDays.isEmpty() && temp[i] > temp[stackDays.peek()]) {
                // prevIndex: es un entero que representa un indice de la pila stackDays
                int prevIndex = stackDays.pop(); // sacamos el indice del día anterior
                result[prevIndex] = i - prevIndex;//calculamos cuantos dias pasaron hasta una temperatura mayor
            }
            stackDays.push(i);//Guardamos el indice del dia actual en la pila
        }
        return result;
    }
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73 };
        int[] result = getTemperatures(temperatures);
        for (int days : result) {
            System.out.println(days + " ");
        }
    }
}
