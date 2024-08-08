package com.uade;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {

        // Crear un objeto Random para generar el número aleatorio
        Random random = new Random();
        int secretNumber = random.nextInt(10) + 1; // Genera un número entre 1 y 100

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        int attempt;

        // Iniciar el ciclo de adivinanza
        System.out.println("Adivina el número (entre 1 y 10):");

        while (true) {
            // Solicitar un número al usuario
            System.out.print("Ingresa tu intento: ");
            attempt = scanner.nextInt();

            // Comparar el intento del usuario con el número secreto
            if (attempt < secretNumber) {
                System.out.println("El número es mayor. Intenta de nuevo.");
            } else if (attempt > secretNumber) {
                System.out.println("El número es menor. Intenta de nuevo.");
            } else {
                System.out.println("¡Felicidades! Has adivinado el número.");
                break; // Salir del ciclo cuando el número es adivinado
            }
        }

        // Cerrar el scanner
        scanner.close();
    }
}
