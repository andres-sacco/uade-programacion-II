package org.uade.app;

import org.uade.api.ColaTDA;
import org.uade.impl.ColaTDAImpl;
import org.uade.operacion.OperacionCola;

import java.util.Scanner;

/*
    Cree e inicialice la cola DADA. Cargue desde el teclado la cola DADA con al menos un elemento.
    Pase el primer elemento de la cola DADA a su última posición, dejando los restantes
    elementos en el orden original.
 */
public class EjercicioCinco {

    public static void main(String[] args) {
        EjercicioCinco cinco = new EjercicioCinco();
        cinco.execute();
    }

    public void execute() {
        ColaTDA dada = new ColaTDAImpl();
        dada.inicializarCola();

        Scanner scanner = new Scanner(System.in);
        OperacionCola operacion = new OperacionCola();
        operacion.llenar(dada, scanner, "dada");
        scanner.close();

        ColaTDA aux = new ColaTDAImpl();
        aux.inicializarCola();

        int primero = dada.primero();
        dada.desacolar();
        dada.acolar(primero);
    }
}
