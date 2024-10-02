package org.uade.api;

public interface MinHeapTDA {
    void inicializarHeap();

    void agregar(int x);

    void sacar();

    boolean heapVacio();

    int primero();
}
