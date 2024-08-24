package org.uade.api;

public interface ColaTDA {
    void inicializarCola();

    void acolar(int x);

    void desacolar();

    int primero();

    boolean colaVacia();
}
