package org.uade.app;

import org.uade.api.ColaTDA;
import org.uade.api.PilaTDA;
import org.uade.impl.ColaTDAImpl;
import org.uade.impl.PilaTDAImpl;
import org.uade.operacion.OperacionPila;
import org.uade.operacion.OperacionCola;

import java.util.Scanner;
/*
    Cree e inicialice la cola ORIGEN y la pila DESTINO.
    Cargue la cola ORIGEN. Pase los elementos de la cola ORIGEN a la pila DESTINO.
*/
public class EjercicioCuatro {

    public static void main(String[] args) {
        EjercicioCuatro ejercicioCuatro = new EjercicioCuatro();
        ejercicioCuatro.execute();
    }

    public void execute() {
        ColaTDA origen = new ColaTDAImpl();
        PilaTDA destino = new PilaTDAImpl();

        origen.inicializarCola();
        destino.inicializarPila();

        Scanner scanner = new Scanner(System.in);
        OperacionCola cola = new OperacionCola();
        cola.llenar(origen, scanner, "origen");
        scanner.close();

        while (!origen.colaVacia()) {
            destino.apilar(origen.primero());
            origen.desacolar();
        }

        OperacionPila operacionPila = new OperacionPila();
        System.out.println("Elementos en destino:");
        operacionPila.mostrar(destino);
    }
}
