package org.uade.app;

public class EjercicioCero {

    public static void main(String[] args) {
        int[] arreglo = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int maximo = encontrarMaximo(arreglo, 0, arreglo.length - 1);
        System.out.println("El máximo elemento del arreglo es: " + maximo);

        int suma = sumarElementos(arreglo, 0);
        System.out.println("La suma del arreglo es: " + suma);

        double promedio = calcularPromedio(arreglo);
        System.out.println("El promedio de los elementos del arreglo es: " + promedio);
    }

    // Metodo recursivo para encontrar el máximo elemento
    public static int encontrarMaximo(int[] arreglo, int inicio, int fin) {
        // Caso base: si el rango tiene un solo elemento
        if (inicio == fin) {
            return arreglo[inicio];
        }

        // Dividir el arreglo en dos mitades
        int medio = (inicio + fin) / 2;

        // Encontrar el máximo en la primera mitad
        int maxPrimeraMitad = encontrarMaximo(arreglo, inicio, medio);

        // Encontrar el máximo en la segunda mitad
        int maxSegundaMitad = encontrarMaximo(arreglo, medio + 1, fin);

        // Retornar el mayor de los dos máximos encontrados
        return Math.max(maxPrimeraMitad, maxSegundaMitad);
    }

    // Metodo recursivo para sumar los elementos del arreglo
    public static int sumarElementos(int[] arreglo, int indice) {
        // Caso base: si el índice está fuera del rango del arreglo
        if (indice >= arreglo.length) {
            return 0;
        }

        // Sumar el elemento actual y llamar recursivamente para el siguiente elemento
        return arreglo[indice] + sumarElementos(arreglo, indice + 1);
    }

    // Función para calcular el promedio de los elementos del arreglo
    public static double calcularPromedio(int[] arreglo) {
        if (arreglo.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío");
        }
        int suma = sumarElementos(arreglo, 0);
        return (double) suma / arreglo.length;
    }
}
