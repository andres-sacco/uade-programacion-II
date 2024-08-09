package com.uade;

import java.util.Scanner;

public class CheckPair {

    public static void main(String[] args) {
        CheckPair checkPair = new CheckPair();
        checkPair.execute();
    }

    //Metodo principal de la clase
    public void execute() {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar un número al usuario
        System.out.print("Ingresa un número: ");
        int number = scanner.nextInt();

        checkNumber(number);

        // Cerrar el scanner
        scanner.close();
    }

    private void checkNumber(int number) {
        // Verificar si el número es par o impar
        if (number % 2 == 0) {
            System.out.println("El número " + number + " es par.");
        } else {
            System.out.println("El número " + number + " es impar.");
        }
    }
}
