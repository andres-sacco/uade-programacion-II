package org.uade.operacion;

import org.uade.api.ColaPrioridadTDA;
import org.uade.api.ColaTDA;
import org.uade.impl.ColaTDAImpl;

import java.util.Scanner;

public class OperacionCola {

    public void mostrar(ColaPrioridadTDA cola) {
        while (!cola.colaVacia()) {
            System.out.println(cola.primero());
            cola.desacolar();
        }
    }

    public void mostrar(ColaTDA cola) {
        while (!cola.colaVacia()) {
            System.out.println(cola.primero());
            cola.desacolar();
        }
    }

}
