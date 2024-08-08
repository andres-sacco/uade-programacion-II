package com.uade;

import java.util.Scanner;

public class CheckPair {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar un número al usuario
        System.out.print("Ingresa un número: ");
        int number = scanner.nextInt();

        // Verificar si el número es par o impar
        if (number % 2 == 0) {
            System.out.println("El número " + number + " es par.");
        } else {
            System.out.println("El número " + number + " es impar.");
        }

        // Cerrar el scanner
        scanner.close();
    }
}
