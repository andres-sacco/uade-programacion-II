package org.uade.app;

import org.uade.api.PilaTDA;
import org.uade.impl.PilaTDAImpl;
import org.uade.operacion.OperacionPila;

import java.util.Scanner;
/*
    Cree e inicialice las pilas POZO, JUG1, JUG2. Cargue desde el teclado la pila POZO.
    Reparta los elementos de la pila POZO en las pilas JUG1 y JUG2 en forma alternativa.
    La pila POZO puede contener: una cantidad par de elementos, una cantidad impar de
    elementos o ningún elemento.
 */
public class EjercicioUno {

    public static void main(String[] args) {
        EjercicioUno app = new EjercicioUno();
        app.execute();
    }

    public void execute() {
        PilaTDA pozo = new PilaTDAImpl();
        PilaTDA jug1 = new PilaTDAImpl();
        PilaTDA jug2 = new PilaTDAImpl();

        pozo.inicializarPila();
        jug1.inicializarPila();
        jug2.inicializarPila();

        llenarPila(pozo);

        repartirPila(pozo, jug1, jug2);
        OperacionPila operacion = new OperacionPila();
        System.out.println("Elementos en JUG1:");
        operacion.mostrar(jug1);

        System.out.println("Elementos en JUG2:");
        operacion.mostrar(jug2);
    }

    private void llenarPila(PilaTDA pozo) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de elementos para la pila POZO:");
        int n = scanner.nextInt();

        System.out.println("Ingrese los elementos de la pila POZO:");
        for (int i = 0; i < n; i++) {
            int elemento = scanner.nextInt();
            pozo.apilar(elemento);
        }
        scanner.close();
    }

    private void repartirPila(PilaTDA pozo, PilaTDA jug1, PilaTDA jug2) {
        boolean turnoJUG = true;
        while (!pozo.pilaVacia()) {
            if (turnoJUG) {
                jug1.apilar(pozo.tope());
            } else {
                jug2.apilar(pozo.tope());
            }
            pozo.desapilar();
            turnoJUG = !turnoJUG;
        }
    }

}
