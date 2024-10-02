package org.uade.impl;

import org.uade.api.ABBTDA;

public class ABBTDAImpl implements ABBTDA {

    class nodo {
        int dato;
        ABBTDA izq, der;
    }

    nodo primer;

    @Override
    public void inicializarArbol() {
        primer = null;
    }

    @Override
    public int raiz() {
        return primer.dato;
    }

    @Override
    public ABBTDA hijoIzq() {
        return primer.izq;
    }

    @Override
    public ABBTDA hijoDer() {
        return primer.der;
    }

    @Override
    public void agregar(int x) {
        if (arbolVacio()) {
            nodo nuevo = new nodo();
            nuevo.dato = x;
            nuevo.izq = new ABBTDAImpl();
            nuevo.izq.inicializarArbol();
            nuevo.der = new ABBTDAImpl();
            nuevo.der.inicializarArbol();
            primer = nuevo;
        } else if (primer.dato > x)
            hijoIzq().agregar(x);
        else
            hijoDer().agregar(x);
    }

    @Override
    public void eliminar(int x) {
        if (!arbolVacio()) {
            if (primer.dato > x) {
                hijoIzq().eliminar(x);
            }
            else if (primer.dato < x) {
                hijoDer().eliminar(x);
            }
        }
    }

    @Override
    public boolean arbolVacio() {
        return primer == null;
    }
}
