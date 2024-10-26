package org.uade.operacion;

import org.uade.api.ColaPrioridadTDA;
import org.uade.api.ColaTDA;
import org.uade.impl.ColaTDAImpl;

import java.util.Scanner;

public class OperacionCola {

    public void mostrar(ColaPrioridadTDA cola) {
        while (!cola.colaVacia()) {
            System.out.println(cola.primero());
            cola.desacolar();
        }
    }

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

    public ColaTDA copiarCola(ColaTDA colaOriginal) {
        ColaTDA colaCopia = new ColaTDAImpl();


        return colaCopia;
    }
}