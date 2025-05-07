package com.foo.matrices;
/*
 * 📌 El ejercicio que aparece en la imagen es:

    Dada una matriz, escribe un algoritmo para establecer ceros en 
    la fila F y columna C si existe un 0 en la celda F:C

        Input:
        2 1 3 0 8         
        7 4 1 3 8        
        4 0 1 2 1        
        9 3 4 1 9        

        Output:
        0 0 0 0 0
        7 0 1 0 8
        0 0 0 0 0
        9 0 4 0 9
 */
public class ZeroMatrix {

    public static void main(String[] args) {
        ZeroMatrix zeroMatrix = new ZeroMatrix();

        int[][] matrix = {
            {2, 1, 3, 0, 8},
            {7, 4, 1, 3, 8},
            {4, 0, 1, 2, 1},
            {9, 3, 4, 1, 9}
        };

        System.out.println("🔹 Matriz original:");
        printMatrix(matrix);

        zeroMatrix.zeroMatrix(matrix);

        System.out.println("\n🔹 Matriz después de aplicar zeroMatrix:");
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }


    public void zeroMatrix(int[][] matrix) {
        /*
         * 🔹 Paso 1: Verificar si la primera fila o columna tiene ceros
         * ✅ Estas dos funciones sirven para detectar si ya existían ceros originales 
         * en la primera fila o columna, antes de usarlas como espacio auxiliar.
         */
        boolean firstRowHasZero = hasFirstRowAnyZero(matrix);
        boolean firstColHasZero = hasFirstColAnyZero(matrix);
        //🔹 Paso 2: Marcar en la primera fila y columna si se encuentra un cero
        chekForZeroes(matrix);
        
        //🔹 Paso 3: Procesar filas marcadas
        processRows(matrix);
        processColumns(matrix);
        /*
          Para finalizar tenemos q comprobar si la primera fila y la primera columna 
          tenian 0 ceros establecerlas a 0 ceros
         */
        if( firstRowHasZero ){
            setRowToZero(matrix, 0); 
        }
        if( firstColHasZero ){
            setColToZero(matrix, 0); 
        }

    }

    /**
     * Verifica si la primera fila de la matriz contiene al menos un cero.
     *
     * Esta función recorre la primera fila (índice 0) de la matriz dada
     * y retorna {@code true} tan pronto como encuentra un elemento con valor cero.
     * Esto es importante porque la primera fila será utilizada posteriormente
     * como espacio auxiliar para marcar columnas que deben establecerse a cero,
     * por lo tanto, necesitamos saber si tenía ceros desde el inicio.
     *
     * @param matrix la matriz de entrada a evaluar (matriz de enteros)
     * @return {@code true} si existe al menos un 0 en la primera fila;
     *         {@code false} en caso contrario
     */
    private boolean hasFirstRowAnyZero(int[][] matrix) {
        /*
        tenemos que recorrer la primera fila comprobando si tiene algun 0
        👉 matrix[0] es la primera fila: matrix[0] = {2, 1, 3, 0, 8}
        Entonces, matrix[0].length da la cantidad de columnas (o sea, cuántos elementos 
        tiene esa fila).
         */
        for (int i = 0; i < matrix[0].length; i++) {
            /*
            matrix[0][i]: es el acceso al elemento en la fila 0 y columna i.
                i = 0 → matrix[0][0] = 2 → no es 0  
                i = 1 → matrix[0][1] = 1 → no es 0  
                i = 2 → matrix[0][2] = 3 → no es 0  
                i = 3 → matrix[0][3] = 0 → ¡sí es 0! → return true ✅
             */
            if (matrix[0][i] == 0)
                return true;
            // si al finalizar este👆 procesamiento no encontramos ningun 0
        }
        return false;
    }
    
    /**
     * Verifica si la primera columna de la matriz contiene al menos un cero.
     *
     * Esta función recorre la columna de índice 0, evaluando cada fila de la matriz.
     * Retorna {@code true} si detecta un cero en alguna celda de esa columna.
     * Esto es importante para saber si la primera columna debe establecerse 
     * completamente a ceros al final del procesamiento.
     *
     * @param matrix la matriz de entrada a evaluar (matriz de enteros)
     * @return {@code true} si existe al menos un 0 en la primera columna;
     *         {@code false} en caso contrario
    */
    private boolean hasFirstColAnyZero(int[][] matrix) {
        // tenemos que recorrer la primera fila comprobando si tiene algun 0
        //matrix.length → número de filas
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0)
                return true;
            // si al finalizar este👆 procesamiento no encontramos ningun 0
        }
        return false;
    }
    
    /**
     *
     * Recorre la matriz para detectar ceros y marca las filas y columnas
     * correspondientes en la primera fila y primera columna.
     *
     * Este metodo ignora la primera fila y primera columna durante el recorrido
     * ya que estas serán usadas como espacio auxiliar para registrar en qué
     * filas y columnas se debe establecer ceros en un paso posterior.
     *
     * Si encuentra un cero en la posición (i, j), marca:
     * - matrix[i][0] = 0 → indica que la fila i debe ser puesta en ceros
     * - matrix[0][j] = 0 → indica que la columna j debe ser puesta en ceros
     *
     * @param matrix la matriz que se va a analizar y marcar
     * 
     *  2 1 3 0 8        
        7 4 1 3 8        
        4 0 1 2 1        
        9 3 4 1 9        
     */
    private void chekForZeroes(int[][]  matrix){
     // se procesara desde la segunda fila y desde la segunda columna ya que las primeras ya fueron procesadas
     // tenemos que recorrer con 2 bucles for los elementos de toda la matriz
        for(int row= 1; row < matrix.length; row++){ 
            for(int col= 1; col < matrix[0].length; col++){ // usar matrix[0].length para columnas
                if (matrix[row][col] == 0) { //4 0 1 2 1
                    //tenemos que marcar la primera fila y la primera columna:
                    matrix[row][0]=0; // 4 0 1 2 1 ➡ 0 0 1 2 1
                    matrix[0][col]=0; // 2 1 3 0 8 ➡ 0 1 3 0 8
                    
                }
            }

        }

    }

    //Nos queda procesar nuestras filas y nuestras columnas

    //*Filas
    /*
    Funcion que comprueba la primera fila y la primera columna en busca de 0 ceros
    para establecer toda la fila o columna a 0 ceros segun corresponda
     */
    private void processRows(int[][]matrix){
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0]==0) {
                setRowToZero(matrix, row);//establecemos toda esa fila a 0 ceros
            }
        }
    }
    /*Una funcion para las filas, para establecer una fila entera a 0 */
    private void setRowToZero(int[][]matrix, int row){
        for (int col = 0; col < matrix[0].length; col++) {
            matrix[row][col]=0;
        }
    }

    //*Columnas
    private void processColumns(int[][]matrix){
        for (int col = 0; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                setColToZero(matrix, col); //establecemos  toda esa columna a 0 ceros
            }
        }
    }
    /*Una funcion para las columnas, para establecer una columna entera a 0 */
    private void setColToZero(int[][]matrix, int col){
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][col]=0;
        }
    }


}
