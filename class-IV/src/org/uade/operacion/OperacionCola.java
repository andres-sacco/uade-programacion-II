package org.uade.operacion;

import org.uade.api.ColaTDA;

import java.util.Scanner;

public class OperacionCola {

    public void mostrar(ColaTDA cola) {
        while (!cola.colaVacia()) {
            System.out.println(cola.primero());
            cola.desacolar();
        }
    }

    public void llenar(ColaTDA cola, Scanner scanner, String nombre) {
        System.out.println("Ingrese la cantidad de elementos para la cola " + nombre + ":");
        int n = scanner.nextInt();

        System.out.println("Ingrese los elementos de la cola " + nombre + ":");
        for (int i = 0; i < n; i++) {
            int elemento = scanner.nextInt();
            cola.acolar(elemento);
        }
    }
}
