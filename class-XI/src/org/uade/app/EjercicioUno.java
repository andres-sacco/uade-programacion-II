package org.uade.app;

import org.uade.api.ColaTDA;
import org.uade.impl.ColaTDAImpl;
import org.uade.operacion.OperacionCola;

/*
Dada una cola, rota sus elementos N posiciones a la izquierda.
*/
public class EjercicioUno {

    public static void main(String[] args) {
        EjercicioUno app = new EjercicioUno();
        app.execute();
    }
    
    public void execute() {
        ColaTDA cola = new ColaTDAImpl();
        cola.inicializarCola();
        cola.acolar(1);
        cola.acolar(2);
        cola.acolar(3);
        cola.acolar(4);

        rotarColaIzquierda(cola, 2);

        OperacionCola operacion = new OperacionCola();
        operacion.mostrar(cola);
    }

    public void rotarColaIzquierda(ColaTDA cola, int n) {

        int cantidadElementos = contarElementos(cola); // Contamos la cantidad de elementos en la cola
        n = n % cantidadElementos; // Si N es mayor que la cantidad de elementos, evitamos rotaciones innecesarias

        for (int i = 0; i < n; i++) {
            int primero = cola.primero();  // Obtenemos el primer elemento
            cola.desacolar();              // Desacolamos el primer elemento
            cola.acolar(primero);          // Lo colocamos al final de la cola
        }
    }

    private int contarElementos(ColaTDA cola) {
        ColaTDA aux = new ColaTDAImpl(); // Cola auxiliar para no perder los elementos
        aux.inicializarCola();
        int contador = 0;

        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            cola.desacolar();
            aux.acolar(elemento);
            contador++;
        }

        // Restauramos la cola original
        while (!aux.colaVacia()) {
            int elemento = aux.primero();
            aux.desacolar();
            cola.acolar(elemento);
        }

        return contador;
    }

}