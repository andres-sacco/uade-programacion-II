package com.uade;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fibo = new Fibonacci();
        fibo.execute();
    }

    //Metodo principal de la clase
    public void execute() {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar un número al usuario
        System.out.print("Ingresa un número: ");
        int limit = scanner.nextInt();

        // Mostrar la secuencia de Fibonacci hasta el valor ingresado
        System.out.println("Secuencia de Fibonacci hasta " + limit + ":");
        printFibonacciSequence(limit);

        // Cerrar el scanner
        scanner.close();
    }

    // Método para imprimir la secuencia de Fibonacci
    private void printFibonacciSequence(int limit) {
        int actualNumber = 0;
        int nextNumber = 1;

        while (actualNumber <= limit) {
            System.out.print(actualNumber + " ");
            actualNumber = calculateNextNumber(actualNumber, nextNumber);
            nextNumber = calculateNextNumber(nextNumber, actualNumber);
        }
    }

    // Método para calcular el siguiente número en la secuencia
    private int calculateNextNumber(int a, int b) {
        return a + b;
    }
}
