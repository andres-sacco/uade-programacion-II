package org.uade.operacion;

import org.uade.api.PilaTDA;
import org.uade.impl.PilaTDAImpl;

import java.util.Scanner;

public class OperacionPila {

    public static void mostrarPila(PilaTDA pila) {
        if (pila.pilaVacia()) {
            System.out.println("La pila está vacía.");
            return;
        }

        PilaTDA pilaAux = new PilaTDAImpl();
        pilaAux.inicializarPila();

        // Paso 1: Transferir los elementos a la pila auxiliar mientras se imprimen
        System.out.print("Contenido de la pila: ");
        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            System.out.print(elemento + " ");
            pilaAux.apilar(elemento);
            pila.desapilar();
        }
        System.out.println();  // Nueva línea al final

        // Paso 2: Restaurar la pila original
        while (!pilaAux.pilaVacia()) {
            pila.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }
    }

    public void llenar(PilaTDA pila, Scanner scanner, String nombre) {
        System.out.println("Ingrese la cantidad de elementos para la pila " + nombre + ":");
        int n = scanner.nextInt();

        System.out.println("Ingrese los elementos de la pila " + nombre + ":");
        for (int i = 0; i < n; i++) {
            int elemento = scanner.nextInt();
            pila.apilar(elemento);
        }
    }

    public boolean contieneElemento(PilaTDA mod, int elementoDada) {
        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();

        boolean encontrado = false;

        while (!mod.pilaVacia()) {
            int elementoMod = mod.tope();
            mod.desapilar();

            if (elementoMod == elementoDada) {
                encontrado = true;
            }

            aux.apilar(elementoMod);
        }

        while (!aux.pilaVacia()) {
            mod.apilar(aux.tope());
            aux.desapilar();
        }

        return encontrado;
    }

    public void pasarPila(PilaTDA origen, PilaTDA destino) {
        while (!origen.pilaVacia()) {
            destino.apilar(origen.tope());
            origen.desapilar();
        }
    }

    public int contarElementos(PilaTDA pila) {
        int contador = 0;

        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();

        while (!pila.pilaVacia()) {
            aux.apilar(pila.tope());
            pila.desapilar();
            contador++;
        }

        while (!aux.pilaVacia()) {
            pila.apilar(aux.tope());
            aux.desapilar();
        }

        return contador;
    }

    public void copiarPila(PilaTDA origen, PilaTDA destino) {
        PilaTDA auxiliar = new PilaTDAImpl();
        auxiliar.inicializarPila();

        // Desapilamos la pila de origen en una pila auxiliar
        while (!origen.pilaVacia()) {
            auxiliar.apilar(origen.tope());
            origen.desapilar();
        }

        // Apilamos de nuevo en el destino para mantener el orden original
        while (!auxiliar.pilaVacia()) {
            destino.apilar(auxiliar.tope());
            auxiliar.desapilar();
        }
    }
}
