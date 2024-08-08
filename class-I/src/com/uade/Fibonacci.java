package com.uade;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar un número al usuario
        System.out.print("Ingresa un número: ");
        int limit = scanner.nextInt();

        // Variables para almacenar los dos primeros números de la secuencia
        int actualNumber = 0, nextNumber = 1;

        System.out.println("Secuencia de Fibonacci hasta " + limit + ":");

        // Mostrar los números de Fibonacci hasta el valor ingresado
        while (actualNumber <= limit) {
            System.out.print(actualNumber + " ");

            // Calcular el siguiente número en la secuencia
            int next = actualNumber + nextNumber;
            actualNumber = nextNumber;
            nextNumber = next;
        }

        // Cerrar el scanner
        scanner.close();
    }
}
