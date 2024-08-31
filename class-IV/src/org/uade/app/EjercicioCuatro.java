package org.uade.app;

import org.uade.api.ColaTDA;
import org.uade.api.PilaTDA;
import org.uade.impl.ColaTDAImpl;
import org.uade.impl.PilaTDAImpl;

/*
    Dada una cola, verifica si es un palíndromo utilizando una pila.
    Una cola es un palíndromo si se lee igual de izquierda a derecha que de
    derecha a izquierda. Por ejemplo, C = [1, 2, 3, 2, 1] es un palíndromo.
 */
public class EjercicioCuatro {

    public static void main(String[] args) {
        EjercicioCuatro app = new EjercicioCuatro();
        app.execute();
    }

    public void execute() {
        // Crear e inicializar una cola
        ColaTDA cola = new ColaTDAImpl();
        cola.inicializarCola();
        cola.acolar(1);
        cola.acolar(2);
        cola.acolar(3);
        cola.acolar(2);
        cola.acolar(1);

        // Verificar si la cola es un palíndromo
        boolean resultado = esPalindromo(cola);
        if (resultado) {
            System.out.println("La cola es un palíndromo");
        } else {
            System.out.println("La cola no es un palíndromo");
        }

    }

    private boolean esPalindromo(ColaTDA cola) {
        // Crear e inicializar una pila
        PilaTDA pila = new PilaTDAImpl();
        pila.inicializarPila();

        // Crear una copia de la cola original
        ColaTDA colaCopia = new ColaTDAImpl();
        colaCopia.inicializarCola();

        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            colaCopia.acolar(elemento);
            pila.apilar(elemento);
            cola.desacolar();
        }

        // Comparar los elementos de la cola con los de la pila
        while (!cola.colaVacia() && !pila.pilaVacia()) {
            if (cola.primero() != pila.tope()) {
                return false;
            }
            cola.desacolar();
            pila.desapilar();
        }

        return true;
    }
}
