package org.uade.app;

import org.uade.api.PilaTDA;
import org.uade.impl.PilaTDAImpl;
import org.uade.operacion.OperacionPila;

import java.util.Scanner;

/*
    Cree e inicialice las pilas MOD y DADA. Cargue desde teclado las pilas DADA y MOD.
    Elimine de la pila DADA todos los elementos que sean iguales a los elementos de la pila MOD.
 */
public class EjercicioDos {

    public static void main(String[] args) {
        EjercicioDos app = new EjercicioDos();
        app.execute();
    }

    public void execute() {
        PilaTDA dada = new PilaTDAImpl();
        PilaTDA mod = new PilaTDAImpl();

        dada.inicializarPila();
        mod.inicializarPila();

        //Llenado de pilas
        OperacionPila operacion = new OperacionPila();
        Scanner scanner = new Scanner(System.in);
        operacion.llenar(dada, scanner, "dada");
        operacion.llenar(mod, scanner, "mod");
        scanner.close();

        repartirPila(dada, mod, operacion);

        System.out.println("Elementos en DADA:");
        operacion.mostrar(dada);

        System.out.println("Elementos en MOD:");
        operacion.mostrar(mod);
    }

    private void repartirPila(PilaTDA dada, PilaTDA mod, OperacionPila operacion) {
        // Pila temporal para almacenar elementos no eliminados
        PilaTDA temporal = new PilaTDAImpl();
        temporal.inicializarPila();

        // Eliminar de DADA todos los elementos que sean iguales a los de MOD
        while (!dada.pilaVacia()) {
            int elementoDada = dada.tope();
            dada.desapilar();

            if (!operacion.contieneElemento(mod, elementoDada)) {
                temporal.apilar(elementoDada);
            }
        }

        // Reconstruir la pila DADA con los elementos restantes
        while (!temporal.pilaVacia()) {
            dada.apilar(temporal.tope());
            temporal.desapilar();
        }
    }

}
