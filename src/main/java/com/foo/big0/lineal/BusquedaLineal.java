package com.foo.big0.lineal;

/*
 * 🧾 Enunciado del ejercicio (búsqueda lineal)
 * Crea un metodo que reciba un array de empleados (Empleado[]) y un nombre como cadena (String nombre),
 * y devuelva el primer empleado cuyo nombre coincida con el nombre dado.
 * * Si no se encuentra ningún empleado con ese nombre, el metodo debe devolver null.
 * La búsqueda debe ser lineal, es decir, debe recorrer los elementos uno por uno desde el principio
 * hasta encontrar el primero que coincida.
 */
/*
🧠 Consideraciones clave:
    La búsqueda es case sensitive (usa .equals()).
    El array no está ordenado, por eso no puedes usar búsqueda binaria.
    Este algoritmo tiene complejidad O(N) en el peor de los casos.
    Puedes asumir que el objeto Empleado tiene al menos:
    un atributo nombre
    un atributo id
 */
public class BusquedaLineal {

    public static Empleado buscarEmpleado(Empleado[] empleados, String nombreBuscado){
        //se recorre el nombre del empleado actual con el nombre a buscar
        for (Empleado e: empleados){
            if (nombreBuscado.equals(e.getNombre())){
                return e;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Empleado[] lista= {
                new Empleado("Violetta", 001),
                new Empleado("Freyder", 002),
                new Empleado("Caramelo", 003),
                new Empleado("Erika", 004)
        };

        Empleado resultado = buscarEmpleado(lista, "Erika");
        if(resultado != null){
            System.out.println("Empleado encontrado: " + resultado);
        }else{
            System.out.println("Empleado no encontrado");
        }
    }
}
