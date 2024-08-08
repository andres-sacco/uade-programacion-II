package com.uade;

import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar el primer número
        System.out.print("Ingresa el primer número: ");
        int numberOne = scanner.nextInt();

        // Solicitar el segundo número
        System.out.print("Ingresa el segundo número: ");
        int numberSecond = scanner.nextInt();

        // Sumar los números
        int sum = numberOne + numberSecond;

        // Mostrar el resultado
        System.out.println("La suma de " + numberOne + " y " + numberSecond + " es: " + sum);

        // Cerrar el scanner
        scanner.close();
    }
}
