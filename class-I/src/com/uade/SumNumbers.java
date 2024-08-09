package com.uade;

import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        SumNumbers sum = new SumNumbers();
        sum.execute();
    }

    //Metodo principal de la clase
    public void execute() {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar y leer dos números del usuario
        int numberOne = getNumberFromUser(scanner, "Ingresa el primer número: ");
        int numberSecond = getNumberFromUser(scanner, "Ingresa el segundo número: ");

        // Sumar los números y mostrar el resultado
        int sum = sumNumbers(numberOne, numberSecond);
        displayResult(numberOne, numberSecond, sum);

        // Cerrar el scanner
        scanner.close();
    }

    // Método para solicitar un número al usuario
    private int getNumberFromUser(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    // Método para sumar dos números
    private int sumNumbers(int a, int b) {
        return a + b;
    }

    // Método mostrar el resultado de la suma
    private void displayResult(int numberOne, int numberSecond, int sum) {
        System.out.println("La suma de " + numberOne + " y " + numberSecond + " es: " + sum);
    }
}
