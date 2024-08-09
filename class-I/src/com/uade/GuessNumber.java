package com.uade;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {
        GuessNumber guess = new GuessNumber();
        guess.execute();
    }

    //Metodo principal de la clase
    public void execute() {
        // Generar el número secreto
        int secretNumber = generateSecretNumber();

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Iniciar el ciclo de adivinanza
        System.out.println("Adivina el número (entre 1 y 10):");
        startGuessingGame(scanner, secretNumber);

        // Cerrar el scanner
        scanner.close();
    }

    // Método para generar el número secreto
    private static int generateSecretNumber() {
        Random random = new Random();
        return random.nextInt(10) + 1; // Genera un número entre 1 y 10
    }

    // Método para iniciar el ciclo de adivinanza
    private void startGuessingGame(Scanner scanner, int secretNumber) {
        int attempt;
        while (true) {
            attempt = getUserAttempt(scanner);
            if (isCorrectGuess(attempt, secretNumber)) {
                System.out.println("¡Felicidades! Has adivinado el número.");
                break;
            } else {
                giveHint(attempt, secretNumber);
            }
        }
    }

    // Método para solicitar un intento al usuario
    private int getUserAttempt(Scanner scanner) {
        System.out.print("Ingresa tu intento: ");
        return scanner.nextInt();
    }

    // Método para verificar si el intento es correcto
    private boolean isCorrectGuess(int attempt, int secretNumber) {
        return attempt == secretNumber;
    }

    // Método para dar una pista al usuario
    private void giveHint(int attempt, int secretNumber) {
        if (attempt < secretNumber) {
            System.out.println("El número es mayor. Intenta de nuevo.");
        } else {
            System.out.println("El número es menor. Intenta de nuevo.");
        }
    }
}
