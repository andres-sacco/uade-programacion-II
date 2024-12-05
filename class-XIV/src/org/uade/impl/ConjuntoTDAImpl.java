package org.uade.impl;

import org.uade.api.ConjuntoTDA;

public class ConjuntoTDAImpl implements ConjuntoTDA {
    private int[] elementos; // Arreglo para almacenar los elementos del conjunto
    private int cantidad;    // Número de elementos actuales en el conjunto

    @Override
    public void inicializarConjunto() {
        elementos = new int[100]; // Tamaño máximo del conjunto (puede ajustarse según sea necesario)
        cantidad = 0;             // Inicialmente, no hay elementos
    }

    @Override
    public void agregar(int x) {
        if (!pertenece(x) && cantidad < elementos.length) {
            elementos[cantidad] = x; // Agrega el nuevo elemento
            cantidad++;
        }
    }

    @Override
    public int elegir() {
        if (conjuntoVacio()) {
            throw new IllegalStateException("El conjunto está vacío");
        }
        return elementos[cantidad - 1]; // Devuelve cualquier elemento, aquí se usa el último
    }

    @Override
    public void sacar(int x) {
        for (int i = 0; i < cantidad; i++) {
            if (elementos[i] == x) {
                // Mover el último elemento al lugar del eliminado
                elementos[i] = elementos[cantidad - 1];
                cantidad--;
                break;
            }
        }
    }

    @Override
    public boolean pertenece(int x) {
        for (int i = 0; i < cantidad; i++) {
            if (elementos[i] == x) {
                return true; // Elemento encontrado
            }
        }
        return false; // Elemento no encontrado
    }

    @Override
    public boolean conjuntoVacio() {
        return cantidad == 0;
    }
}
