package org.uade.impl;

import org.uade.api.ColaTDA;

public class ColaTDAImpl implements ColaTDA {

    private int[] arr;
    private int frente;
    private int fin;

    // Inicializamos la cola con un tamaño fijo de 100 elementos
    @Override
    public void inicializarCola() {
        arr = new int[100];
        frente = 0;
        fin = 0;
    }

    // Añadimos un elemento al final de la cola
    @Override
    public void acolar(int x) {
        arr[fin] = x;
        fin++;
    }

    // Removemos el primer elemento de la cola
    @Override
    public void desacolar() {
        frente++;
    }

    // Devolvemos el primer elemento de la cola
    @Override
    public int primero() {
        return arr[frente];
    }

    // Verificamos si la cola está vacía
    @Override
    public boolean colaVacia() {
        return frente == fin;
    }
}
