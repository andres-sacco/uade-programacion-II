package org.uade.impl;

import org.uade.api.ABBTDA;

public class ABBTDAImpl implements ABBTDA {
    private class Nodo {
        int dato;
        Nodo hijoIzq;
        Nodo hijoDer;
    }

    private Nodo raiz;

    @Override
    public void inicializarArbol() {
        raiz = null;
    }

    @Override
    public int raiz() {
        if (arbolVacio()) {
            throw new IllegalStateException("El árbol está vacío");
        }
        return raiz.dato;
    }

    @Override
    public ABBTDA hijoIzq() {
        if (arbolVacio()) {
            throw new IllegalStateException("El árbol está vacío");
        }

        ABBTDAImpl hijoIzquierdo = new ABBTDAImpl();
        hijoIzquierdo.raiz = raiz.hijoIzq;
        return hijoIzquierdo;
    }

    @Override
    public ABBTDA hijoDer() {
        if (arbolVacio()) {
            throw new IllegalStateException("El árbol está vacío");
        }

        ABBTDAImpl hijoDerecho = new ABBTDAImpl();
        hijoDerecho.raiz = raiz.hijoDer;
        return hijoDerecho;
    }

    @Override
    public void agregar(int x) {
        raiz = agregarRecursivo(raiz, x);
    }

    private Nodo agregarRecursivo(Nodo nodo, int x) {
        if (nodo == null) {
            Nodo nuevo = new Nodo();
            nuevo.dato = x;
            return nuevo;
        }
        if (x < nodo.dato) {
            nodo.hijoIzq = agregarRecursivo(nodo.hijoIzq, x);
        } else if (x > nodo.dato) {
            nodo.hijoDer = agregarRecursivo(nodo.hijoDer, x);
        }
        return nodo; // Si x ya está en el árbol, no se agrega de nuevo.
    }

    @Override
    public void eliminar(int x) {
        raiz = eliminarRecursivo(raiz, x);
    }

    private Nodo eliminarRecursivo(Nodo nodo, int x) {
        if (nodo == null) {
            return null; // Elemento no encontrado.
        }

        if (x < nodo.dato) {
            nodo.hijoIzq = eliminarRecursivo(nodo.hijoIzq, x);
        } else if (x > nodo.dato) {
            nodo.hijoDer = eliminarRecursivo(nodo.hijoDer, x);
        } else { // Elemento encontrado
            if (nodo.hijoIzq == null) {
                return nodo.hijoDer;
            } else if (nodo.hijoDer == null) {
                return nodo.hijoIzq;
            }

            // Nodo con dos hijos: buscar el mínimo en el subárbol derecho
            nodo.dato = encontrarMinimo(nodo.hijoDer).dato;
            nodo.hijoDer = eliminarRecursivo(nodo.hijoDer, nodo.dato);
        }

        return nodo;
    }

    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.hijoIzq != null) {
            nodo = nodo.hijoIzq;
        }
        return nodo;
    }

    @Override
    public boolean arbolVacio() {
        return raiz == null;
    }
}
