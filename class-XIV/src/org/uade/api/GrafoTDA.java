package org.uade.api;

public interface GrafoTDA {

    void inicializarGrafo();

    void agregarVertice(int vertice);

    void eliminarVertice(int vertice);

    ConjuntoTDA vertices();

    void agregarArista( int v1, int v2, int peso);

    void eliminarArista(int v1, int v2);

    boolean existeArista(int v1, int v2);

    int pesoArista(int v1, int v2);
}
