# 📌 N-th Node to Last (Linked List)

Este ejercicio consiste en retornar el nodo que se encuentra en la posición **N desde el final** de una lista enlazada simple.

## 🧠 Enunciado

> Dada una lista enlazada simple y un valor N, devuelve el nodo N empezando por el final.

### Ejemplo:

Lista: `1 → 2 → 4 → 6`, N = 2  
🔄 Resultado esperado: `4` (el segundo nodo desde el final)

---

## ✅ Soluciones implementadas

| Versión                  | Técnica utilizada         | Recorridos | Complejidad Tiempo | Espacio | Archivo                          |
|--------------------------|----------------------------|------------|--------------------|---------|----------------------------------|
| Versión 1: Dos pasadas   | Cálculo de longitud + loop | 2          | O(n)               | O(1)    | `NthNodeToLast.java`             |
| Versión 2: Una pasada    | Two pointers (fast/slow)   | 1          | O(n)               | O(1)    | `NthNodeToLastWithPointers.java`|

---

## 🧪 Notas

- La segunda versión es más eficiente en entrevistas porque solo requiere **una pasada** por la lista.
- Ambas versiones devuelven `null` si el valor de `n` es inválido (mayor a la longitud o menor a 1).
- Ambas soluciones están probadas desde el método `main()` con listas de ejemplo.

---

## ✍️ Autor

Ejercicios resueltos y documentados por Freyder Otálvaro como parte de su preparación para entrevistas técnicas.
