package org.uade.api;

public interface MaxHeapTDA {

    void inicializarHeap();

    void agregar(int x);

    void sacar();

    boolean heapVacio();

    int primero();
}
