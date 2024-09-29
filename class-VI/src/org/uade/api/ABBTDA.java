package org.uade.api;

public interface ABBTDA {
    void inicializarArbol();

    int raiz();

    ABBTDA hijoIzq();

    ABBTDA hijoDer();

    void agregar (int x);

    void eliminar (int x);

    boolean arbolVacio();
}