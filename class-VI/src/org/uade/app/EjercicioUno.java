package org.uade.app;

import org.uade.api.PilaTDA;
import org.uade.impl.PilaTDAImpl;
import org.uade.operacion.OperacionPila;

/*
Cree, inicialice y cargue desde el teclado la pila DADA.
Elimine los elementos repetidos de la misma dejando solamente un ejemplar de cada valor.
 */
public class EjercicioUno {

    public static void main(String[] args) {
        EjercicioUno app = new EjercicioUno();
        app.execute();
    }

    public void execute() {
        PilaTDA pila = new PilaTDAImpl();
        pila.inicializarPila();

        pila.apilar(2);
        pila.apilar(3);
        pila.apilar(5);
        pila.apilar(2);
        pila.apilar(5);
        pila.apilar(5);

        eliminarRepetidos(pila);

        OperacionPila operacion = new OperacionPila();
        operacion.mostrar(pila);
    }

    public void eliminarRepetidos(PilaTDA pila) {
        PilaTDA pilaAuxiliar = new PilaTDAImpl(); // Pila auxiliar para almacenar los elementos únicos
        PilaTDA pilaTemporal = new PilaTDAImpl(); // Pila temporal para comparar elementos
        pilaAuxiliar.inicializarPila();
        pilaTemporal.inicializarPila();

        while (!pila.pilaVacia()) {
            int elementoActual = pila.tope();
            pila.desapilar();

            boolean esRepetido = false;
            // Revisar si el elemento ya está en la pila auxiliar
            while (!pilaAuxiliar.pilaVacia()) {
                int elementoAux = pilaAuxiliar.tope();
                pilaAuxiliar.desapilar();
                pilaTemporal.apilar(elementoAux);

                if (elementoAux == elementoActual) {
                    esRepetido = true;
                }
            }

            // Restaurar los elementos a la pila auxiliar
            while (!pilaTemporal.pilaVacia()) {
                pilaAuxiliar.apilar(pilaTemporal.tope());
                pilaTemporal.desapilar();
            }

            // Si no es repetido, lo añadimos a la pila auxiliar
            if (!esRepetido) {
                pilaAuxiliar.apilar(elementoActual);
            }
        }

        // Restauramos los elementos únicos en la pila original
        while (!pilaAuxiliar.pilaVacia()) {
            pila.apilar(pilaAuxiliar.tope());
            pilaAuxiliar.desapilar();
        }
    }

}