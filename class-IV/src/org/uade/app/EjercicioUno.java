package org.uade.app;

import org.uade.api.ColaTDA;
import org.uade.impl.ColaTDAImpl;
import org.uade.operacion.OperacionCola;

import java.util.Scanner;

/*
    Dado dos colas, escribi un programa que las intercale.
    Por ejemplo, si tenes la cola A = [1, 3, 5] y la cola B = [2, 4, 6],
    el resultado debería ser una nueva cola C = [1, 2, 3, 4, 5, 6].
 */
public class EjercicioUno {

    public static void main(String[] args) {
        EjercicioUno app = new EjercicioUno();
        app.execute();
    }

    public void execute() {
        ColaTDA colaA = new ColaTDAImpl();
        ColaTDA colaB = new ColaTDAImpl();
        colaA.inicializarCola();
        colaB.inicializarCola();

        Scanner scanner = new Scanner(System.in);
        OperacionCola operacion = new OperacionCola();
        operacion.llenar(colaA, scanner, "colaA");
        operacion.llenar(colaB, scanner, "colaB");
        scanner.close();

        // Intercalamos las colas
        ColaTDA colaC = intercalarColas(colaA, colaB);
        operacion.mostrar(colaC);
    }

    private ColaTDA intercalarColas(ColaTDA colaA, ColaTDA colaB) {
        ColaTDA colaC = new ColaTDAImpl();
        colaC.inicializarCola();

        // Mientras alguna de las colas A o B no esté vacía
        while (!colaA.colaVacia() || !colaB.colaVacia()) {
            if (!colaA.colaVacia()) {
                colaC.acolar(colaA.primero());
                colaA.desacolar();
            }
            if (!colaB.colaVacia()) {
                colaC.acolar(colaB.primero());
                colaB.desacolar();
            }
        }
        return colaC;
    }
}
