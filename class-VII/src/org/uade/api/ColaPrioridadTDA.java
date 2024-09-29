package org.uade.api;

public interface ColaPrioridadTDA {
    void inicializarCola();

    void acolarPrioridad(int x, int p);

    void desacolar();

    int primero();

    boolean colaVacia();

    int prioridad();
}
