package org.uade.app;

import org.uade.api.PilaTDA;
import org.uade.impl.PilaTDAImpl;
import org.uade.operacion.OperacionPila;

import java.util.Scanner;

/*
    Cree e inicialice la pila DADA. Cargue desde el teclado la pila DADA con al menos un elemento.
    Pase el primer elemento de la pila DADA a su última posición, dejando los restantes
    elementos en el orden original.
 */
public class EjercicioSeis {

    public static void main(String[] args) {
        EjercicioSeis seis = new EjercicioSeis();
        seis.execute();
    }

    public void execute() {
        PilaTDA dada = new PilaTDAImpl();
        dada.inicializarPila();

        Scanner scanner = new Scanner(System.in);
        OperacionPila operacion = new OperacionPila();
        operacion.llenar(dada, scanner, "dada");
        scanner.close();

        int tope = dada.tope();
        dada.desapilar();

        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();

        while (!dada.pilaVacia()) {
            aux.apilar(dada.tope());
            dada.desapilar();
        }

        aux.apilar(tope);
        while (!aux.pilaVacia()) {
            dada.apilar(aux.tope());
            aux.desapilar();
        }

        System.out.println("Elementos en dada:");
        operacion.mostrar(dada);
    }
}
