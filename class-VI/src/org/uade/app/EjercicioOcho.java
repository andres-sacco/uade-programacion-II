package org.uade.app;

import org.uade.api.ConjuntoTDA;
import org.uade.api.PilaTDA;
import org.uade.impl.ConjuntoTDAImpl;
import org.uade.impl.PilaTDAImpl;
import org.uade.operacion.OperacionPila;

/*
Dada una pila, utiliza un conjunto para identificar y eliminar los elementos duplicados en la pila. Al final, la pila debe contener solo elementos únicos, conservando el orden original en que aparecieron.
 */
public class EjercicioOcho {

    public static void main(String[] args) {
        EjercicioOcho app = new EjercicioOcho();
        app.execute();
    }

    public void execute() {

        PilaTDA pila = new PilaTDAImpl();
        pila.inicializarPila();
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(2);
        pila.apilar(2);
        pila.apilar(5);
        pila.apilar(5);
        pila.apilar(2);

        eliminarDuplicados(pila);

        OperacionPila operacionPila = new OperacionPila();
        operacionPila.mostrar(pila);
    }

    public void eliminarDuplicados(PilaTDA pila) {
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();

        PilaTDA pilaAux = new PilaTDAImpl();
        pilaAux.inicializarPila();

        // Paso 1: Recorrer la pila original desde el tope hacia la base
        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            pila.desapilar();

            // Si el elemento no está en el conjunto, agregarlo al conjunto y a la pila auxiliar
            if (!conjunto.pertenece(elemento)) {
                conjunto.agregar(elemento);
                pilaAux.apilar(elemento);
            }
        }

        // Paso 2: Restaurar el orden de los elementos únicos en la pila original
        while (!pilaAux.pilaVacia()) {
            pila.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }
    }

}
